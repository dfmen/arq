/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

import co.edu.ucatolica.as.DTOs.Estudiante;
import co.edu.ucatolica.as.bds.MySqlDataSource;
import java.sql.Connection;

/**
 *
 * @author sala5
 */
public class EstudianteMySqlFactoryDao {
    private Connection cn;

    public EstudianteMySqlFactoryDao() {
        cn = MySqlDataSource.getConexionBD();
    }

    public Estudiante buscarUsuario(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void insertarUsuario(Estudiante usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificarUsuario(Estudiante usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
