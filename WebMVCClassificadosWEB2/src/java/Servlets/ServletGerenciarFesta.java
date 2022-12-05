/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.*;
import Conexao.*;
import Controlador.*;
import DAO.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author ricardoricrob
 */
public class ServletGerenciarFesta extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    } 

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        FachadaFesta myFacade = new FachadaFesta();
        Festa myObj = new Festa();
	int status = 0;

            List<Festa> listagemgeral = new ArrayList<Festa>();
            listagemgeral  = myFacade.listagemGeralFesta();
            if (listagemgeral!=null){
                for (Iterator<Festa> it = listagemgeral.iterator(); it.hasNext();) {
                    Festa a = it.next();
                    System.out.println("Listar Nome do Anexo: " + a.getidFesta() );
                }

                request.getSession().setAttribute("listagemgeral",(Festa[]) listagemgeral.toArray(new Festa[0]));
                request.setAttribute("listagemgeral2",listagemgeral);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-gerenciar_anexo.jsp");
                rd.forward(request,response);
            }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // processRequest(request, response);
        String pagDestino = "/OK.jsp";

        String codigoanexo = request.getParameter("idAnexo");
        String eadata = request.getParameter("eadata");
        String valordaf = request.getParameter("valordaf");
        
        try {
                FachadaFesta myFacade = new FachadaFesta();
                
                int codigo = Integer.parseInt(codigoanexo);
              //  List<Funcionario> lista = new ArrayList<Funcionario>();
                Festa anexo = new Festa();
                 // func.setIdfunc(codigofunc);
                  anexo.setidFesta(codigo);
                  anexo.setdt_Festa(eadata);
                  anexo.setvalor_Festa(valordaf);

               int comando = myFacade.inserirFesta(anexo);

               if (comando > 0){
                  System.out.println("Dados Gravados com Sucesso!!!");
                  request.setAttribute("lista","Dados Gravados com Sucesso!!!");

               } else {
                  System.out.println("Não foi Possivel Incluir o Cliente !!!");
                  request.setAttribute("lista","Não foi Possivel Incluir !!!");
               }
              }
               catch (Exception e) {
                         System.out.println("Erro ao Inserir no Banco de Dados.");
                }
               finally{
                   RequestDispatcher rd = getServletContext().getRequestDispatcher(pagDestino);
                   rd.forward(request, response);
                 
                }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
