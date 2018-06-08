package algoritimos.tabelas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago D. Teixeira
 */
public class TableModel_CBI extends AbstractTableModel{

    private String[] columnNames;
    private String[][] valores;
    
    @Override
    public String getColumnName(int column) {
            return columnNames[column];
    }
    
    public void setColmunName(String... columnNames){
        this.columnNames = columnNames;
    }
    
    @Override
    public int getRowCount() {
        return valores.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return valores[rowIndex][columnIndex];
    }
    
    public void getValueAt(String[][] objects){
        valores = objects;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

}
