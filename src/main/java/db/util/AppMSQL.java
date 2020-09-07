/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.util;

import java.sql.*;
import sun.security.rsa.RSACore;
public class AppMSQL {
    
    public static void main(String[] args) {
        String LISTA_DEPAETAMENTOS=" SELECT * FROM funcionario";
        
        try {
            Connection conn = ConexaoDB.ligarBD();
            PreparedStatement ps = conn.prepareStatement(LISTA_DEPAETAMENTOS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {  
                
                // print para testar 3 colunas da Dase de Dados
                 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                
                    //print para testar 2 colunas da base de dados
                //System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Erro na leitura de dados " +ex);
        }
    }
    
}
