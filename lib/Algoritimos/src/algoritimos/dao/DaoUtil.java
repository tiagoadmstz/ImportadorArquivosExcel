/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tiago.teixeira
 */
public class DaoUtil {

    public Statement getStatementScrollInsensitive(Connection conn) throws SQLException {
        Statement sttm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return sttm;
    }

    public PreparedStatement getPreparedStatementScrollInsensitive(Connection conn, String stringPesquisa) throws SQLException {
        PreparedStatement sttm = conn.prepareStatement(stringPesquisa, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return sttm;
    }

    public int getRowCountResultSet(ResultSet resultset) throws SQLException {

        int length;
        resultset.last();
        length = resultset.getRow();
        resultset.first();

        return length;
    }

    public int getColumnCountResultSet(ResultSet resultset) throws SQLException {

        int length;
        length = resultset.getMetaData().getColumnCount();

        return length;
    }

}
