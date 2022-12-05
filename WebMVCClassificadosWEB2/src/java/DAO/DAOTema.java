/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Conexao.ConexaoDBMysql;
//import Controlador.*;
import Bean.Tema;

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

public class DAOTema {

    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;

    public DAOTema(ConexaoDBMysql conn) {
        this.co = conn;
    }

    public ArrayList list() throws SQLException, ClassNotFoundException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT idTema, nmTema from tema order by idTema";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Tema c = new Tema();
        //populate(material, rs);
        c.setidTema(rs.getInt(1));
        c.setnmTema(rs.getString(2));
        

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

    public int insert(Tema tema) throws SQLException, ClassNotFoundException {
    String sql;
    int a = 0;
    sql = "INSERT INTO tema (idTema, nmTema) VALUES (?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, tema.getidTema());
      pstmt.setString(2, tema.getnmTema());
      a = pstmt.executeUpdate();
      pstmt.close();
//      conn.commit();fun
//      JOptionPane.showMessageDialog(null,"Registro Gravado com Sucesso");
      return a;
    } catch (SQLException sqle) {

      sqle.printStackTrace();
      throw sqle;
    } finally {
    	co.devolveconexao(conn);
    }
  }

    public int remover(Tema tema) throws SQLException, ClassNotFoundException{
        int a = 0;
        String sql;
         sql = "DELETE from tema where idTema = ?";
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
        conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, tema.getidTema());
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


