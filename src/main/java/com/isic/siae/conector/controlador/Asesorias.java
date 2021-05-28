/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.conector.controlador;

import com.isic.siae.conector.Url;
import com.isic.siae.modelo.AreasApoyoDAO;
import com.isic.siae.modelo.Session;
import com.isic.siae.modelo.beans.ReporteAsesoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danielhernandezreyes
 */
@WebServlet(name = "Asesorias", urlPatterns = {"/Asesorias"})
public class Asesorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Session sec = (Session) sesion.getAttribute("user");
        if(sec == null){ // Control para el acceso no autorizado.
            sec = new Session();
            sec.setTypeSessionNull(0);
            sesion.setAttribute("user", sec);
            request.getRequestDispatcher("/error/error.jsp").forward(request, response);
            // Redireccionamiento a la pagina de error.
        }else{
            try {
                String servicio = request.getParameter("servicio");
                if(servicio == null){ // No se espesifica la opción
                    response.sendRedirect("/areas/Menu.jsp");
                    // Redirección a la misma pagina
                }else{
                    if(servicio.equals("A")){ // Control de las asesorias.
                        AreasApoyoDAO crl = new AreasApoyoDAO();
                        ArrayList<ReporteAsesoria> list = crl.reporteAsesorias();
                        request.setAttribute("lista", list);
                        request.getRequestDispatcher("/areas/Asesorias.jsp").forward(request, response);
                        // Redirección a la pagina de asesorias.
                    }else{ 
                        if(servicio.equals("S")){ // Control de servicio
                            response.sendRedirect("/areas/ServicioPsicologico.jsp");
                            // Redirección a la pagina del servicio.
                        }else{
                            response.sendRedirect("/areas/Menu.jsp");
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                sesion.setAttribute("user", sec);
                sec.setErrorMsj("Error al declarar el conector a la SGBD:");
                sec.setErrorType(ex.toString());
                sec.setErrorUrl(Url.URL_HOME);
                response.sendRedirect(Url.URL_ERROR);
            } catch (SQLException ex) {
                sesion.setAttribute("user", sec);
                sec.setErrorMsj("Error en la conexión con el SGBD:");
                sec.setErrorType(ex.toString());
                sec.setErrorUrl(Url.URL_HOME);
                response.sendRedirect(Url.URL_ERROR);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
