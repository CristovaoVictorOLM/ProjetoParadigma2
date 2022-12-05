/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import DAO.*;
import Bean.*;
import Conexao.*;
import java.util.*;
/**
 *
 * @author ricardoricrob
 */
public class Fachada {
  private ConexaoDBMysql conn = null;

   public Fachada(){
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
      public ArrayList<Cliente> listagemGeralCliente() {
         ArrayList ob = new ArrayList();
       try {
           DAOCliente meuDAO = new DAOCliente(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirCliente(Cliente obj) {
       int retorno = 0;
       try {
        DAOCliente meuDAO = new DAOCliente(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }

    public int removerCliente(Cliente obj){
        int retorno = 0;
        try{
            DAOCliente meuDao = new DAOCliente(this.getConn());
            retorno = meuDao.remover(obj);

        } catch (Exception exception){
            System.out.println("não apagou");
        }
        return retorno;
    }
     // Início dos Métodos da Fachada.
      public ArrayList<Endereco> listagemGeralEndereco() {
         ArrayList ob = new ArrayList();
       try {
           DAOEndereco meuDAO = new DAOEndereco(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirEndereco(Endereco obj) {
       int retorno = 0;
       try {
        DAOEndereco meuDAO = new DAOEndereco(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }

      // Início dos Métodos da Fachada.
    public ArrayList<Item_Tema> listagemGeralItem_Tema() {
         ArrayList ob = new ArrayList();
       try {
           DAOItem_Tema meuDAO = new DAOItem_Tema(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirItem_Tema(Item_Tema obj) {
       int retorno = 0;
       try {
        DAOItem_Tema meuDAO = new DAOItem_Tema(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }

          // Início dos Métodos da Fachada.
    public ArrayList<Tema> listagemGeralTema() {
         ArrayList ob = new ArrayList();
       try {
           DAOTema meuDAO = new DAOTema(this.getConn());
           ob = meuDAO.list();
        } catch (Exception exception) {
           // System.out.println("Listagem dos Municípios não foi localizada.");
      }
       return ob;
    }

    public int inserirTema(Tema obj) {
       int retorno = 0;
       try {
        DAOTema meuDAO = new DAOTema(this.getConn());
        retorno = meuDAO.insert(obj);

      } catch (Exception exception){
         System.out.println("Inclusão não foi realizada Ocorrencia.");
      }
       return  retorno;
    }

    // Fim dos Métodos da Fachada.


}
