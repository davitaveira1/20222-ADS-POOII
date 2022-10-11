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
public class Ex01 {
    
    Connection conn=null;
    PreparedStatement pst=null;
    
    public void inserir(Produto p){
        
        try {
            conn = conexao.getConnection();
            pst = conn.prepareStatement("insert into "
                    + "produtos (nome,estoque,precoUnitario)"
                    + "values (?,?,?)");
            
            pst.setString(1, p.getNome());
            pst.setInt(2, p.getEstoque());
            pst.setDouble(3, p.getPrecoUnitario());
            
            int linhas = pst.executeUpdate();
            System.out.println("Linhas afetadas: "+linhas);
            
        } catch (Exception e) {
        }
        
    }
    
    public static void main(String[] args) {
        
        Ex01 e = new Ex01();
       
        Produto p = new Produto("Computador", 20, 1200);
        e.inserir(p);
        
        
    }
    
    
    
}
