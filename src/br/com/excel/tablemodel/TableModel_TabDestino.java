/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.tablemodel;

import br.com.excel.entities.Tabela_BD;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public final class TableModel_TabDestino extends TableModelDefaultAdapter<Tabela_BD> {

    private static final long serialVersionUID = -5974015456413643194L;
    private final String[] columnsName = new String[]{"TABELAS"};

    public TableModel_TabDestino() {
        setColmunName(columnsName);
    }

    public TableModel_TabDestino(List<Tabela_BD> lista) {
        super(lista);
        setColmunName(columnsName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tabela_BD tabela = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tabela.getNomeTabela();
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Tabela_BD tabela = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                tabela.setNomeTabela(aValue.toString());
                break;
        }
    }

}
