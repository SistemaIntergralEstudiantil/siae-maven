/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Esta clase define la conexión del sistema con la base de datos.
 * @version 26/03/2021/C
 * @author Sandra Monserrat B. L.
 */
public class Conexion {
    private final String user;
    private final String pass;
    private final String direccion;
    private Connection conexion;
    private PreparedStatement estado;
    private CallableStatement estadoProce;
    private ResultSet resultado;
    /**
     * Este es el constructor de la ConexionBD que iniciara con la conexion a la BD.
     */
    public Conexion(){
        user = "b0f7bb3322ff51";
        pass = "3c313618";
        direccion="jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_41e1a77e5a7fbc2?reconnect=true?serverTimezone=UTC";//configurar la zona horaria
    }
    /**
     * Este método crea la conexion con la BD.
     * @throws java.lang.ClassNotFoundException Excepción al establecer el conector.
     * @throws java.sql.SQLException Excepción al realziar la conexión a la base de datos.
     */ 
    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(direccion, user, pass); 
    }
    /**
     * Este método obtiene la conexion a la BD.
     * @return La conexion a la BD.
     */
    public Connection getConexion() {
        return conexion;
    }
    /**
     * Este método obtiene el Estado de la conexion a la BD.
     * @return El estado de la conexion.
     */
    public PreparedStatement getEstado() {
        return estado;
    }
    /**
     * Este método asigan el Estado de la conexión para realizar una nueva consulta SQL.
     * @param estado El estado de conexión.
     */
    public void setEstado(PreparedStatement estado) {
        this.estado = estado;
    }

    public CallableStatement getEstadoProce() {
        return estadoProce;
    }

    public void setEstadoProce(CallableStatement estadoProce) {
        this.estadoProce = estadoProce;
    }
    
    /**
     * Este método obtiene los resultados de la ejecución del SQL.
     * @return Los resultados de ejecución.
     */
    public ResultSet getResultado() {
        return resultado;
    }
    /**
     * Este método asigna el resultado de la execucion del SQL.
     * @param resultado El valor del resultado del SQL.
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }    
    /**
     * Este método cierra la conexión con la BD
     * @throws java.sql.SQLException Excepción al cerrar la conexión a la BD.
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
    /**
     * Este método prepara el estado de la conexión para realizar un SQL 
     * @param sSQL Este es la sentencia SQL
     * @throws SQLException Excepción al preparar la conexión para una consulta.
     */
    public void prepareStatement(String sSQL) throws SQLException {
        this.estado = null;
        this.estado = conexion.prepareStatement(sSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    /**
     * Este método prepara el estado de la conexión para executar un prosedimeiento almacenado 
     * @param paSQL Este es la sentencia de llamada del procedimiento
     * @throws SQLException Excepción al preparar la conexión para el procedimiento.
     */
    public void prepareCallable(String paSQL) throws SQLException {
        this.estadoProce = null;
        this.estadoProce = conexion.prepareCall(paSQL);
    }
    
}
