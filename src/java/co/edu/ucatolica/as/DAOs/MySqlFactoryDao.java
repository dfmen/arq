/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

/**
 *
 * @author sala5
 */
public class MySqlFactoryDao extends FactoryDao {

    @Override
    public EstudianteMySQLDAO getEstudianteDao() {
        return new EstudianteMySQLDAO();
    }  
    
}
