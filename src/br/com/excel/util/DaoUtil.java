/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.util;

import br.com.excel.dal.DAO_DerbyDb;
import br.com.excel.enumerated.DataBaseEnum;
import br.com.excel.interfaces.DAO_Util;

/**
 *
 * @author tiago.teixeira
 */
public class DaoUtil {

    private final String driver;
    private final String url;
    private final String user;
    private final String passwd;

    public DaoUtil(String driver, String url, String user, String passwd) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }

    public DAO_Util getDao(DataBaseEnum db) {
        DAO_Util dao = null;
        switch (db) {
            case DERBYDB:
                dao = new DAO_DerbyDb(driver, url, user, passwd);
                break;
            case MYSQL:
                break;
            case ORACLE:
                break;
            case POSTGRE:
                break;
        }
        return dao;
    }

}
