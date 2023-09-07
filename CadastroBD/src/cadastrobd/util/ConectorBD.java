/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jsq
 */
public class ConectorBD {

    public static Connection getConnection() throws Exception {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Loja;user=sa;password=123456;encrypt=true;TrustServerCertificate=true";
        return DriverManager.getConnection(connectionUrl);
    }

    public static PreparedStatement getPrepared(String sql) throws SQLException, Exception {
        Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }

    public static ResultSet getSelect(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }

    
    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
        }
    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
