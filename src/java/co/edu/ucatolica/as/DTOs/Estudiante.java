/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DTOs;

/**
 *
 * @author nixoduaa
 */
public class Estudiante {

            int id = 0;
            String codigo_estudiante = null;
            String nombre_estudiante = null;
            String apellido_estudiante = null;
            String fecha_nacimiento = null;
            String cedula = null;
            String password = null;
            String semestre = null;
            String email = null;
            String codigo_matricula = null;
            String codigo_contrato = null; 
            String codigo_programa = null;

    public String getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public String getApellido_estudiante() {
        return apellido_estudiante;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getEmail() {
        return email;
    }

    public String getCodigo_matricula() {
        return codigo_matricula;
    }

    public String getCodigo_contrato() {
        return codigo_contrato;
    }

    public String getCodigo_programa() {
        return codigo_programa;
    }

    public void setCodigo_estudiante(String codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public void setApellido_estudiante(String apellido_estudiante) {
        this.apellido_estudiante = apellido_estudiante;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCodigo_matricula(String codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public void setCodigo_contrato(String codigo_contrato) {
        this.codigo_contrato = codigo_contrato;
    }

    public void setCodigo_programa(String codigo_programa) {
        this.codigo_programa = codigo_programa;
    }
          
}
