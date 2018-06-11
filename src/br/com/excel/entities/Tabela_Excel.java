/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellAddress;

/**
 *
 * @author tiago.teixeira
 */
public class Tabela_Excel {

    private Map<CellAddress, Object> tabela_excel;

    public Tabela_Excel() {
        tabela_excel = new HashMap();
    }

    public Map<CellAddress, Object> getTabela_excel() {
        return tabela_excel;
    }

    public void putTable(CellAddress andress, Object value) {
        tabela_excel.put(andress, value);
    }

}
