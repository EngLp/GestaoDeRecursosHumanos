/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.util.ConexaoDB;
import rh.modelo.Departamento;
import rh.modelo.Funcionario;
import java.sql.*;

/**
 *
 * @author leandropontes
 */
public class FuncionarioDAO {
   
    String INSERT="INSERT INTO funcionario VALUES(?, ?)";
    String UPDATE="UPDATE departamento SET (?) WHERE (?)";
    String DELETE="DELETE FROM departamento WHERE (?);";
    String SELECT_ALL="SELECT * FROM departamento";
    String SELECT_BY_NOME="";
    String SELECT_BY_SIGLA="";

     public void save(Funcionario f){
        PreparedStatement  ps = null;
        Connection conn = null;
        
        try {
            conn = ConexaoDB.ligarBD();
            ps=conn.prepareStatement(INSERT);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getSobrenome());
            //ps.setString(3, f.getDepartamento());
           // ps.setString(4, f.getDataNascimento);
           // ps.setString(5, f.getSalario());
           //ps.setString(6, f.getCasa());
           //ps.setString(7, f.getRua());
           //ps.setString(8, f.getBairro());
           //ps.setString(9, f.getMunicipio());
           //ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: Funcionario:save"+e.getLocalizedMessage());
        }
        
    }
}

    
 
