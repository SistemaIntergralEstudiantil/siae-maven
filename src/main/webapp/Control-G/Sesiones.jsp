<%-- 
    Document   : Sesiones
    Created on : 19/04/2021, 09:34:30 PM
    Author     : danielhernandezreyes
--%>

<%@page import="java.nio.charset.Charset"%>
<%@page import="com.isic.siae.modelo.beans.Sesion"%>
<%@page import="com.isic.siae.conector.Url"%>
<%@page import="com.isic.siae.modelo.Session"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="<%=Url.DESCRIPTION.getBytes(Charset.forName("ISO-8859-1"))%>"/>
        <title>Menu de control sesiones</title>
        <link rel="shortcut icon" href="<%=Url.IMG_LOGO_SIAE%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_GENERAL%>"/>
        <link rel="stylesheet" href="<%=Url.CSS_CONTROL%>"/>
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
        <% String as = (String)request.getAttribute("asignatura"); String asignatura = new String(as.getBytes("ISO-8859-1")); %>
        <% String res = (String)request.getAttribute("responsable"); String responsable = new String(res.getBytes("ISO-8859-1")); %>
        <li><a class="content-item-G content-item selec-none info" href="#dia">Clases de: <%=(responsable==null)?"":responsable %> <br>correspondientes a la materia <%=(asignatura==null)?"":asignatura %></a></li>
        <li><a class="content-item-G content-item selec-none" href="#dia">Control Sesiones</a></li>
        <li><img class="content-item-G content-item content-img" src="<%=Url.IMG_LOGO_SIAE%>" width="80" height="80"/></li>
    </ul>
    </nav>
    </header>
    <div class="content-center">
        <div class="content-left">
            <form action="Control" method="POST" onsubmit="return validarForm3();" >
                <% String idCurso = (String)request.getAttribute("idCurso"); %>
                <div class="item-option" ><label>Id Curso:</label><label><%=(idCurso==null)?"": idCurso %></label></div>
                <div class="item-option" ><label>Dia:<select class="item-selec" id="dia" name="dia">
                    <option value="0" disabled selected>Dia ...</option>
                    <option value="Lunes">Lunes</option><option value="Martes">Martes</option><option value="Miercoles">Miercoles</option>
                    <option value="Jueves">Jueves</option><option value="Viernes">Viernes</option>
                </select></label>
                </div>
                <div class="item-option" ><label>Hora inicio: <input class="input-number" type="time" name="hora_inicio" id="hora_inicio" min="07:00" max="21:00" value="08:00" ></label></div>
                <div class="item-option" ><label>Hora fin: <input class="input-number" type="time" name="hora_fin" id="hora_fin" min="07:00" max="21:00" value="08:00" ></label></div>
                <div class="item-option" >
                    <input type="hidden" name="idCurso" value="<%=(idCurso==null)?"":idCurso %>">
                    <input type="hidden" name="responsable" value="<%=(responsable==null)?"":responsable %>">
                    <input type="hidden" name="asignatura" value="<%=(asignatura==null)?"":asignatura %>">
                    <input type="hidden" name="clave" value="session-add">
                    <input class="input-submit" id="add" type="submit" value="Agregar Sesión" ></div>
            </form>
        </div>
        <div class="content-right content-table-dimanyc" >
            <table class="table" >
            <thead>
                <tr>
                    <th style="width: 1rem;">Id Sesión</th>
                    <th style="width: 1rem;">Dia</th>
                    <th style="width: 1rem;">Hora Inicio</th>
                    <th style="width: 2rem;">Hora Fin</th>
                    <th style="width: 2rem;">Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%  if(sec != null) {
                        ArrayList<Sesion> l = (ArrayList<Sesion>) request.getAttribute("lista-S");
                        for(Sesion s : l) { %>
                <tr><th><%=s.getIdSesion() %></th>
                    <th><%=s.getDia() %></th>
                    <th><%=s.getHora_inicio() %></th>
                    <th><%=s.getHora_fin() %></th>
                    <th><form action="Control" method="POST" >
                        <input type="hidden" name="clave" value="session-delete">
                        <input type="hidden" name="idCurso" value="<%=(idCurso==null)?"":idCurso %>">
                        <input type="hidden" name="responsable" value="<%=(responsable==null)?"":responsable %>">
                        <input type="hidden" name="asignatura" value="<%=(asignatura==null)?"":asignatura %>">
                        <input type="hidden" name="idSesion" value="<%=s.getIdSesion() %>">
                        <input class="input-submit-table input-T-D" type="submit" value="Eliminar">
                        </form></th>
                </tr><% } } %>
            </tbody>
            </table>
        </div>
        </div>
        <footer class="footer">
        <nav>
            <ul class="content-footer">
                <li><a class="item-footer" href="Control?clave=course">Menu cursos</a></li>
                <li><%String mensaje = (String) request.getAttribute("msj");%>
                    <label class="item-mensaje"><%=(mensaje==null)?"-":mensaje %></label>
                </li>
            </ul>
        </nav>
        </footer>
        <script src="/siae/resource/js/Script-Control.js"></script>
    </body>
</html>
