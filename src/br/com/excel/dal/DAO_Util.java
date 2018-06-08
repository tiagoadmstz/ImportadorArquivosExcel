/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.dal;

import com.sun.istack.internal.logging.Logger;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author tiago.teixeira
 */
public class DAO_Util {

    private static final Logger LOG = Logger.getLogger(DAO_Util.class);
    private final String driverClass;
    private final String enderecoBanco;
    private final String usuarioBanco;
    private final String senhaBanco;
    private Connection conn;

    public DAO_Util(String driverClass, String enderecoBanco, String usuarioBanco, String senhaBanco) {
        this.driverClass = driverClass;
        this.enderecoBanco = enderecoBanco;
        this.usuarioBanco = usuarioBanco;
        this.senhaBanco = senhaBanco;
    }

    public synchronized boolean conectar() throws Exception {
        LOG.info("CONECTANDO AO BANCO DE DADOS");
        DriverManager.registerDriver((Driver) Class.forName(driverClass).newInstance());
        conn = DriverManager.getConnection(enderecoBanco, usuarioBanco, senhaBanco);
        return !conn.isClosed();
    }

    public void closeConnection() throws Exception {
        LOG.info("FECHANDO CONEXÃO COM O BANCO DE DADOS");
        conn.close();
    }

}
