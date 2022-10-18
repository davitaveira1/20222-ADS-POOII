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
public class Ex04 {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst=null;
    ResultSet rs = null;

    public ResultSet selecionarTodosOsProdutos() {

        try {

            conn = conexao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from produtos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        return rs;
    }
    
    public ResultSet selecionarProduto(int codigo) {

        try {

            conn = conexao.getConnection();
            pst = conn.prepareStatement("select * from produtos "
                    + "where codigo=?");
            pst.setInt(1, codigo);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

        return rs;
    }    

    public static void main(String[] args) {
        Ex04 e = new Ex04();

        //e.rs = e.selecionarTodosOsProdutos();
        e.rs = e.selecionarProduto(6);

        try {
            while (e.rs.next()) {
                System.out.println("Codigo: "+e.rs.getString(1));
                System.out.println("Nome: "+e.rs.getString(2));
                System.out.println("Estoque: "+e.rs.getString(3));
                System.out.println("Preço Unitário: "+e.rs.getString(4));
                System.out.println("======");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro);
        }

    }

}
