/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tiago.teixeira
 */
public class Row_Excel {
    
    private Map<Integer, Object> row;

    public Row_Excel() {
        row = new HashMap();
    }
    
    public void putColumn(int column, Object value){
        row.put(column, value);
    }
    
    public Object getColumn(int columnIndex){
        return row.get(columnIndex);
    }
    
    public int getColumnCount(){
        return row.size();
    }

    @Override
    public String toString() {
        return "Row_Excel{" + "row=" + row + '}';
    }
}
