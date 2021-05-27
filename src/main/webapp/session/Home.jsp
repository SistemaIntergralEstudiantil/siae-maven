<%-- 
    Document   : menu
    Created on : 22/03/2021, 07:13:25 PM
    Author     : sandr
--%>

<%@page import="java.nio.charset.Charset"%>
<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.beans.Usuarios"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Home</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_HOME%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_REDES%>"/>
    </head>
    <body style="background-image: url(<%=Url.IMG_MENU_PRINCIPAL%>);background-size: 100% 150%;background-position: 0% -35%;background-repeat: no-repeat">
        <%  HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            Usuarios user = null;
            if(sec == null) {
                sec = new Session();
                sec.setTypeSessionNull(1);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher(Url.URL_ERROR).forward(request, response);   
            } else 
                user = sec.getUser(); %>
        <header>
        <nav>
        <ul class="content-G content">
            <li><a class="content-item-G content-item" href="ReporteAsignatura">Asignaturas</a></li>
            <li><a class="content-item-G content-item" href="<%=Url.URL_AREAS_MENU%>">Áreas de apoyo</a></li>
            <% if(user != null && user.getRol().endsWith("A") ) { %>
            <li><a class="content-item-G content-item" href="Verano?clave=consulta">Curso de verano</a></li><% } %>
            <li><a class="content-item-G content-item" href="<%=Url.URL_CURRICULA_MENU%>">Currícula</a></li>
            <% if(user != null && user.getRol().endsWith("A") ) { %>
            <li><a class="content-item-G content-item" href="ControlCargaAcademica?clave=consulta">Altas y bajas</a></li><% } %>
            <li><a class="content-item-G content-item" href="<%=Url.URL_AJUSTES%>">Ajustes</a></li>
            <% if(user != null && user.getRol().endsWith("G") ) { %>
            <li><a class="content-item-G content-item" href="Control?clave=course">Control</a></li>
            <li><a class="content-item-G content-item" href="ControlAltaBaja?clave=consulta">Academia</a></li><% } %>
            <% if(user != null && user.getRol().endsWith("R") && user.getSemestre() == -2 ) { %>
            <li><a class="content-item-G content-item" href="Docente?clave=inicio">Estatus de alumnos</a></li><% } %>
        </ul>
        </nav>
        </header>
        <h1 class="title-header" >Mis datos generales</h1>
        <div class = "profile-pic-div">
            <% if(user != null) { 
                    if(user.aFoto != null) { %>
                <img src="data:image/png;base64,<%= Base64.getEncoder().encodeToString(user.aFoto)%>" id="foto"/>
                <% } else { %><img src="<%=Url.IMG_ISIC_CIRCULO%>" id="foto"/><% } }%>
        </div>
        <dl class="content-data" >
            <div class="content-data_row"><dt class="data_dt data_d" >Rol:</dt>
                <dd class="data_dd data_d"><%=(user== null)?"":user.getRol().equals("A")?"Alumno":user.getRol().equals("G")?"Administrador":"Representante y/o Docente" %></dd></div>
            <div class="content-data_row"><dt class="data_dt data_d" >Correo:</dt>
                <dd class="data_dd data_d"><%=(user== null)?"":user.getCorreo_inst() %></dd></div>
            <div class="content-data_row"><dt class="data_dt data_d" >Usuario:</dt>
                <dd class="data_dd data_d"><%=(user== null)?"":user.getIdUsuario() %></dd></div>
            <div class="content-data_row"><dt class="data_dt data_d" >Nombre:</dt>
                <dd class="data_dd data_d"><%=(user== null)?"":user.getNombreCompleto() %></dd></div>
            <div class="content-data_row" >
                <dt class="data_dt data_d" >Semestre:</dt><dd class="data_dd data_d" ><%=(user== null)?"":(user.getSemestre()<0)?"No aplica":user.getSemestre() %></dd></div>
        </dl>
        <form action="Login" method="POST"><input type="hidden" name="clave" value="exit"/>
            <input class="input-submit" type="submit" value="Cerrar sesión">
        </form>
        <div class="social">
            <ul class="consten-list list-none" >
                <li><a href="https://www.facebook.com/ING-Sistemas-Computacionales-ITSOEH-916964301664810/" target="_blank" class="link fab fa-facebook"></a></li>
                <li><a href="https://twitter.com/RolandoPorrasM?s=08" target="_blank"  class="link fab fa-twitter" ></a></li>
                <li><a href="http://www.itsoeh.edu.mx/" target="_blank"   class="link fas fa-globe"  ></a></li>
                <li><a href="http://conect.itsoeh.edu.mx/mix_21_alu" target="_blank"  class="link fas fa-laptop-house"></a></li>
            </ul>
	</div>
        <script src="https://kit.fontawesome.com/1703782d49.js" crossorigin="anonymous"></script>
    </body>
</html>
