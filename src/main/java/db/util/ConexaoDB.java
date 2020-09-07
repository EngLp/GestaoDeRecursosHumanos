package db.util;

import java.sql.*;
public class ConexaoDB {
    
    public static Connection ligarBD(){
        
        String URL_DB="jdbc:mysql://127.0.0.1:3306/gestaorh?useSSL=false&serverTimezone=UTC";      
        String DRIVER8="com.mysql.cj.jdbc.Driver";
        String DRIVER5="com.mysql.jdbc.Driver";
        String USER="root";
        String PASSWORD="Respilah2";
        
        Connection conn;
       
        try {
            Class.forName(DRIVER8);
            return conn=DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("erro de conexao"+ ex.getLocalizedMessage());
            return null;
        }
        
        
    }
}
