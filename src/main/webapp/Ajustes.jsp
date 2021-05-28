<%-- 
    Document   : Ajustes
    Created on : 7/04/2021, 08:13:44 PM
    Author     : danielhernandezreyes
--%>

<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.beans.Usuarios"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Ajustes</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_AJUSTES%>"/>
    </head>
    <body style="background-image: url(<%=Url.IMG_MENU_PRINCIPAL%>);background-size: 100% 130%;background-repeat: no-repeat">
        <%  HttpSession sesion = request.getSession();
            Session sec = (Session) sesion.getAttribute("user");
            Usuarios user = null;
            if (sec == null) {
                sec = new Session();
                sec.setTypeSessionNull(1);
                sesion.setAttribute("user", sec);
                request.getRequestDispatcher("/error/error.jsp").forward(request, response);
            } else { user = sec.getUser(); }
            %>
        <header>
        <nav>
        <ul class="content-G content">
            <li><h1 class="content-item-G content-item" >Configuración del perfil del usuario: <%=(user!=null)?user.getIdUsuario():"" %></h1></li>                    
            <li><img class="content-item-G content-item content-img" src="<%=Url.IMG_LOGO_SIAE%>" width="80" height="80" alt="alt"/></li>
        </ul>
        </nav>
        </header>
        <form action="<%=Url.SER_CAMBIAR_DATOS%>" method="POST" enctype="multipart/form-data" >
            <div class = "profile-pic-div">
                <% if(user != null) { 
                    if(user.aFoto != null) { %>
                <img src="data:image/png;base64,<%= Base64.getEncoder().encodeToString(user.aFoto)%>" id="foto"/>
                <% } else { %><img src="<%=Url.IMG_ISIC_CIRCULO%>" id="foto"/><% } }%>
                <input name="foto" type="file" id="file" /><label for ="file" id="subirFoto">Seleccionar foto de perfil</label>
            </div>
            <abbr title="Seleccione el ícono del avatar para modificar su foto de perfil y proporcionar su contraseña actual">
                <img src="<%=Url.IMG_ICON_HELP%>" width="40" height="40" style="float: right"/></abbr>
            <dl class="content-data">
            <div class="content-data_row" >
                <dt class="data_dt data_d" >Confirmar contraseña:</dt>
                <dd class="data_dd data_d" >
                    <input id="pass-uno" type="password" name="contra" required />
                    <span id="mostrar-uno" class="mostrar" >mostrar</span>
                </dd>
                <dt class="data_dt data_d" ></dt>
                <dd class="data_dd data_d" ><input type="submit" class="btnSubmit btnFoto" value="Modificar Foto"/></dd>
            </div>
            </dl>
            <input type="hidden" name="clave" value="change-foto"/>
        </form>
        
        <form action="<%=Url.SER_CAMBIAR_DATOS%>" method="POST" onsubmit="return validarForm();" >
        <dl class="content-data" >
            <div class="content-data_row">
                <dt class="data_dt data_d" >Contraseña actual:</dt>
                <dd class="data_dd data_d" >
                    <input id="pass-dos" type="password" name="contra" required />
                    <span id="mostrar-dos" class="mostrar" >mostrar</span>
                </dd>
            </div>
            <div class="content-data_row">
                <dt class="data_dt data_d" >Contraseña nueva:</dt>
                <dd class="data_dd data_d" >
                    <input id="pass-tres" type="password" name="newContra" id="newContra" required />
                    <span id="mostrar-tres" class="mostrar" >mostrar</span>
                </dd>
            </div>
            <div class="content-data_row">
                <dt class="data_dt data_d" >Confirmar contraseña:</dt>
                <dd class="data_dd data_d" >
                    <input id="valideContra" type="password" name="valideContra" required />
                    <span id="mostrar-cuatro" class="mostrar" >mostrar</span>
                </dd>
            </div>
            <div class="content-data_row"><dt><input type="submit" class="btnSubmit" value="Modificar contraseña"/></dt></div>
        </dl>
        <input type="hidden" name="clave" value="change-pass"/>
        </form>
        <a class="item-G-A-Selec content-a" href="<%=Url.URL_HOME%>">Menú principal</a>
        <script src="<%=Url.JS_PROCFILE%>"></script>
        <script src="<%=Url.JS_AJUSTES%>"></script>
        <script src="<%=Url.JS_PASS%>"></script>
    </body>
</html>

