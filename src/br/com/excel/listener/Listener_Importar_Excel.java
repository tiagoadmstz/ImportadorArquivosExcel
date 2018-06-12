/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.listener;

import br.com.excel.dal.DAO_DerbyDb;
import br.com.excel.entities.Row_Excel;
import br.com.excel.entities.Tabela_BD;
import br.com.excel.entities.Tabela_Excel;
import br.com.excel.frames.Form_Importar_Excel;
import br.com.excel.interfaces.DAO_Util;
import br.com.excel.tablemodel.TableModel_ExcelColumn;
import br.com.excel.tablemodel.TableModel_TabDestino;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tiago.teixeira
 */
public class Listener_Importar_Excel implements ActionListener {

    private final Form_Importar_Excel form;
    private final int DERBYDB = 0, MYSQL = 1, POSTGRE = 2, ORACLE = 3;
    private DAO_Util dao;
    private TableModel_TabDestino modelTbDestino_1;
    private TableModel_TabDestino modelTbDestino_2;
    private TableModel_ExcelColumn modelExcel;
    private final List<Tabela_BD> tabelasSelecionadas = new ArrayList();
    private final Tabela_Excel excel = new Tabela_Excel();
    private File arquivoDados;

    public Listener_Importar_Excel(Form_Importar_Excel form) {
        this.form = form;
        initComponents();
    }

    private void initComponents() {
        attachListeners();
        addModel();
    }

    private void initDao() {
        if (form.getCbDriver().getSelectedIndex() == DERBYDB) {
            dao = new DAO_DerbyDb(form.getCbDriver().getSelectedItem().toString(),
                    form.getTxtEnderecoBanco().getText(),
                    form.getTxtUsuarioBanco().getText(),
                    String.valueOf(form.getTxtPasswordBanco().getPassword()));
        }
    }

    private void attachListeners() {
        form.getListaBotoes().forEach(bt -> ((AbstractButton) bt).addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent acEvent) {
        switch (acEvent.getActionCommand()) {
            case "testarConexao":
                testarConexao();
                break;
            case "selecionarArquivo":
                selecionarArquivo();
                break;
            case "carregarTabelas":
                if (modelTbDestino_1.getLista().isEmpty() && tabelasSelecionadas.isEmpty()) {
                    carregarTabelas();
                }
                break;
            case "addTabelaDestino":
                addTabelaDestino();
                break;
            case "removeTabelaDestino":
                removerTabela();
                break;
            case "addTodas":
                addTodasTabelas();
                break;
            case "removerTodas":
                removerTodasTabelas();
                break;
        }
    }

    private void addModel() {
        modelTbDestino_1 = new TableModel_TabDestino();
        modelTbDestino_2 = new TableModel_TabDestino(tabelasSelecionadas);
        modelExcel = new TableModel_ExcelColumn();
        form.getTbTabelaDestOpcao().setModel(modelTbDestino_1);
        form.getTbTabelaDestSelecionada().setModel(modelTbDestino_2);
    }

    private void testarConexao() {
        boolean result = false;
        try {
            initDao();
            result = dao.testarConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
            form.getLbRespostaTesteConexao().setForeground(Color.blue);
            form.getLbRespostaTesteConexao().setText("Conexão realizada com sucesso!!!");
        } else {
            form.getLbRespostaTesteConexao().setForeground(Color.red);
            form.getLbRespostaTesteConexao().setText("Ocorreu um erro ao tentar conectar ao banco de dados!!!");
        }
    }

    private void carregarTabelas() {
        if (dao == null) {
            initDao();
        }
        modelTbDestino_1.deletarLista();
        modelTbDestino_1.addLista(Arrays.asList(dao.getTabelasDB()));
    }

    private void addTabelaDestino() {
        if (form.getTbTabelaDestOpcao().getSelectedRowCount() == 1) {
            Tabela_BD tabela = modelTbDestino_1.getObject(form.getTbTabelaDestOpcao().getSelectedRow());
            modelTbDestino_2.addObject(tabela);
            modelTbDestino_1.removeObject(tabela);
        } else if (form.getTbTabelaDestOpcao().getSelectedRowCount() > 1) {
            List<Tabela_BD> tabela = modelTbDestino_1.getObjects(form.getTbTabelaDestOpcao().getSelectedRows());
            modelTbDestino_2.addLista(tabela);
            modelTbDestino_1.deletarObjects(tabela);
        }
    }

    private void addTodasTabelas() {
        modelTbDestino_2.addLista(modelTbDestino_1.getLista());
        modelTbDestino_1.deletarLista();
    }

    private void removerTabela() {
        if (form.getTbTabelaDestSelecionada().getSelectedRowCount() == 1) {
            Tabela_BD tabela = modelTbDestino_2.getObject(form.getTbTabelaDestSelecionada().getSelectedRow());
            modelTbDestino_1.addObject(tabela);
            modelTbDestino_2.removeObject(tabela);
        } else if (form.getTbTabelaDestSelecionada().getSelectedRowCount() > 1) {
            List<Tabela_BD> tabela = modelTbDestino_2.getObjects(form.getTbTabelaDestSelecionada().getSelectedRows());
            modelTbDestino_1.addLista(tabela);
            modelTbDestino_2.deletarObjects(tabela);
        }
    }

    private void removerTodasTabelas() {
        modelTbDestino_1.addLista(modelTbDestino_2.getLista());
        modelTbDestino_2.deletarLista();
    }

    private void selecionarArquivo() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo do Excel", "xls", "xlsx"));
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setSize(200, 150);
            if (fileChooser.showDialog(form, "Selecionar") == JFileChooser.APPROVE_OPTION) {
                arquivoDados = fileChooser.getSelectedFile();
                form.getTxtArquivo().setText(arquivoDados.getName());
            }
            lerFolhaExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public XSSFWorkbook getXlsFile() {
        try {
            FileInputStream input = new FileInputStream(arquivoDados);
            XSSFWorkbook workbook = new XSSFWorkbook(input);
            input.close();
            if (arquivoDados.isFile() && arquivoDados.exists()) {
                return workbook;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void lerFolhaExcel() {
        try {
            XSSFRow row;
            XSSFWorkbook workbook = getXlsFile();
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            List<Row_Excel> lista_rows = new ArrayList();

            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Row_Excel row_excel = new Row_Excel();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    row_excel.putColumn(cell.getColumnIndex(), cell.getStringCellValue());
                }
                lista_rows.add(row_excel);
            }
            
            excel.setRows(lista_rows);
            excel.gerarColunsName();

            modelExcel.setColmunName(excel.getColumnsName());
            modelExcel.addLista(lista_rows);
            form.getTbExcel().setModel(modelExcel);
            form.getTbExcel().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            form.getLbDetalhesExcel().setText("<html><body><b>Registros:</b> " + excel.getRowCount() + "<br><b>Colunas:  </b> " + excel.getColumnCount() + "</body></html>");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
