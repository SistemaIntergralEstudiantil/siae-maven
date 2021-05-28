/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.conector;

/**
 * Esta clase representa las direcciones de los JSP.
 * @version 09/05/2021C
 * @author danielhernandezreyes
 */
public class Url {
    /**
     * Directorio Raiz.
     */
    private static final String URL_BASE = "https://app-siae.herokuapp.com/";
    public static String SER_REPORTE_ASIGNATURA = URL_BASE + "ReporteAsignatura";
    public static String SER_VERANO = URL_BASE + "Verano";
    public static String SER_CONTROL_CARGA_ACADEMICA = URL_BASE + "ControlCargaAcademica";
    public static String SER_CONTROL = URL_BASE + "Control";
    public static String SER_CONTROL_ALTA_BAJA = URL_BASE + "ControlAltaBaja";
    public static String SER_CAMBIOS_CA = URL_BASE + "CambiosCA";
    public static String SER_DOCENTE = URL_BASE + "Docente";
    public static String SER_LOGIN = URL_BASE + "Login";
    public static String SER_CAMBIAR_DATOS = URL_BASE + "CambiarDatos";
    public static String SER_ASIGNATURA_SERV = URL_BASE + "AsignaturaServ";
    public static String SER_ASESORIAS = URL_BASE + "Asesorias";
    /**
     * Dirección de absulta de la página Home.
     */
    public static String URL_HOME = URL_BASE + "session/Home.jsp";
    /**
     * Dirección de absulta de la página Login.
     */
    public static String URL_LOGIN = URL_BASE + "Login.jsp";
    /**
     * Dirección de absulta de la página Ajustes.
     */
    public static String URL_AJUSTES = URL_BASE + "Ajustes.jsp";
    /**
     * Dirección de absulta de la página de Error.
     */
    public static String URL_ERROR = URL_BASE + "error/error.jsp";
    /**
     * Dirección de absulta de la página de Cursos.
     */
    public static String URL_DOCENTE_CURSOS = URL_BASE + "Docente/Cursos.jsp";
    /**
     * Dirección de absulta de la página de Control sesiones.
     */
    public static String URL_CONTROLG_SESIONES = URL_BASE + "Control-G/Sesiones.jsp";
    /**
     * Dirección de absulta de la página de Control cursos.
     */
    public static String URL_CONTROLG_MENU = URL_BASE + "Control-G/Menu.jsp";
    /**
     * Dirección de absulta de la página de Control asesorias.
     */
    public static String URL_CONTROLG_MENU_2 = URL_BASE + "Control-G/Menu_2.jsp";
    /**
     * Dirección de absulta de la página de control de altas y bajas.
     */
    public static String URL_CONTROLG_MENU_3 = URL_BASE + "Control-G/Menu_3.jsp";
    /**
     * Dirección de absulta de la página de reporte de las solicitudes<br>
     * para los cursos de verano.
     */
    public static String URL_CONTROLG_MENU_4 = URL_BASE + "Control-G/Menu_4.jsp";
    /**
     * Dirección de absulta de la página de Curricula ménu.
     */
    public static String URL_CURRICULA_MENU = URL_BASE + "curricula/Menu.jsp";
    /**
     * Dirección de absulta de la página de Curricula áreas de conocimiento.
     */
    public static String URL_CURRICULA_AREAS = "curricula/AreasConocimiento.jsp";
    /**
     * Dirección de absulta de la página de áreas asesoria.
     */
    public static String URL_AREAS_ASESORIA = URL_BASE + "areas/Asesorias.jsp";
    /**
     * Dirección de absulta de la página de áreas servicio.
     */
    public static String URL_AREAS_SERVICIO = URL_BASE + "areas/ServicioPsicologico.jsp";
    /**
     * Dirección de absulta de la página de áreas menu.
     */
    public static String URL_AREAS_MENU = URL_BASE + "areas/Menu.jsp";
    /**
     * Dirección de absulta de la página de altas y bajas.
     */
    public static String URL_ALTAS_Y_BAJAS = URL_BASE + "altasyBajas/AltasyBajas.jsp";
    /**
     * Dirección de absulta de la página de verano.
     */
    public static String URL_VERANO = URL_BASE + "verano/verano.jsp";
    /**
     * Dirección de absulta de la página del seguimiento academico.
     */
    public static String URL_ACADEMIA = URL_BASE + "altasyBajas/academia.jsp";
    /**
     * Dirección de CSS.
     */
    public static final String URL_RESOURSE_CSS = URL_BASE + "resource/css/";
    public static String CSS_ACADEMIA = URL_RESOURSE_CSS + "Style-Academia.css";
    public static String CSS_AJUSTES = URL_RESOURSE_CSS + "Style-Ajustes.css";
    public static String CSS_ALTASYBAJAS = URL_RESOURSE_CSS + "Style-AltasYbajas.css";
    public static String CSS_AREAS_APOYO = URL_RESOURSE_CSS + "Style-AreasApoyo.css";
    public static String CSS_AREAS_CONOCIMIENTO = URL_RESOURSE_CSS + "Style-AreasConocimiento.css";
    public static String CSS_ASESORIAS = URL_RESOURSE_CSS + "Style-Asesorias.css";
    public static String CSS_ASIGNATURA = URL_RESOURSE_CSS + "Style-Asignatura.css";
    public static String CSS_CONTROL_ALTAS = URL_RESOURSE_CSS + "Style-Control-Alta.css";
    public static String CSS_CONTROL = URL_RESOURSE_CSS + "Style-Control.css";
    public static String CSS_CURRICULA = URL_RESOURSE_CSS + "Style-Curricula.css";
    public static String CSS_D_CURSOS = URL_RESOURSE_CSS + "Style--D-Cursos.css";
    public static String CSS_ERROR = URL_RESOURSE_CSS + "Style-Error.css";
    public static String CSS_GENERAL = URL_RESOURSE_CSS + "Style-General.css";
    public static String CSS_HOME = URL_RESOURSE_CSS + "Style-Home.css";
    public static String CSS_INICIO = URL_RESOURSE_CSS + "Style-Inicio.css";
    public static String CSS_LOGIN = URL_RESOURSE_CSS + "Style-Login.css";
    public static String CSS_REDES = URL_RESOURSE_CSS + "Style-Redes.css";
    public static String CSS_SERVICIO_PSI = URL_RESOURSE_CSS + "Style-ServicioPsicologico.css";
    public static String CSS_VERANO = URL_RESOURSE_CSS + "Style-Verano.css";
    /**
     * Dirección de IMG.
     */
    public static final String URL_RESOURSE_IMG = URL_BASE + "resource/images/";
    public static String IMG_ISIC_CIRCULO = URL_RESOURSE_IMG + "ISIC-Circulo.png";
    public static String IMG_LOGIN = URL_RESOURSE_IMG + "Login.png";
    public static String IMG_LOGO_TECNM = URL_RESOURSE_IMG + "Logo-TecNM.png";
    public static String IMG_SERV_SPSI = URL_RESOURSE_IMG + "ServSpsi.png";
    public static String IMG_ICON_FACEBOOK = URL_RESOURSE_IMG + "facebook-icono.png";
    public static String IMG_ICON_HELP = URL_RESOURSE_IMG + "help.png";
    public static String IMG_LOGO_ISIC = URL_RESOURSE_IMG + "logo_ISIC.png";
    public static String IMG_LOGO_SIAE = URL_RESOURSE_IMG + "logo_SIAE.png";
    public static String IMG_LOGO_TEC = URL_RESOURSE_IMG + "logo_tec.png";
    public static String IMG_MENU_AREAS = URL_RESOURSE_IMG + "menuAreas.png";
    public static String IMG_MENU_PRINCIPAL = URL_RESOURSE_IMG + "menuPrincipal.png";
    public static String IMG_ORGULLO_ITSOEH = URL_RESOURSE_IMG + "orgulloITSOEH.png";
    public static String IMG_PROCFILE = URL_RESOURSE_IMG + "profile_pic.jpg";
    public static String IMG_ICON_TWITTER = URL_RESOURSE_IMG + "twitter-icon.png";
    public static String IMG_ICON_WEB = URL_RESOURSE_IMG + "web-icono.png";
    /**
     * Dirección de JS.
     */
    public static final String URL_RESOURSE_JS = URL_BASE + "resource/js/";
    public static String JS_AJUSTES = URL_RESOURSE_JS + "Script-Ajustes.js";
    public static String JS_ASIGNATURAS = URL_RESOURSE_JS + "Script-Asignaturas.js";
    public static String JS_CONTROL = URL_RESOURSE_JS + "Script-Control.js";
    public static String JS_CURSOS = URL_RESOURSE_JS + "Script-Cursos.js";
    public static String JS_LOGIN = URL_RESOURSE_JS + "Script-Login.js";
    public static String JS_PROCFILE = URL_RESOURSE_JS + "Script-ProfilePic.js";
    public static String JS_PASS = URL_RESOURSE_JS + "Script-pass.js";
    /**
     * Dirección de PDF.
     */
    public static final String URL_RESOURSE_PDF = URL_BASE + "resource/pdf/";
    /**
     * Descripción del sitio.
     */
    public static final String DESCRIPTION = "SIAE permite a los instructores y estudiantes consultar información sobre los diferentes servicios del instituto";
}
