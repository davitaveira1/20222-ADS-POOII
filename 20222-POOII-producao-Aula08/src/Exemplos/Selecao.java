/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import db.conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class Selecao {
    
    public static void main(String[] args) {
        
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        
        try {
            
            conn = conexao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produtos");
            
            while(rs.next()){
                System.out.println("Nome: "+rs.getString("nome")+
                                   "\nEstoque: "+rs.getString("estoque")+
                                   "\nPreço Unitário: "+rs.getString("precoUnitario")+"\n");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
        
    }
    
}
