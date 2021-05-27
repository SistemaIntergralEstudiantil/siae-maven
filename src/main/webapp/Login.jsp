<%-- 
    Document   : Login
    Created on : 22/03/2021, 12:11:40 PM
    Author     : sandr
--%>

<%@page import="com.isic.siae.conector.Url"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" >
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION%>"/>
        <title>Login </title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>" />
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_LOGIN%>"/>
    </head>
    <body style="background-image: url(resource/images/Login.png);background-size: 100% 150%;">
        <table width="100%">
            <tr>
                <td align="center" width="33%"><img src="<%=Url.IMG_LOGO_TECNM%>" height="80" width="180"></td>
                <td align="center" width="33%"><img src="<%=Url.IMG_LOGO_TEC%>" height="100" width="190"></td>
                <td align="center" width="33%"><img src="<%=Url.IMG_LOGO_ISIC%>" height="80" width="150"></td>
            </tr>
        </table>
        <p align="center"><img src="<%=Url.IMG_LOGO_SIAE%>" height="180" width="180"></p>
        <div class="content-form">
        <center>
            <form action="Login" method="POST">
                <div>
                    <label for="user" class="lbl-user">Matricula o Número de control</label>
                    <input id="user" type="text" name="idUsuario"/>
                </div><br>
                <div id="content-pass">
                    <label for="pass" class="lbl-pass">Introduce tu contraseña</label>
                    <input  id="pass" type="password" name="contra" />
                    <span id="mostrar" >mostrar</span>
                </div><br>
                <div>
                    <input type="hidden" name="clave" value="log"/>
                    <input type="submit" value="Ingresar">
                </div>
            </form>
        </center>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="<%=Url.JS_LOGIN%>"></script>
        <script src="<%=Url.JS_PASS%>"></script>
    </body>
</html>
