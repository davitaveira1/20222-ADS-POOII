/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Produto;
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
public class controlaProdutosDAO {
    
    Connection conn=null;
    Statement st=null;
    PreparedStatement pst=null;
    public ResultSet rs=null;
    
    public ResultSet selecionarProdutos(){
        try {
            conn = conexao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produtos");
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        
        return rs;
    }
    
    public void inserirProduto(Produto p){
        
        try {
            
            conn = conexao.getConnection();
            pst = conn.prepareStatement("insert into produtos"
                    + "(nome,estoque,precoUnitario)"
                    + " values"
                    + " (?,?,?)");
            
            pst.setString(1, p.getNome());
            pst.setInt(2, p.getQuantidade());
            pst.setDouble(3, p.getPreco());
            
            int linha = pst.executeUpdate();
            if(linha>0){
                JOptionPane.showMessageDialog(null,"Inserção realizada!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        
    }
    
    public void alterarProduto(Produto p){
        
        try {
            
            conn = conexao.getConnection();
            pst = conn.prepareStatement("update produtos set nome=?,estoque=?,precoUnitario=?"
                    + " where codigo=?");
            
            pst.setString(1, p.getNome());
            pst.setInt(2, p.getQuantidade());
            pst.setDouble(3, p.getPreco());
            pst.setInt(4,p.getCodigo());
            
            int linha = pst.executeUpdate();
            if(linha>0){
                JOptionPane.showMessageDialog(null,"Alteração realizada!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }        
        
    }
    
    public void excluirProduto(int codigo){

        try {
            
            conn = conexao.getConnection();
            pst = conn.prepareStatement("delete from produtos where codigo=?");
            
            pst.setInt(1,codigo);
            
            int linha = pst.executeUpdate();
            if(linha>0){
                JOptionPane.showMessageDialog(null,"Exclusão realizada!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        
    }
    
    public ResultSet selecionarProduto(int codigo){
        try {
            conn = conexao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produtos where codigo="+codigo+"");
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }
        
        return rs;
    }    
    

    
}
