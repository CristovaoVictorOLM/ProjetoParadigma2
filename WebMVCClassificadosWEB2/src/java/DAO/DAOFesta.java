/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoDBMysql;
//import Controlador.*;
import Bean.Festa;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Ricardo
 */
public class DAOFesta {
    
    private ConexaoDBMysql co = ConexaoDBMysql.getInstance();
    private String sql = "",  sql1 = "";
    private PreparedStatement stmt = null;
    
    
    // Método Construtor da Classe
    public DAOFesta(ConexaoDBMysql conn) {
        this.co = conn;
    }
    
    // Métodos para Listar todos os festas existesntes
    
    public ArrayList list() throws SQLException, ClassNotFoundException {
    ArrayList list = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      String sql = "SELECT idFesta, dt_Festa, valor_Festa from festa order by idFesta";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Festa c = new Festa();

        c.setidFesta(rs.getInt(1));
        c.setvalor_Festa(rs.getString(2));
        c.setdt_Festa(rs.getString(3));
        
        
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
    
    
   // Método para Inserir Novos festas no Sistema..
   
    public int insert(Festa festa) throws SQLException, ClassNotFoundException {
    String sql;
    int a = 0;
    sql = "INSERT INTO festa (idFesta, dt_Festa, valor_Festa) VALUES (?, ?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = co.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, festa.getidFesta());
      pstmt.setString(2, festa.getdt_Festa());
      pstmt.setString(3, festa.getvalor_Festa());
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
