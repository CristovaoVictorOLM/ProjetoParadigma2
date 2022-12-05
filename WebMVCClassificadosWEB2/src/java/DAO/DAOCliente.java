/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexao.ConexaoDBMysql;
//import Controlador.*;
import Bean.Cliente;

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

public class DAOCliente {

    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;

    public DAOCliente(ConexaoDBMysql conn) {
        this.co = conn;
    }

    public ArrayList list() throws SQLException, ClassNotFoundException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT nmCliente, email from cliente order by nmCliente";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Cliente c = new Cliente();
        //populate(material, rs);
        c.setIdcliente(rs.getInt(1));
        c.setnmCliente(rs.getString(2));
        c.setEmail(rs.getString(3));
        
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

    public int insert(Cliente cliente) throws SQLException, ClassNotFoundException {
    String sql;
    int a = 0;
    sql = "INSERT INTO cliente (idCliente, nmCliente, email) VALUES (?, ?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cliente.getIdcliente());
      pstmt.setString(2, cliente.getnmCliente());
      pstmt.setString(3, cliente.getEmail());
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

    public int remover(Cliente cliente) throws SQLException, ClassNotFoundException{
        int a = 0;
        String sql;
         sql = "DELETE from Cliente where idcliente = ?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cliente.getIdcliente());
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

