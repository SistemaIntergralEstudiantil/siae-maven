<%-- 
    Document   : Menu_4
    Created on : 9/05/2021, 11:13:39 AM
    Author     : danielhernandezreyes
--%>

<%@page import="java.nio.charset.Charset"%>
<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.beans.Asignatura"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Reporte de solicitudes</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_CONTROL_ALTAS%>"/>
    </head>
    <body>
    <%  HttpSession sesion = request.getSession();
        Session sec = (Session) sesion.getAttribute("user");
        if(sec == null){
            sec = new Session();
            sec.setTypeSessionNull(1);
            sesion.setAttribute("user", sec);
            request.getRequestDispatcher(Url.URL_ERROR).forward(request, response); } %>
    <header>
    <nav>
    <ul class="content-G content">
        <li><a class="content-item-G content-item selec-none info" href="#dia">Solicitudes de verano</a></li>
        <li><img class="content-item-G content-item content-img" src="<%=Url.IMG_LOGO_SIAE%>" width="80" height="80"/></li>
    </ul>
    </nav>
    </header>
    <div class="description-p"><p>Aquí tendrás la oportunidad de aceptar y/o rechazar las altas y bajas de materias</p></div>
    <div class="content-table" >
    <table class="table">
    <caption class="description-p" >Lista de las asignaturas solicitadas</caption>
    <thead>
        <tr>
        <th style="width: 1rem;">Clave asignatura</th>
        <th style="width: 1rem;">Semestre</th>
        <th style="width: 10rem;">Nombre</th>
        <th style="width: 1rem;">Créditos</th>
        <th style="width: 1rem;">Solicitada</th>
        </tr>
    </thead>
    <tbody>
        <%  if(sec != null) {
                ArrayList<Asignatura> l = (ArrayList<Asignatura>) request.getAttribute("lista");
                for(Asignatura s : l) { %>
        <tr><th><%=s.getIdAsignatura() %></th>
            <th><%=s.getSemestre() %></th>
            <th><%=s.getNombre() %></th>
            <th><%=s.getCredito() %></th>
            <th><%=s.getSolicitar() %></th>
        </tr><% } } %>
    </tbody>
    </table>
    </div>
    <div class="content-data_row" >
        <a class="item-G-A-Selec content-a" href="<%=Url.SER_CONTROL_ALTA_BAJA%>?clave=consulta">Ménu carga academica</a></div>
    </body>
</html>
