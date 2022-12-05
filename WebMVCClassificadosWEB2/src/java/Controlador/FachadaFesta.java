/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Bean.Festa;
import Conexao.ConexaoDBMysql;
import DAO.DAOFesta;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class FachadaFesta {
    
   private ConexaoDBMysql conn = null;

   public FachadaFesta(){
        this.conn = ConexaoDBMysql.getInstance();
    }
    /**
     * @return the conn
     */
    public ConexaoDBMysql getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(ConexaoDBMysql conn) {
        this.conn = conn;
    }
  
    
   // Início dos Métodos da Fachada.
    public ArrayList<Festa> listagemGeralFesta() {
         ArrayList ob = new ArrayList();
       try {
           DAOFesta meuDAO = new DAOFesta(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirFesta(Festa obj) {
       int retorno = 0;
       try {
        DAOFesta meuDAO = new DAOFesta(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }
       
    
}
