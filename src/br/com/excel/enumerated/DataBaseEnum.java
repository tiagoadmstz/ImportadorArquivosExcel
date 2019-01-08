/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.enumerated;

/**
 *
 * @author tiago.teixeira
 */
public enum DataBaseEnum {

    DERBYDB(0), MYSQL(1), POSTGRE(2), ORACLE(3);

    private final int valor;

    private DataBaseEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static DataBaseEnum getEnum(int valor) {
        switch (valor) {
            case 0:
                return DERBYDB;
            case 1:
                return MYSQL;
            case 2:
                return POSTGRE;
            case 3:
                return ORACLE;
            default:
                return null;
        }
    }

}
