/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

import co.edu.ucatolica.as.DTOs.Estudiante;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sala5
 */
public interface EstudianteDAO {
    public boolean crearEstudiante(Estudiante p, Connection con);
    public ArrayList<Estudiante> consultarEstudiante(Estudiante p, Connection con);
    public boolean editarEstudiante(Estudiante p, Connection con);
}
