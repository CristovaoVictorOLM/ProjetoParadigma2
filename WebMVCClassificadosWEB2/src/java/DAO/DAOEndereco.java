/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.ConexaoDBMysql;
//import Controlador.*;
import Bean.Endereco;

import java.sql.*;
import javax.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardoricrob
 */

public class DAOEndereco {

    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;

    public DAOEndereco(ConexaoDBMysql conn) {
        this.co = conn;
    }

    public ArrayList list() throws SQLException, ClassNotFoundException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT idEndereco, cep, bairro, logradouro from endereco order by idEndereco";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Endereco c = new Endereco();
        //populate(material, rs);
        c.setcep(rs.getString(1));
        c.setbairro(rs.getString(2));
        c.setlogradouro(rs.getString(3));
        list.add(c);
      }
      rs.close();
      pstmt.close();
    } catch (SQLException e) {
      rs.close();
      pstmt.close();
      conn.rollback();
      e.printStackTrace();
    } finally {
    	co.devolveconexao(conn);
    }
    return list;
  }

    public int insert(Endereco endereco) throws SQLException, ClassNotFoundException {
    String sql;
    int a = 0;
    sql = "INSERT INTO endereco (nome, email) VALUES (?, ?,)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, endereco.getcep());
      pstmt.setString(2, endereco.getbairro());
      pstmt.setString(3, endereco.getlogradouro());
      a = pstmt.executeUpdate();
      pstmt.close();
//      conn.commit();
//      JOptionPane.showMessageDialog(null,"Registro Gravado com Sucesso");
      return a;
    } catch (SQLException sqle) {

      sqle.printStackTrace();
      throw sqle;
    } finally {
    	co.devolveconexao(conn);
    }
  }

    public int remover(Endereco endereco) throws SQLException, ClassNotFoundException{
        int a = 0;
        String sql;
         sql = "DELETE from endereco where idEndereco = ?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, endereco.getIdEndereco());
      a = pstmt.executeUpdate();
      pstmt.close();
//      conn.commit();
//      JOptionPane.showMessageDialog(null,"Registro Gravado com Sucesso");
      return a;
    } catch (SQLException sqle) {
      sqle.printStackTrace();
      throw sqle;
    } finally {
    	co.devolveconexao(conn);
    }


    }

}

