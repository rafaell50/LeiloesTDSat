/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    conectaDAO conexao;
    
    public boolean conectar() {

        conexao = new conectaDAO();
        conn = conexao.getConexao();

        if (conn == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public int cadastrarProduto (ProdutosDTO produto){
        
        
        int status;
        try {

            
            String sql = "INSERT INTO produtos (nome, valor, status) VALUES"
                    + "(?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, produto.getNome());
            st.setLong(2, produto.getValor());
            st.setString(3, produto.getStatus());
            status = st.executeUpdate();

            return status;
        } catch (SQLException ex) {

            System.out.println("Erro ao inserir o produto: " + ex.getMessage());
            return ex.getErrorCode();
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.print("erro ao desconectar " + ex.getMessage());
        }
    }
    
        
}

