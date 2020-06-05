/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.DAOs;

import co.edu.ucatolica.as.DTOs.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nixoduaa
 */
public class EstudianteMySQLDAO implements EstudianteDAO{
    
    
    
    @Override
    public boolean crearEstudiante(Estudiante p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            //Hola
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando crearEstudiante...");
            
            pstmt = con.prepareStatement("INSERT INTO estudiante (codigo_estudiante, nombre_estudiante, apellido_estudiante, "
                    + " fecha_nacimiento, cedula, password, semestre, email, codigo_matricula, codigo_contrato, codigo_programa"
                    + " ) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            
            //pstmt.setInt(1,p.getId());
            pstmt.setString(1, p.getCodigo_estudiante());
            pstmt.setString(2, p.getNombre_estudiante());
            pstmt.setString(3, p.getApellido_estudiante());
            pstmt.setString(4, p.getFecha_nacimiento());
            pstmt.setString(5, p.getCedula());
            pstmt.setString(6, p.getPassword());
            pstmt.setString(7, p.getSemestre());
            pstmt.setString(8, p.getEmail());
            pstmt.setString(9, p.getCodigo_matricula());
            pstmt.setString(10, p.getCodigo_contrato());
            pstmt.setString(11, p.getCodigo_programa());
            
            //Este es un comentario
            
            pstmt.execute();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }

    @Override
    public ArrayList<Estudiante> consultarEstudiante(Estudiante p, Connection con)
    {
        
        ArrayList<Estudiante> datos = new ArrayList();
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT codigo_estudiante, nombre_estudiante,apellido_estudiante, "
                    + " fecha_nacimiento, cedula, password, semestre, email, codigo_matricula, codigo_contrato, codigo_programa"
                    //+ " id_persona "
                    + " FROM estudiante "
                    + " WHERE "
                    + " codigo_estudiante = " + p.getCodigo_estudiante());
//                    + " AND nombre_1='"+p.getNombre1()+"'");
            
            while (rs.next())
            { 
                Estudiante per = new Estudiante();
                per.setCodigo_estudiante(rs.getString(1));
                per.setNombre_estudiante(rs.getString(2));
                per.setApellido_estudiante(rs.getString(3));
                per.setFecha_nacimiento(rs.getString(4));
                per.setCedula(rs.getString(5));
                per.setPassword(rs.getString(6));
                per.setSemestre(rs.getString(7));
                per.setEmail(rs.getString(8));
                per.setCodigo_matricula(rs.getString(9));
                per.setCodigo_contrato(rs.getString(10));
                per.setCodigo_programa(rs.getString(11));
                
                
                //per.setId(rs.getInt(11));
                
                datos.add(per);
                
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando consultarEstudiante fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
          
    @Override
    public boolean editarEstudiante(Estudiante p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando editarEstudiante...");
            
            pstmt = con.prepareStatement("UPDATE estudiante "
                    + " SET "
                    + " codigo_estudiante=?"
                    + " , nombre_estudiante=?"
                    + " , apellido_estudiante=?"
                    + " , fecha_nacimiento=?"
                    + " , cedula=?"
                    + " , password=?"
                    + " , semestre=?"
                    + " , email=?"
                    + " , codigo_matricula=?"
                    + " , codigo_contrato=?"
                    + " , codigo_programa"
                    + " WHERE codigo_estudiante =" + p.getCodigo_estudiante());
                        
            pstmt.setString(1, p.getCodigo_estudiante());
            pstmt.setString(2, p.getNombre_estudiante());
            pstmt.setString(3, p.getApellido_estudiante());
            pstmt.setString(4, p.getFecha_nacimiento());
            pstmt.setString(5, p.getCedula());
            pstmt.setString(6, p.getPassword());
            pstmt.setString(7, p.getSemestre());
            pstmt.setString(8, p.getEmail());
            pstmt.setString(9, p.getCodigo_matricula());
            pstmt.setString(10, p.getCodigo_contrato());
            pstmt.setString(11, p.getCodigo_programa());
            //pstmt.setInt(4, p.getId());
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }
    
    public boolean eliminarEstudiante(Estudiante p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando eliminarEstudiante...");
        try {
            
            pstmt = con.prepareStatement("DELETE FROM estudiante "                    
                    + " WHERE "
                    + " codigo_estudiante = " + p.getCodigo_estudiante());
            
            pstmt.executeUpdate();
        
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando eliminarEstudiante fin...");
            
            con.close();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
    
    public ArrayList<Estudiante> validarEstudiante(Estudiante p, Connection con)
    {
        
        ArrayList<Estudiante> datos = new ArrayList();
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante...");
        
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT e.codigo_estudiante"
                    + " FROM estudiante e, estudiante_curso ec, curso c"
                    + " WHERE e.codigo_estudiante = ec.codigo_estudiante"
                    + " AND ec.codigo_curso = c.codigo_curso"
                    + " AND e.codigo_estudiante = " + p.getCodigo_estudiante()
                    + " AND c.codigo_curso = " + p.getEst_curso());
           
            
            while (rs.next())
            { 
                Estudiante per = new Estudiante();
                per.setCodigo_estudiante(rs.getString(1));                
                
                datos.add(per);    
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
}
