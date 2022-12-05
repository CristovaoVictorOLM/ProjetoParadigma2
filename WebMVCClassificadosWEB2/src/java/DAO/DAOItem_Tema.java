/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Bean.Item_Tema;
import Conexao.*;

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

public class DAOItem_Tema {

    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;

    public DAOItem_Tema(ConexaoDBMysql conn) {
        this.co = conn;
    }

    public ArrayList list() throws SQLException, ClassNotFoundException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT iditem, nmItem from item_tema order by iditem";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Item_Tema t = new Item_Tema();
        //populate(material, rs);
        t.setiditem(rs.getInt(1));
        t.setnmItem(rs.getString(2));

        list.add(t);
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

    public int insert(Item_Tema tipo) throws SQLException, ClassNotFoundException {
    String sql;
    int a = 0;
    sql = "INSERT INTO item_tema (iditem, nmItem) VALUES (?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, tipo.getiditem());
      pstmt.setString(2, tipo.getnmItem());

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
