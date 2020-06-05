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
            //-- Si estudiante ya vio la materia ( RS > 0 )
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
                per.setEst_curso(rs.getString(1));
                
                datos.add(per);    
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    public ArrayList<Estudiante> validarEstudiante2(Estudiante p, Connection con)
    {
        
        ArrayList<Estudiante> datos2 = new ArrayList();
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante2...");
        
        try {            
            //-- Si la materia ya tiene monitor ( RS1 == 0 )
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT c.codigo_curso"
                    + " FROM curso c"
                    + " WHERE c.codigo_curso = " + p.getEst_curso()
                    + " AND c.monitor != 0"); 

            while (rs.next())
            { 
                Estudiante per = new Estudiante();              
                per.setEst_curso(rs.getString(1));
                datos2.add(per);    
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante2 fin..." + datos2.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos2;
    }
    
    public boolean validarEstudiante3(Estudiante p, Connection con)
    {
        
        boolean respuesta = false;
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante3...");
        
        try {            
            //-- Si la materia ya tiene monitor ( RS1 > 3.8 )
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT AVG(ec.nota)"
                    + " FROM estudiante e, estudiante_curso ec"
                    + " WHERE e.codigo_estudiante = ec.codigo_estudiante"
                    + " AND e.codigo_estudiante = " + p.getCodigo_estudiante()); 

            while (rs.next())
            {             
                if(Double.parseDouble(rs.getString(1)) > 3.8)
                {
                    respuesta = true;
                }
                else
                {
                    respuesta = false;
                } 
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante3 fin..." + respuesta);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public boolean validarEstudiante4(Estudiante p, Connection con)
    {
        
        boolean respuesta2 = false;
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante3...");
        
        try {            
            //-- Si la materia ya tiene monitor ( RS1 < 22 )
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT SUM(c.creditos)"
                    + " FROM estudiante e, estudiante_curso ec, curso c"
                    + " WHERE e.codigo_estudiante = ec.codigo_estudiante"
                    + " AND ec.codigo_curso = c.codigo_curso"
                    + " AND e.codigo_estudiante =" + p.getCodigo_estudiante()); 

            while (rs.next())
            {           
                if(Integer.parseInt(rs.getString(1)) < 22)
                {
                    respuesta2 = true;
                }
                else
                {
                    respuesta2 = false;
                } 
            }
            
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando validarEstudiante3 fin..." + respuesta2);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta2;
    }
    
    public boolean crearContrato(Estudiante p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta3 = false;
        try {            
            //Hola
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando crearContrato...");
            
            pstmt = con.prepareStatement("INSERT INTO contrato "
                    + " (codigo_estudiante, codigo_estudiante, salario, fecha_inicio, fecha_fin) "
                    + " VALUES (?,?,?,?,?)");
            
            pstmt.setString(1, p.getCodigo_estudiante());            
            pstmt.setString(2, "1000000");
            pstmt.setString(3, "2020");
            pstmt.setString(4, "2021");

            pstmt.execute();
            
            con.close();
            
            respuesta3 = true;
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando crearContrato fin...");
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta3;

    }
}
