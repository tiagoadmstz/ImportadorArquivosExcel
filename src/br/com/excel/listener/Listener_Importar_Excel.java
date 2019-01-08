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
import br.com.excel.enumerated.DataBaseEnum;
import br.com.excel.frames.Form_Importar_Excel;
import br.com.excel.interfaces.DAO_Util;
import br.com.excel.tablemodel.TableModel_TabDestino;
import br.com.excel.util.DaoUtil;
import br.com.excel.util.ExcelUtil;
import br.com.excel.util.FileUtil;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tiago.teixeira
 */
public class Listener_Importar_Excel implements ActionListener {

    private final Form_Importar_Excel form;
    private DAO_Util dao;
    private TableModel_TabDestino modelTbDestino_1;
    private TableModel_TabDestino modelTbDestino_2;
    private final List<Tabela_BD> tabelasSelecionadas = new ArrayList();
    private final List<JPanel> paineis_planilhas = new ArrayList();
    private final List<JScrollPane> scrolls_planilhas = new ArrayList();
    private File arquivoDados;
    private ExcelUtil util;
    private DaoUtil daoUtil;

    public Listener_Importar_Excel(Form_Importar_Excel form) {
        this.form = form;
        initComponents();
    }

    private void initComponents() {
        attachListeners();
        addModel();
    }

    private void initDao(int index) {
        daoUtil = new DaoUtil(form.getCbDriver().getSelectedItem().toString(),
                form.getTxtEnderecoBanco().getText(),
                form.getTxtUsuarioBanco().getText(),
                String.valueOf(form.getTxtPasswordBanco().getPassword()));
        dao = daoUtil.getDao(DataBaseEnum.getEnum(index));
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
        form.getTbTabelaDestOpcao().setModel(modelTbDestino_1);
        form.getTbTabelaDestSelecionada().setModel(modelTbDestino_2);
    }

    private void testarConexao() {
        boolean result = false;
        try {
            initDao(form.getCbDriver().getSelectedIndex());
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
            initDao(form.getCbDriver().getSelectedIndex());
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
        arquivoDados = FileUtil.selecionarArquivo(form);
        if (util == null) {
            util = new ExcelUtil(arquivoDados);
        } else {
            util.setArquivoDados(arquivoDados);
        }
        form.getTxtArquivo().setText(arquivoDados.getName());
        lerFolhasExcel();
    }

    public void lerFolhasExcel() {
        try {
            XSSFWorkbook workbook = util.getXlsFile();
            List<XSSFSheet> planilhas = util.getPlanilhas(workbook);
            restartComponents();
            planilhas.forEach((planilha) -> {
                List<Row_Excel> rows = util.getRows(planilha);
                Tabela_Excel tabela = new Tabela_Excel(rows);
                tabela.setName(planilha.getSheetName());
                util.addPlanilhaToTable(planilha.getSheetName(), rows);
                util.montarLabel(tabela, form.getPainelDetalhesExcel());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restartComponents() {
        paineis_planilhas.clear();
        scrolls_planilhas.clear();
        form.getTbbPlans().removeAll();
        form.getPainelDetalhesExcel().removeAll();
    }

}
