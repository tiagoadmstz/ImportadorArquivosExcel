/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.tablemodel;

import br.com.excel.entities.Row_Excel;
import br.com.excel.entities.Tabela_Excel;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public class TableModel_ExcelColumn extends TableModelDefaultAdapter<Row_Excel> {

    private static final long serialVersionUID = 7327500923604054821L;

    public TableModel_ExcelColumn() {
    }

    public TableModel_ExcelColumn(List<Row_Excel> lista) {
        super(lista);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lista.get(rowIndex).getColumn(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        lista.get(rowIndex).putColumn(columnIndex, aValue);
    }
    
}
