/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exemplos;

import db.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Davi
 */
public class Ex02 {
    
    Connection conn=null;
    PreparedStatement pst=null;
    Statement st=null;
    ResultSet rs=null;
    
    public void alterar(Produto p){
        
        try {
            conn = conexao.getConnection();
            pst = conn.prepareStatement("update produtos set "
                    + "nome=?,"
                    + "estoque=?,"
                    + "precoUnitario=?"
                    + "where "
                    + "codigo=?");            
            
            pst.setString(1,p.getNome());
            pst.setInt(2, p.getEstoque());
            pst.setDouble(3, p.getPrecoUnitario());
            pst.setInt(4, p.getCodigo());
            
            int linhas=pst.executeUpdate();
            System.out.println("Linhas afetadas: "+linhas);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
    }
    
    public Produto buscar(int codigo){
        Produto p;
        
        try {
            conn = conexao.getConnection();
            pst = conn.prepareStatement("select * from produtos "
                    + "where codigo=?");
            pst.setInt(1, codigo);
            rs = pst.executeQuery();           
            
            if(rs.next()){
            p = new Produto(
                    rs.getInt("codigo"),
                    rs.getString("nome"), 
                    rs.getInt("estoque"), 
                    rs.getDouble("precoUnitario"));                
            }else{
                p = null;
            }


            
            return p;
            
        } catch (Exception e) {
            return null;
        }
        
        
 
    }
    
    public static void main(String[] args) {
        Ex02 e = new Ex02();
        Produto p = new Produto();
        
        p = e.buscar(9);
        
        
        
        p.setNome("Forno Eletrolux 2");
        p.setEstoque(200);
        
        
        e.alterar(p);
        //codigo 9
        //nome: Forno Eletrolux
        //estoque: 10
        //Preço: 800
    }
    
}
