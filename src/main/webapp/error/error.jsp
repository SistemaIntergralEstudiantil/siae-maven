<%-- 
    Document   : error
    Created on : 22/03/2021, 10:51:06 PM
    Author     : sandr
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
        <title>Error</title>
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>" />
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_ERROR%>"/>
    </head>
    <body>
        <%  HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            if(sec == null){
                sec = new Session();
                sec.setTypeSessionNull(1);
            } %>
        <header class="content-G content"><h1 class="content-title" >¡Error en el sistema!</h1></header>
        <div class="content-msj" >
            <h2>Descripción:</h2>
            <p><%= sec.getErrorMsj() %></p>
            <p> Tipo: <%= sec.getErrorType()%></p>
            <a class="content-item-G content-a" href="<%= sec.getErrorUrl() %>" >Regresar</a>
        </div>
        <%
            sec.setErrorType(null);
            sec.setErrorMsj(null);
            sec.setErrorUrl(null);
            
            if(sec.getUser()==null){
                sesion.invalidate();
            }
        %>
    </body>
</html>
