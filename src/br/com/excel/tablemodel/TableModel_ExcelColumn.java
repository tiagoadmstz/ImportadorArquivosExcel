/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.tablemodel;

import br.com.excel.entities.Tabela_Excel;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public class TableModel_ExcelColumn extends TableModelDefaultAdapter<Tabela_Excel> {

    private static final long serialVersionUID = 7327500923604054821L;
    private String[] columnsName = new String[]{"Célula", "Valor"};

    public TableModel_ExcelColumn() {
        setColmunName(columnsName);
    }

    public TableModel_ExcelColumn(List<Tabela_Excel> lista) {
        super(lista);
        setColmunName(columnsName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tabela_Excel te = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return te.getTabela_excel();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
}
