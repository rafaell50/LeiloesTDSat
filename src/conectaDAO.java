
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection getConexao() {
        
        try {
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc_11",
                    "root",
                    "68854107"
            );
            return conn;
        }catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }
    
}
