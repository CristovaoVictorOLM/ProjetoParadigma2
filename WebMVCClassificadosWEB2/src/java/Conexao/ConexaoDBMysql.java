/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexao;

import java.sql.*;

public class ConexaoDBMysql {

//  static ResourceBundle res = ResourceBundle.getBundle("siscep.Res");
  private static boolean DEBUG = false;
  private Connection connection;

  private final String driver = "com.mysql.cj.jdbc.Driver";

 // Parametros de Produção - Tauceti.

  private static ConexaoDBMysql rep = new ConexaoDBMysql();


  private ConexaoDBMysql() { }

  static { try {
     // Connection connection = null;
      //Class.forName("org.postgresql.Driver");
      //Driver do Mysql.
      Class.forName("com.mysql.cj.jdbc.Driver");

    }
    catch (ClassNotFoundException cex) {
      //System.out.println("nao_achei_o_drive_do Banco de Dados");
      //throw new Exception("_Nenhum_driver_dispon");
    }
  }

  public static  synchronized ConexaoDBMysql getInstance(){
      if (rep == null){
          rep = new ConexaoDBMysql();
      }
      return rep;
  }

  public static Connection getConnection() throws SQLException, ClassNotFoundException {
    Connection connection = null;
    String user = "root";
    String password = "root";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC",user,password);
        System.out.println("Success");

    }
    catch (SQLException sex) {
       throw new SQLException(sex.getMessage());
     }
    return connection;
  }
  public static void devolveconexao(Connection connection) {
   try {
     connection.close();
   }
   catch (Exception ex) {

   }

  }
}//Fim de Classe