/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.util;

import br.com.excel.entities.Row_Excel;
import br.com.excel.entities.Tabela_Excel;
import br.com.excel.tablemodel.TableModel_ExcelColumn;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tiago.teixeira
 */
public final class ExcelUtil {

    private File arquivoDados;

    public ExcelUtil(File file) {
        arquivoDados = file;
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

    public List<XSSFSheet> getPlanilhas(XSSFWorkbook workbook) {
        int quant = workbook.getNumberOfSheets();
        List<XSSFSheet> lista = new ArrayList();
        for (int p = 0; p < quant; p++) {
            lista.add(workbook.getSheetAt(p));
        }
        return lista;
    }

    public List<Row_Excel> getRows(XSSFSheet sheet) {
        Iterator<Row> rowIterator = sheet.iterator();
        List<Row_Excel> lista_rows = new ArrayList();

        while (rowIterator.hasNext()) {
            XSSFRow row;
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Row_Excel row_excel = new Row_Excel();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        row_excel.putColumn(cell.getColumnIndex(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        row_excel.putColumn(cell.getColumnIndex(), cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        row_excel.putColumn(cell.getColumnIndex(), cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        row_excel.putColumn(cell.getColumnIndex(), cell.getCellFormula());
                        break;
                }
            }
            lista_rows.add(row_excel);
        }
        return lista_rows;
    }

    public JPanel addPlanilhaToTable(String nome_plan, List<Row_Excel> rows) {
        //w776xh354
        JPanel panel = new JPanel();
        panel.setName(nome_plan);
        panel.setLayout(new GridLayout(1, 1));
        JScrollPane scroll = new JScrollPane();
        scroll.setMaximumSize(new Dimension(765, 345));
        JTable table = new JTable();
        table.setMaximumSize(new Dimension(765, 345));
        TableModel_ExcelColumn model = new TableModel_ExcelColumn();
        Tabela_Excel planilha = new Tabela_Excel(rows);
        planilha.gerarColunsName();
        planilha.setName(nome_plan);
        model.setColmunName(planilha.getColumnsName());
        model.setLista(rows);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scroll.getViewport().add(table);
        panel.add(scroll);
        return panel;
    }

    public void montarLabel(Tabela_Excel planilha, JPanel painel) {
        if (painel.getComponentCount() < 6) {
            JLabel label = new JLabel("");
            //label.setSize(115, 91);
            label.setText("<html><body><table>"
                    + "<tr><th text-align: left><b>Planilha:</b> " + planilha.getName() + "</th></tr>"
                    + "<tr><th text-align: left><b>Registros:</b> " + planilha.getRowCount() + "</th></tr>"
                    + "<tr><th text-align: left><b>Colunas:</b> " + planilha.getColumnCount() + "</th></tr>"
                    + "</table></body></html>");
            painel.add(label);
        }
    }

    public File getArquivoDados() {
        return arquivoDados;
    }

    public void setArquivoDados(File arquivoDados) {
        this.arquivoDados = arquivoDados;
    }
    
}
