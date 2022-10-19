/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import db.conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Davi
 */
public class Ex1 {
    
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            conn = conexao.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from usuarios");
            
            while(rs.next()){
                System.out.println(rs.getInt("codigo")+ " " + rs.getString("login"));
            }
                        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
    
}
