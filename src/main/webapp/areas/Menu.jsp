<%-- 
    Document   : menu
    Created on : 7/04/2021, 08:12:02 PM
    Author     : danielhernandezreyes
--%>

<%@page import="java.nio.charset.Charset"%>
<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1")%>"/>
        <title>Áreas de apoyo escolar</title>
        <link rel="shortcut icon" href="/siae/resource/images/logo_SIAE.png" />
        <link rel="stylesheet" href="/siae/resource/css/Style-General.css"/>
        <link rel="stylesheet" href="/siae/resource/css/Style-AreasApoyo.css"/>
    </head>
    <body class="marca-areas">
        <%  HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            if (sec == null) {
                sec = new Session();
                sec.setTypeSessionNull(1);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher(Url.URL_ERROR).forward(request, response); } %>
        <header>
        <nav>
        <ul class="content-G content">
            <li><h1 class="content-item-G content-item" >Areas de apoyo escolar</h1></li>                    
            <li><img class="content-item-G content-item content-img" src="/siae/resource/images/logo_SIAE.png" width="80" height="80" /></li>
        </ul>
        </nav>
        </header>
        <div class="description-p" style="margin-top: 4rem">
            <p>Las áreas de apoyo buscan fortalecer los procesos de formación de los estudiantes vulnerables a través de la implementación de un programa.</p>
        </div>
        <form action="/siae/Asesorias" method="POST" >
        <div class="content-data_row" >
            <select name="servicio" class="data_d">
                <option value="" disabled selected>Áreas</option>
                <option value="A">Asesorias</option> 
                <option value="S">Asesoría legal y psicológica</option>
            </select>
        </div>
        <div class="content-data_row" >
            <input type="hidden" name="clave" value="menu"/>
            <input class="data_d input-submit" type="submit" value="Consultar"/>
        </div>
        <div class="content-data_row" >
            <a class="item-G-A-Selec content-a" href="<%=Url.URL_HOME%>">Ménu principal</a>
        </div>
        </form>
    </body>
</html>
