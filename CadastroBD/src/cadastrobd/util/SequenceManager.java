/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.util;

/**
 *
 * @author jsq
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {

    public static int getValue(String sequenceName) throws SQLException, Exception {
        String sql = "SELECT NEXT VALUE FOR " + sequenceName + " AS seqValue";
        try (PreparedStatement statement = ConectorBD.getPrepared(sql); ResultSet resultSet = ConectorBD.getSelect(statement)) {
            if (resultSet.next()) {
                return resultSet.getInt("seqValue");
            }
        }
        return -1; // Valor padrão em caso de erro
    }
}
