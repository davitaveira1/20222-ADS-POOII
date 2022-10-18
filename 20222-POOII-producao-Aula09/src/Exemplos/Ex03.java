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
public class Ex03 {
    
        Connection conn = null;
        PreparedStatement pst = null;    

    public void excluir(int codigo) {

        try {
            conn = conexao.getConnection();
            pst = conn.prepareStatement("delete from produtos where"
                    + " codigo = ?");
            
            pst.setInt(1, codigo);
            int linhas = pst.executeUpdate();
            System.out.println("Linhas afetadas: "+linhas);
            if(linhas==0){
                JOptionPane.showMessageDialog(null,"Erro: SQL");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro: "+ e);
        }

    }
    
    public static void main(String[] args) {
        Ex03 e = new Ex03();
        e.excluir(12);
                
    }

}
