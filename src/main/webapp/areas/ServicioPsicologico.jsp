<%-- 
    Document   : ServicioPscologico
    Created on : 12/04/2021, 11:54:39 AM
    Author     : nazar
--%>

<%@page import="java.nio.charset.Charset"%>
<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.beans.Usuarios"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" >
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Servicio Psicologico estudiantil</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_SERVICIO_PSI%>"/>
    </head>
    <body class="marca-servicio">
        <%  HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            Usuarios user = null;
            if (sec == null) {
                sec = new Session();
                sec.setTypeSessionNull(1);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher("/error/error.jsp").forward(request, response);
            } else {
                user = sec.getUser();
            }%>
        <header>
            <nav>   
                <ul class="content-G content">
                    <li><h1 class="content-item-G content-item" >Servicio psicólogico estudiantil</h1></li>
                    <li><img class="content-item-G content-item content-img" src="/siae/resource/images/logo_SIAE.png" width="80" height="80"/></li>
                </ul>
            </nav>
        </header>   
        <div class="content-correo">
        <a class="item-G-A-Selec content-a" 
           href="mailto:sandrabtal@gmail.com?subject=Solicitud de servicio psicólogico
           &body=Nombre: <%=(user == null) ? "" : user.getNombreCompleto()%>%0AMatricula: <%=(user == null) ? "" : user.getIdUsuario()%>%0APrograma educativo: Ingeniería en sistemas computacionales%0ANúmero telefónico: <%=(user == null) ? "" : user.getNumTel()%>">
            Servicio psicólogico <br>Enviar correo</a>
        <a class="item-G-A-Selec content-a" 
           href="mailto:sandrabtal@gmail.com?subject=Solicitud de asesoría legal
           &body=Nombre: <%=(user == null) ? "" : user.getNombreCompleto()%>%0AMatricula: <%=(user == null) ? "" : user.getIdUsuario()%>%0APrograma educativo: Ingeniería en sistemas computacionales%0ANúmero telefónico: <%=(user == null) ? "" : user.getNumTel()%>">
            Asesoría legal<br>Enviar correo</a>
        </div>
    </body>
</html>
