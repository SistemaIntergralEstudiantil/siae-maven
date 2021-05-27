<%-- 
    Document   : Menu
    Created on : 12/04/2021, 10:16:06 PM
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
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Seguimiento Académico</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_CURRICULA%>"/>
        
    </head>
    <body style="background-image: url(/siae/resource/images/menuPrincipal.png);background-size: 100% 150%;background-repeat: no-repeat">
        <%
            
            HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            if(sec == null){
                sec = new Session();
                sec.setTypeSessionNull(1);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher("/error/error.jsp").forward(request, response);   
            }
        %>
        <header>
            <nav>
                <ul class="content-G content">
                    <li><h1 class="content-item-G content-item" >Seguimiento Académico</h1></li>                    
                    <li>
                        <img class="content-item-G content-item content-img" src="/siae/resource/images/logo_SIAE.png" width="80" height="80"/>
                    </li>
                </ul>
            </nav>
        </header>
        <form action="/siae/AsignaturaServ" method="POST" >
            <div class="content-data_row" >
                <select name="servicio" class="data_d">
                    <option value="" disabled selected>Seleccionar ...</option>
                    <option value="AC">Área de conocimiento</option> 
                    <option value="TE">Tiempo de estudio</option>
                </select>
            </div>
            <div class="content-data_row" >
                <input type="hidden" name="clave" value="menu">
                <input class="data_d input-submit" type="submit" value="Consultar">
            </div>
            <div class="content-data_row" >
                <a class="item-G-A-Selec content-a" href="/siae/session/Home.jsp">Ménu principal</a>
            </div>
        </form>
        <abbr title="Seleccione el menú desplegable para realizar una busqueda acerca de tu seguimiento académico ">
            <img src="/siae/resource/images/help.png" width="40" height="40" style="float: right;"/>  
        </abbr>
    </body>
</html>
