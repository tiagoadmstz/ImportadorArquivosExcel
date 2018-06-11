/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public class Tabela_BD implements Serializable{

    private static final long serialVersionUID = -6512426472531446754L;
    
    private String nomeTabela;
    private List<String> colunas;

    public Tabela_BD() {
    }

    public Tabela_BD(String nomeTabela, List<String> colunas) {
        this.nomeTabela = nomeTabela;
        this.colunas = colunas;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    public List<String> getColunas() {
        return colunas;
    }

    public void setColunas(List<String> colunas) {
        this.colunas = colunas;
    }
    
}
