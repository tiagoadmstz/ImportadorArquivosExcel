/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.interfaces;

import br.com.excel.entities.Tabela_BD;
import java.sql.Connection;

/**
 *
 * @author tiago.teixeira
 */
public interface DAO_Util {

    public Connection getConnection();

    public boolean conectar() throws Exception;

    public void closeConnection() throws Exception;

    public boolean testarConexao();
    
    public Tabela_BD[] getTabelasDB();

    public String[] getColumnsName(String table);

    public String[] getSchemas();

    public String[] getTableTypes();

}
