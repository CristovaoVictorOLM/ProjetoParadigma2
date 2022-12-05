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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author ricardoricrob
 */
public class ServletListagemFesta extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        FachadaFesta myFacade = new FachadaFesta();
        Festa myObj = new Festa();
	int status = 0;

            ArrayList<Festa> listagemgeral = new ArrayList<Festa>();
            listagemgeral  = myFacade.listagemGeralFesta();
            if (listagemgeral!=null){
                for (Iterator<Festa> it = listagemgeral.iterator(); it.hasNext();) {
                    Festa anexo = it.next();
                    System.out.println("Listar Anexos: " + anexo.getidFesta());
                }

                request.getSession().setAttribute("listagemgeral",(Festa[]) listagemgeral.toArray(new Festa[0]));
                request.setAttribute("listagemgeral",listagemgeral);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-gerenciar_anexo.jsp");
                rd.forward(request,response);
            }

      
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
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
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
