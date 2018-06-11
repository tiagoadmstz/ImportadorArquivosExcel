/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.dal;

import br.com.excel.entities.Tabela_BD;
import br.com.excel.interfaces.DAO_Util;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author tiago.teixeira
 */
public final class DAO_DerbyDb implements DAO_Util {

    private static final Logger LOG = Logger.getLogger(DAO_DerbyDb.class.getName());
    private final String driverClass;
    private final String enderecoBanco;
    private final String usuarioBanco;
    private final String senhaBanco;
    private Connection conn;
    private DatabaseMetaData meta;

    public DAO_DerbyDb(String driverClass, String enderecoBanco, String usuarioBanco, String senhaBanco) {
        this.driverClass = driverClass;
        this.enderecoBanco = enderecoBanco;
        this.usuarioBanco = usuarioBanco;
        this.senhaBanco = senhaBanco;
    }

    @Override
    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conectar();
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean conectar() throws Exception {
        LOG.info("CONECTANDO AO BANCO DE DADOS");
        DriverManager.registerDriver((Driver) Class.forName(driverClass).newInstance());
        conn = DriverManager.getConnection(enderecoBanco, usuarioBanco, senhaBanco);
        return !conn.isClosed();
    }

    @Override
    public void closeConnection() throws Exception {
        LOG.info("FECHANDO CONEXÃO COM O BANCO DE DADOS");
        conn.close();
    }
    
    @Override
    public boolean testarConexao() {
        try {
            boolean teste = conectar();
            closeConnection();
            return teste;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tabela_BD[] getTabelasDB() {
        try {
            getConnection();
            meta = meta == null ? conn.getMetaData() : meta;
            ResultSet rst = meta.getTables(null, null, null, new String[]{"TABLE"});
            int column = rst.getMetaData().getColumnCount();
            List<Tabela_BD> tabelas = new ArrayList();
            while (rst.next()) {
                for (int i = 1; i <= column; i++) {
                    if (rst.getMetaData().getColumnName(i).equals("TABLE_NAME") && rst.getObject(i) != null) {
                        Tabela_BD tb_db = new Tabela_BD(rst.getString(i), Arrays.asList(getColumnsName(rst.getString(i))));
                        tabelas.add(tb_db);
                    }
                }
            }
            closeConnection();
            //tabelas.forEach(System.out::println);
            return tabelas.toArray(new Tabela_BD[tabelas.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String[] getColumnsName(String table) {
        try {
            getConnection();
            meta = meta == null ? conn.getMetaData() : meta;
            ResultSet rst = meta.getColumns(null, null, table, null);
            int column = rst.getMetaData().getColumnCount();
            List<String> colunas = new ArrayList();
            while (rst.next()) {
                for (int i = 1; i <= column; i++) {
                    if (rst.getMetaData().getColumnName(i).equals("COLUMN_NAME")) {
                        colunas.add(rst.getString(i));
                    }
                }
            }
            //colunas.forEach(System.out::println);
            return colunas.toArray(new String[colunas.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String[] getSchemas() {
        try {
            getConnection();
            meta = meta == null ? conn.getMetaData() : meta;
            ResultSet rst = meta.getSchemas();
            List<String> schemas = new ArrayList();
            while (rst.next()) {
                int column = rst.getMetaData().getColumnCount();
                for (int i = 1; i <= column; i++) {
                    if (rst.getObject(i) != null) {
                        schemas.add(rst.getString(i));
                    }
                }
            }
            closeConnection();
            //schemas.forEach(System.out::println);
            return schemas.toArray(new String[schemas.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String[] getTableTypes() {
        try {
            getConnection();
            meta = meta == null ? conn.getMetaData() : meta;
            ResultSet rst = meta.getTableTypes();
            List<String> tableTypes = new ArrayList();
            while (rst.next()) {
                int column = rst.getMetaData().getColumnCount();
                for (int i = 1; i <= column; i++) {
                    tableTypes.add(rst.getString(i));
                }
            }
            closeConnection();
            //tableTypes.forEach(System.out::println);
            return tableTypes.toArray(new String[tableTypes.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getDataForTable(String table) {
        try {
            getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM " + table);
            ResultSet rst = pstm.executeQuery();
            closeConnection();
            while (rst.next()) {
                int column = rst.getMetaData().getColumnCount();
                for (int i = 1; i <= column; i++) {
                    System.out.println(rst.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
