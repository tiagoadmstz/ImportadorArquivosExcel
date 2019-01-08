/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.entities;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public class Tabela_Excel {

    private final List<String> letras = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
    private String[] columnsName;
    private String name;
    private List<Row_Excel> rows;

    public Tabela_Excel() {
    }

    public Tabela_Excel(List<Row_Excel> rows) {
        this.rows = rows;
    }

    public String[] getColumnsName() {
        return columnsName;
    }

    public void setColumnsName(String... columnsName) {
        this.columnsName = columnsName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Row_Excel> getRows() {
        return rows;
    }

    public void setRows(List<Row_Excel> rows) {
        this.rows = rows;
    }

    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return !rows.isEmpty() ? rows.get(0).getColumnCount() : 0;
    }

    public void gerarColunsName() {
        String[] colunas = new String[getColumnCount()];
        for (int c = 0; c < colunas.length; c++) {
            colunas[c] = getLetra(c);
        }
        columnsName = colunas;
    }

    private String getLetra(int column) {
        //26-(25 * (26/25))
        //quantas vezes vai rodar o loop
        int fator_loop = column / letras.size();
        //endereço da letra na lista
        int index = column > letras.size() ? column - fator_loop : column;
        //variável que guarda a letra
        String letra = letras.get(index);
        //loop caso a coluna ultrapasse a quantidade de letras existente
        for (int l = 0; l < fator_loop; l++) {
            index = column - fator_loop;
            letra = letra.concat(letras.get(index));
        }
        return letra;
    }

}
