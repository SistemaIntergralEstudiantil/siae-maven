/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.modelo;

import com.isic.siae.modelo.beans.AlumnoRepoD;
import com.isic.siae.modelo.beans.Asignatura;
import com.isic.siae.modelo.beans.ReporteAsig;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Esta clase representa las operaciones de las asignaturas a la base de datos.
 * @version 12/04/2021C
 * @author danielhernandezreyes
 * @see Conexion
 * @see ReporteAsig
 * @see Asignatura
 * @see AlumnoRepoD
 */
public class AsignaturaDAO {
    /**
     * Método obtiene un lista de las asignaturas que son ofertadas actualmente.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene las asignaturas encontrados.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>La lista contiene 0 elementos: no hay asignaturas.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<ReporteAsig> reporte() throws ClassNotFoundException, SQLException{
        String sql = "CALL proce_reporte_cursos()"; // Cambios del SQL
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.setResultado(cn.getEstado().executeQuery());
        ArrayList<ReporteAsig> t = new ArrayList<>();
        while(cn.getResultado().next()){
            ReporteAsig rep = new ReporteAsig();
            rep.setIdCurso( cn.getResultado().getString("idC") );
            rep.setCupo( cn.getResultado().getInt("cupo") );
            rep.setDia( cn.getResultado().getString("dia") );
            rep.setHorario( cn.getResultado().getString("horario") );
            rep.setAsignatura( cn.getResultado().getString("asignatura") );
            rep.setCredito( cn.getResultado().getInt("credito") );
            rep.setDocente( cn.getResultado().getString("docente") );
            rep.setSemestre( cn.getResultado().getInt("semestre") );
            rep.setArea( cn.getResultado().getString("area"));
            t.add(rep);
        }
        cn.getEstado().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método obtiene un lista de todas las asignaturas de todos los semestres.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene todas las asignaturas.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>No hay asignaturas registradas.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<Asignatura> reporteAsignatura() throws SQLException, ClassNotFoundException {
        String sql = "CALL proce_reporte_asignatura(?)";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.getEstado().setBoolean(1, true);
        cn.setResultado(cn.getEstado().executeQuery());
        ArrayList<Asignatura> t = new ArrayList<>();
        while(cn.getResultado().next()){
            Asignatura a = new Asignatura();
            a.setIdAsignatura( cn.getResultado().getInt("idA") );
            a.setSemestre( cn.getResultado().getInt("semestre") );
            a.setNombre( cn.getResultado().getNString("nombre") );
            a.setArea( cn.getResultado().getString("area") );
            a.setCredito( cn.getResultado().getInt("credito") );
            a.setArea( cn.getResultado().getString("area"));
            t.add(a);
        }
        cn.getEstado().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método obtiene un lista de todas las asignaturas que estan habilitadas en<br> 
     * el semestre en curso.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista de las asignaturas Habilitadas.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>No hay asignaturas Habilitadas.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<Asignatura> reporteAsignaturaActivas() throws SQLException, ClassNotFoundException {
        String sql = "CALL proce_reporte_asignatura(?)";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.getEstado().setBoolean(1, false);
        cn.setResultado(cn.getEstado().executeQuery());
        ArrayList<Asignatura> t = new ArrayList<>();
        while(cn.getResultado().next()){
            Asignatura a = new Asignatura();
            a.setIdAsignatura( cn.getResultado().getInt("idAsignatura") );
            a.setNombre( cn.getResultado().getNString("nombre") );
            t.add(a);
        }
        cn.getEstado().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método obtiene un lista de todos las alumnos de todas las materias de un<br>
     * determinado docente, los cuales servira para reportar su status del curso
     * inmediato de cada alumno.
     * @param idUsuario El identificador del docente.
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista contiene todas las alumnos.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>No hay alumnos registradas.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<AlumnoRepoD> reporteAlumnoCursoD( String idUsuario) throws SQLException, ClassNotFoundException {
        String sql = "CALL proce_reporte_curso_docente(?);";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareStatement(sql);
        cn.getEstado().setString(1, idUsuario);
        cn.setResultado(cn.getEstado().executeQuery());
        ArrayList<AlumnoRepoD> t = new ArrayList<>();
        while(cn.getResultado().next()){
            AlumnoRepoD a = new AlumnoRepoD();
            a.setIdCurso(cn.getResultado().getInt("idC"));
            a.setTipo(cn.getResultado().getString("tipo"));
            a.setMatricula(cn.getResultado().getString("m"));
            a.setAlumno(cn.getResultado().getString("alumno"));
            a.setIdAsignatura( cn.getResultado().getInt("idA") );
            a.setAsignatura(cn.getResultado().getString("asignatura"));
            a.setSemestre( cn.getResultado().getInt("semestre") );
            a.setReporte(cn.getResultado().getString("reporte"));
            t.add(a);
        }
        cn.getEstado().close();
        cn.getConexion().close();
        return t;
    }
    /**
     * Método registra la solicitud de asignaturas para el curso de verano.
     * @param idAsignatura El identificador de la asignatura
     * @param matricula El identificador del alumno
     * @param fin <h3>T</h3>: La solicitud terminada.
     * 
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public void solicitarVerano(int idAsignatura, String matricula, String fin) throws ClassNotFoundException, SQLException{
        String sql = "{CALL proce_solicitar_verano( ?, ?, ?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setInt(1, idAsignatura);
        cn.getEstadoProce().setString(2, matricula);
        cn.getEstadoProce().setString(3, fin);
        cn.getEstadoProce().executeUpdate();
        cn.getEstadoProce().close();
        cn.getConexion().close();
    }
    /**
     * Método valida las solicitudes para verano.
     * @param matricula El identificador del alumno
     * @return <h3>True</h3>: Las solicitudes estan activas.
     * <h3>False</h3>: Las solicitudes estan bloqueadas.
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public boolean solicitarVerano(String matricula) throws ClassNotFoundException, SQLException {
        String sql = "{CALL proce_activo_verano(?)}";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.getEstadoProce().setString(1, matricula);
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
     * Método obtiene un lista de las asignaturas que son solicitadas<br> 
     * para el curso de verano
     * @return
     * <dl>
     *  <dt><h3>ArrayList(x)</h3></dt><dd>La lista de las asignaturas solicitadas.</dd>
     *  <dt><h3>ArrayList(0)</h3></dt><dd>No hay asignaturas solicitadas.</dd>
     * </dl>
     * @throws ClassNotFoundException Excepción al establecer el conector.
     * @throws SQLException Excepción al realizar la conexión con la BD.
     */
    public ArrayList<Asignatura> reporteAsignaturaVerano() throws SQLException, ClassNotFoundException {
        String sql = "CALL proce_reporte_verano()";
        Conexion cn = new Conexion();
        cn.conectar();
        cn.prepareCallable(sql);
        cn.setResultado(cn.getEstadoProce().executeQuery());
        ArrayList<Asignatura> t = new ArrayList<>();
        while(cn.getResultado().next()){
            Asignatura a = new Asignatura();
            a.setIdAsignatura( cn.getResultado().getInt("idA") );
            a.setSemestre(cn.getResultado().getInt("semestre"));
            a.setNombre( cn.getResultado().getNString("nombre") );
            a.setCredito( cn.getResultado().getInt("credito"));
            a.setSolicitar( cn.getResultado().getInt("solicitar"));
            t.add(a);
        }
        cn.getEstadoProce().close();
        cn.getConexion().close();
        return t;
    }
}
