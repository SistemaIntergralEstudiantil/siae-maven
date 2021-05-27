/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isic.siae.modelo.beans;

/**
 * Esta clase representa a los cursos registrados en la BD
 * @author danielhernandezreyes
 * @version 21/04/2021A
 */
public class Curso {
    private int idCurso;
    private String estado;
    private String tipo;
    private int cupo;
    private int idAsignatura;
    private String idResponsable;
    /**
     * Este método obtiene el identificador del curso.
     * @return El identificador del curso
     */
    public int getIdCurso() {
        return idCurso;
    }
    /**
     * Este método asigna el identificador del curso.
     * @param idCurso El identificador del curso.
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    /**
     * Este método obtiene el estado del curso
     * @return 
     * <dl>
     *  <dt><h3>E</h3></dt><dd>Habilitada</dd>
     *  <dt><h3>D</h3></dt><dd>Desabilitada</dd>
     * </dl>
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Este método asigna el estado del curso
     * @param estado El estado del área
     * <dl>
     *  <dt><h3>E</h3></dt><dd>Habilitada</dd>
     *  <dt><h3>D</h3></dt><dd>Desabilitada</dd>
     * </dl>
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Este método obtiene el tipo de curso
     * @return El tipo del curso
     * <dl>
     *  <dt><h3>V</h3></dt><dd>Curso de verano</dd>
     *  <dt><h3>O</h3></dt><dd>Curso ordinal</dd>
     * </dl>
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Este método asigna el tipo del curso.
     * @param tipo 
     * <dl>
     *  <dt><h3>V</h3></dt><dd>Curso de verano</dd>
     *  <dt><h3>O</h3></dt><dd>Curso ordinal</dd>
     * </dl>
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Este método obtiene el total del cupo del curso, al estado actual.
     * @return La cantidad libre del curso
     */
    public int getCupo() {
        return cupo;
    }
    /**
     * Este método asigna el cupo maximo del curso
     * @param cupo La cantidad maxina de alumnos en el curso.
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    /**
     * Este método obtiene el identificador de la asignatura asignada al curso.
     * @return El identificador de la asignatura.
     */
    public int getIdAsignatura() {
        return idAsignatura;
    }
    /**
     * Este método asigna el identificador de la asignatura asignada al curso.
     * @param idAsignatura Este es el identificador de la asignatura.
     */
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    /**
     * Este método obtiene el identificador del responsable del curso.
     * @return El identificador del responsable.
     */
    public String getIdResponsable() {
        return idResponsable;
    }
    /**
     * Este método asigna el identificador del responsable del curso.
     * @param idResponsable Este es el identificador del responsable.
     */
    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }
    
}
