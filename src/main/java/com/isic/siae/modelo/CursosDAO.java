/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.modelo;

import com.isic.siae.modelo.beans.Asignatura;
import com.isic.siae.modelo.beans.Curso;
import com.isic.siae.modelo.beans.CursoAlumno;
import com.isic.siae.modelo.beans.ReporteAlumno;
import com.isic.siae.modelo.beans.ReporteCurso;
import com.isic.siae.modelo.beans.Sesion;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author danielhernandezreyes
 * @see Curso
 */
public class CursosDAO {
    /**
     * Método obtiene un lista de todos los cursos registrados.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene información de los cursos registrados.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>La lista contiene 0 elementos: no hay cursos.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<ReporteCurso> reporteCursos() throws ClassNotFoundException, SQLException{
        String sql = "CALL proce_consulta_curso()";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.setResultado(cn.getEstado().executeQuery());
        ArrayList<ReporteCurso> t = new ArrayList<>();
        while(cn.getResultado().next()){
            ReporteCurso rep = new ReporteCurso();
            rep.setIdCurso( cn.getResultado().getInt("idC") );
            rep.setTipo(cn.getResultado().getString("tipo"));
            rep.setEstado(cn.getResultado().getString("estado"));
            rep.setCupo( cn.getResultado().getInt("cupo") );
            rep.setIdAsignatura(cn.getResultado().getInt("idA"));
            rep.setIdResponsable(cn.getResultado().getString("idR"));
            rep.setAsignatura(cn.getResultado().getString("nombre"));
            rep.setResponsable(cn.getResultado().getString("docente"));
            t.add(rep);
        }
        cn.getEstado().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método agrega un nuevo curso a la BD.
     * @param nuevo Los datos del curso nuevo a registrar.
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void addCurso(Curso nuevo) throws ClassNotFoundException, SQLException{
        String sql = "CALL proce_nuevo_curso(?, ?, ?, ?, ?, ?)";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.getEstado().setInt(1, nuevo.getIdCurso());
        cn.getEstado().setString(2, nuevo.getTipo());
        cn.getEstado().setString(3, nuevo.getEstado());
        cn.getEstado().setInt(4, nuevo.getCupo());
        cn.getEstado().setInt(5, nuevo.getIdAsignatura());
        cn.getEstado().setString(6, nuevo.getIdResponsable());
        cn.getEstado().executeUpdate();
        
        cn.getEstado().close();
        cn.getConexion().close();
    }
    /**
     * Método cambia el estado del curso asignada.
     * @param change Los datos del curso.
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void changeStatusCurso(Curso change) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_estado_curso(?, ?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, change.getIdCurso());
        cn.getEstadoProce().setString(2, change.getEstado());
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método obtiene un lista de las sesiones de un curso espesifico.
     * @param curso Datos del curso para obtener las sesiones.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista de sesiones del curso.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>El curso no tiene sesiones.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<Sesion> reporteToSesiones(Curso curso) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_consulta_sesion(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, curso.getIdCurso());
        cn.setResultado(cn.getEstadoProce().executeQuery());
        ArrayList<Sesion> t = new ArrayList<>();
        while(cn.getResultado().next()){
            Sesion s = new Sesion();
            s.setIdSesion(cn.getResultado().getInt("idSesion"));
            s.setIdCurso( cn.getResultado().getInt("idCurso") );
            s.setDia(cn.getResultado().getString("dia"));
            s.setHora_inicio(cn.getResultado().getString("hora_inicio"));
            s.setHora_fin(cn.getResultado().getString("hora_fin"));
            t.add(s);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método cambia el estado del curso asignada.
     * @param change Los datos del curso.
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void newSessionCurso(Sesion change) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_nueva_sesion(?, ?, ?, ?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, change.getIdCurso());
        cn.getEstadoProce().setString(2, change.getDia());
        cn.getEstadoProce().setString(3, change.getHora_inicio());
        cn.getEstadoProce().setString(4, change.getHora_fin());
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método elimina una sesión de un curso en particular.
     * @param delete Los datos de la sesión a eliminar.
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void deleteSessionCurso(Sesion delete) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_eliminar_sesion(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, delete.getIdSesion());
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método cambia el estado de un alumno respeto a una materia<br>
     * @param alumno Datos del alumno y de la materia a cambiar
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void changeStatusAlumno(CursoAlumno alumno) throws SQLException, ClassNotFoundException {
        String sql = "{CALL proce_cambio_status_alumno(?, ?, ?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, alumno.getIdCurso());
        cn.getEstadoProce().setString(2, alumno.getMatricula());
        cn.getEstadoProce().setString(3, alumno.getEstado());
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método obtiene un lista de todos los cursos disponibles para altas.
     * @param matricula El identificador del alumno
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene información de los cursos disponibles.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>La lista contiene 0 elementos: no hay cursos disponibles.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<ReporteCurso> reporteCursosAltas(String matricula) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_reporte_cursos_ov(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setString(1, matricula);
        cn.setResultado(cn.getEstadoProce().executeQuery());
        ArrayList<ReporteCurso> t = new ArrayList<>();
        while(cn.getResultado().next()){
            ReporteCurso rep = new ReporteCurso();
            rep.setIdCurso( cn.getResultado().getInt("idC") );
            rep.setIdAsignatura(cn.getResultado().getInt("idA"));
            rep.setSemestre(cn.getResultado().getInt("semestre"));
            rep.setAsignatura(cn.getResultado().getString("nombre"));
            rep.setCupo( cn.getResultado().getInt("cupo") );
            rep.setCredito(cn.getResultado().getInt("credito") );
            rep.setTipo(cn.getResultado().getString("tipo"));
            rep.setEstado(cn.getResultado().getString("oportunidad"));
            t.add(rep);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método obtiene un lista de todos los cursos, en los que el alumno fue aceptado.
     * @param matricula El identificador del alumno
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene información de los cursos disponibles.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>La lista contiene 0 elementos: no hay cursos disponibles.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<ReporteCurso> reporteCursosBajas(String matricula) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_reporte_registro_cursos(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setString(1, matricula);
        cn.setResultado(cn.getEstadoProce().executeQuery());
        ArrayList<ReporteCurso> t = new ArrayList<>();
        while(cn.getResultado().next()){
            ReporteCurso rep = new ReporteCurso();
            rep.setIdCurso( cn.getResultado().getInt("idC") );
            rep.setIdAsignatura(cn.getResultado().getInt("idA"));
            rep.setSemestre(cn.getResultado().getInt("semestre"));
            rep.setAsignatura(cn.getResultado().getString("nombre"));
            rep.setCupo( cn.getResultado().getInt("cupo") );
            rep.setCredito(cn.getResultado().getInt("credito") );
            rep.setTipo(cn.getResultado().getString("tipo"));
            rep.setEstado(cn.getResultado().getString("oportunidad"));
            t.add(rep);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método obtiene un lista de todos los cursos, en los que el alumno fue aceptado.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene información de los alumnos.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>La lista contiene 0 elementos: información.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<ReporteAlumno> reporteAlumnos() throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_consulta_alumnos()}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.setResultado(cn.getEstadoProce().executeQuery());
        ArrayList<ReporteAlumno> t = new ArrayList<>();
        while(cn.getResultado().next()){
            ReporteAlumno rep = new ReporteAlumno();
            rep.setIdCurso( cn.getResultado().getInt("idC") );
            rep.setIdAsignatura(cn.getResultado().getInt("idA"));
            rep.setMatricula(cn.getResultado().getString("matricula"));
            rep.setAsignatura(cn.getResultado().getString("nombre"));
            rep.setAlumno(cn.getResultado().getString("alumno") );
            rep.setEstado(cn.getResultado().getString("estado") );
            rep.setTipo(cn.getResultado().getString("tipo") );
            rep.setCredito(cn.getResultado().getInt("credito") );
            rep.setOportunidad(cn.getResultado().getString("oport"));
            t.add(rep);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método registra la solicitud de inscripción un alumno a un curso.
     * @param idCurso El identificador del curso.
     * @param matricula El identificador del alumno.
     * @param estado La relación del alumno con las repeticiones de la materia
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void registrarAltaAlumnoCurso(int idCurso, String matricula, int estado) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_solicitar_alta(?,?,?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, idCurso);
        cn.getEstadoProce().setString(2, matricula);
        cn.getEstadoProce().setInt(3, estado);
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método registra la solicitud de baja, de un alumno de un curso.
     * @param idCurso El identificador del curso.
     * @param matricula El identificador del alumno.
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void registrarBajaAlumnoCurso(int idCurso, String matricula) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_solicitar_baja(?,?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, idCurso);
        cn.getEstadoProce().setString(2, matricula);
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método acepta o rechaza las solicitudes de alta o baja.
     * @param idCurso El identificador del curso.
     * @param matricula El identificador del alumno.
     * @param operacion La operación analizada alta(A) o baja(B).
     * @param estado El el resultado del analisis Aceptada(A) o Rechazada(R).
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void registrarComprobacionBajaAlta(int idCurso, String matricula, String operacion, String estado) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_registrar_baja_alta(?,?,?,?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, idCurso);
        cn.getEstadoProce().setString(2, matricula);
        cn.getEstadoProce().setString(3, operacion);
        cn.getEstadoProce().setString(4, estado);
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método cambia el estado de las solicitudes para cursos de verano.
     * @param estado El estado de de cambio de las solicitudes
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void activarVerano(boolean estado) throws ClassNotFoundException, SQLException {
        String sql = "{CALL proce_estado_solicitud_verano(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setBoolean(1, estado);
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método valida las solicitudes para verano.
     * @return <h3>True</h3>: Las solicitudes estan activas.
     * <h3>False</h3>: Las solicitudes estan bloqueadas.
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public boolean estadoVerano() throws ClassNotFoundException, SQLException {
        String sql = "{CALL proce_estado_verano()}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.setResultado( cn.getEstadoProce().executeQuery());
        boolean estado = false;
        while(cn.getResultado().next()) {
            estado = cn.getResultado().getBoolean("verano");
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return estado;
    }
    /**
     * Método obtiene el reporte academico de las asignaturas aprobadas, reprobadas y no cursadas.
     * @param matricula El identificador del alumno.
     * @return La lista contiene información de los alumnos.
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<Asignatura> reporteAcademico(String matricula) throws ClassNotFoundException, SQLException {
        String sql = "{CALL proce_segimiento_academico(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setString(1, matricula);
        cn.setResultado( cn.getEstadoProce().executeQuery());
        ArrayList<Asignatura> lista = new ArrayList<>();
        while(cn.getResultado().next()) {
            Asignatura a = new Asignatura();
            a.setIdAsignatura(cn.getResultado().getInt("idA"));
            a.setNombre( cn.getResultado().getString("nombre"));
            a.setEstado( cn.getResultado().getString("estado"));
            a.setSemestre( cn.getResultado().getInt("semestre"));
            a.setCredito( cn.getResultado().getInt("credito"));
            lista.add(a);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return lista;
    }
}
