/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import db.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Davi
 */
public class Alteracao {
    
    public static void main(String[] args) {
        
        Connection conn=null;
        PreparedStatement pst=null;
        
        try {
            
            conn = conexao.getConnection();
            pst = conn.prepareStatement("Update produtos"
                    + " set nome=?,"
                    + " estoque=?,"
                    + " precoUnitario=?"
                    + " where codigo=?");
            
            pst.setString(1,"Bicicleta");
            pst.setInt(2,100);
            pst.setDouble(3,3000);
            pst.setInt(4,5);
            
            int linhasAfetadas = pst.executeUpdate();
            System.out.println("Linhas afetadas: "+linhasAfetadas);
            
        } catch (Exception e) {
        }
        
        
    }
    
}
