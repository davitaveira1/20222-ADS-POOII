/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import db.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class Insercao {
    
    public static void main(String[] args) {
        
        Connection conn=null;
        PreparedStatement pst=null;
        
        try {
            
            conn = conexao.getConnection();
            
            pst = conn.prepareStatement(
                    "insert into produtos(nome,estoque,precoUnitario)"
                    + " values (?,?,?)");
            
            pst.setString(1,"Bicicleta");
            pst.setInt(2,50);
            pst.setDouble(3,800.12);
            
            int linhasAfetadas = pst.executeUpdate();
            System.out.println("Linhas: "+linhasAfetadas);

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        
    }
    
}
