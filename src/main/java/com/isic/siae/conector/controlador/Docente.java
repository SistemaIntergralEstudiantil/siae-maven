/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.conector.controlador;

import com.isic.siae.conector.Url;
import com.isic.siae.modelo.AsignaturaDAO;
import com.isic.siae.modelo.CursosDAO;
import com.isic.siae.modelo.Session;
import com.isic.siae.modelo.beans.AlumnoRepoD;
import com.isic.siae.modelo.beans.CursoAlumno;
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
 * Esta clase controla las petisiones del control de estados de los alumnos
 * @author danielhernandezreyes
 * @version 21/04/2021A
 * @see AsignaturaDAO
 * @see CursosDAO
 * @see Session
 * @see AlumnoRepoD
 * @see CursoAlumno
 */
@WebServlet(name = "Docente", urlPatterns = {"/Docente"})
public class Docente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        Session sec = (Session) sesion.getAttribute("user");
        try {
            if(sec == null) { // Control para el acceso no autorizado.
                sec = new Session();
                sec.setTypeSessionNull(0);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher("/error/error.jsp").forward(request, response);
                // Redireccionamiento a la pagina de error.
            } else {
                String clave = request.getParameter("clave");
                if(clave.equals("inicio") || clave.equals("change")){
                    String idUsuario = sec.getUser().getIdUsuario();
                    // Cambio del reporte del alumno
                    if(clave.equals("change")){
                        String matricula = request.getParameter("matricula");
                        if(matricula!=null || !matricula.equals("")){
                            // Obtención de los datos de la interfaz
                            String idCurso = request.getParameter("idCurso");
                            String status = request.getParameter("status");
                            CursoAlumno curalum = new CursoAlumno();
                            curalum.setMatricula(matricula);
                            curalum.setIdCurso(Integer.parseInt(idCurso));
                            curalum.setEstado(status);
                            // Registro de los cambios
                            CursosDAO crlCA = new CursosDAO();
                            crlCA.changeStatusAlumno(curalum);
                        }
                    }
                    // Consulta de los alumnos del docente
                    AsignaturaDAO crl = new AsignaturaDAO();
                    ArrayList<AlumnoRepoD> list = crl.reporteAlumnoCursoD(idUsuario);
                    request.setAttribute("lista", list);
                    // Redirección a la interfaz
                    request.getRequestDispatcher("/Docente/Cursos.jsp").forward(request, response);
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
        } catch (IOException | NumberFormatException | ServletException ex) {
            sesion.setAttribute("user", sec);
            sec.setErrorMsj(ex.getMessage());
            sec.setErrorType("java.lang.Exception");
            sec.setErrorUrl(Url.URL_LOGIN);
            response.sendRedirect(Url.URL_ERROR);
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
