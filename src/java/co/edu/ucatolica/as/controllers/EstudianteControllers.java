/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.controllers;

/**
 *
 * @author NixonD
 */

import co.edu.ucatolica.as.DAOs.FactoryDao;
import co.edu.ucatolica.as.DAOs.EstudianteMySQLDAO;
import co.edu.ucatolica.as.DTOs.Estudiante;
import co.edu.ucatolica.as.bds.MySqlDataSource;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
 
@Controller
@RequestMapping("/")
public class EstudianteControllers implements Controller {
    
@RequestMapping(method = RequestMethod.GET, value = "personaCrear.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        System.out.println("personaCrear");
        model.put("mensajePersona", "Pase por el controller de Estudiante:::"+req.getParameter("nombre"));
        return "persona_crear";
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "personaRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        //PersonaMySQLDAO pDao = new PersonaMySQLDAO();
        FactoryDao MySqlFactory = FactoryDao.getFactory(FactoryDao.MYSQL_FACTORY);
            
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String codigo = req.getParameter("codigo_estudiante");
        String nombre = req.getParameter("nombre_estudiante");
        String apellido = req.getParameter("apellido_estudiante");
        String fecha = req.getParameter("fecha_nacimiento");
        String cedula = req.getParameter("cedula");
        String password = req.getParameter("password");
        String semestre = req.getParameter("semestre");
        String email = req.getParameter("email");
        String cod_mat = req.getParameter("codigo_matricula");
        String cod_con = req.getParameter("codigo_contrato");
        String cod_pro = req.getParameter("codigo_programa");
        
        Estudiante p = new Estudiante();
        //p.setId(id);
        p.setCodigo_estudiante(codigo);
        p.setNombre_estudiante(nombre);
        p.setApellido_estudiante(apellido);
        p.setFecha_nacimiento(fecha);
        p.setCedula(cedula);
        p.setPassword(password);
        p.setSemestre(semestre);
        p.setEmail(email);
        p.setCodigo_matricula(cod_mat);
        p.setCodigo_contrato(cod_con);   
        p.setCodigo_programa(cod_pro);
            
        //boolean insert = pDao.crearPersona(p, MySqlDataSource.getConexionBD());
        System.out.print("Objeto"+p);
        boolean insert = MySqlFactory.getEstudianteDao().crearEstudiante(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + codigo + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        
        return "persona_crear";
    }     
    
@RequestMapping(method = RequestMethod.GET, value = "personaConsultar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "persona_consultar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "personaConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO pDao = new EstudianteMySQLDAO();
            
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String codigo = req.getParameter("codigo_estudiante");
        //String nombre1 = req.getParameter("nombre1");
        
        Estudiante p = new Estudiante();
        //p.setId(id);
        p.setCodigo_estudiante(codigo);
        //p.setNombre1(nombre1);
            
        List<Estudiante> datos = pDao.consultarEstudiante(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + codigo + "-" + datos.size());
        
        model.put("listaEstudiantes", datos);
        System.out.print("T datos:"+datos.size());
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size());
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "persona_consultar";
    }     
   
@RequestMapping(method = RequestMethod.GET, value = "personaEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "persona_editar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "personaEditarForm1.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO pDao = new EstudianteMySQLDAO();
            
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String codigo = req.getParameter("codigo_estudiante");
        String nombre = req.getParameter("nombre_estudiante");
        
        Estudiante p = new Estudiante();
        //p.setId(id);
        p.setCodigo_estudiante(codigo);
        p.setNombre_estudiante(nombre);
            
        List<Estudiante> datos = pDao.consultarEstudiante(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + codigo + "-" + datos.size());
        
        model.put("listaEstudiantes", datos);
        
        
        return "persona_editar";
        
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "personaEditarForm2.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO pDao = new EstudianteMySQLDAO();
            
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");

        //int id = Integer.parseInt(req.getParameter("id"));
        String codigo = req.getParameter("codigo_estudiante");
        String nombre = req.getParameter("nombre_estudiante");
        String apellido = req.getParameter("apellido_estudiante");
        String fecha = req.getParameter("fecha_nacimiento");
        String cedula = req.getParameter("cedula");
        String password = req.getParameter("password");
        String semestre = req.getParameter("semestre");
        String email = req.getParameter("email");
        String cod_mat = req.getParameter("codigo_matricula");
        String cod_con = req.getParameter("codigo_contrato");
        String cod_pro = req.getParameter("codigo_programa");
        
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Id estudiante: " + codigo);
        
        Estudiante p = new Estudiante();
        //p.setId(id);
        p.setCodigo_estudiante(codigo);
        p.setNombre_estudiante(nombre);
        p.setApellido_estudiante(apellido);
        p.setFecha_nacimiento(fecha);
        p.setCedula(cedula);
        p.setPassword(password);
        p.setSemestre(semestre);
        p.setEmail(email);
        p.setCodigo_matricula(cod_mat);
        p.setCodigo_contrato(cod_con);   
        p.setCodigo_programa(cod_pro);
            
        boolean res = pDao.editarEstudiante(p, MySqlDataSource.getConexionBD());                         
        
        if (res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "NO se guardaron los cambios...");
        
        return "persona_editar";
        
    }  

@RequestMapping(method = RequestMethod.GET, value = "personaEliminar.htm")
    public String processSubmit7(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit7...");
        return "persona_eliminar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "personaEliminarForm.htm")
    public String processSubmit8(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO pDao = new EstudianteMySQLDAO();
            
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit8...");

        //int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String codigo = req.getParameter("codigo_estudiante");
        //String nombre1 = req.getParameter("nombre1");
        
        Estudiante p = new Estudiante();
        //p.setId(id);
        p.setCodigo_estudiante(codigo);
        //p.setNombre1(nombre1);
            
        //List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());

        //Logger.getLogger(PersonaControllers.class.getName()).log(Level.SEVERE, null, "Eliminar + " + ident);
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Id estudiante: " + codigo);
        
        //model.put("listaPersonas", datos);
        
        boolean res = pDao.eliminarEstudiante(p, MySqlDataSource.getConexionBD());  
        
        if (res)
            model.put("mensaje", "¡Eliminado satisfactoriamente!");
        else
            model.put("mensaje", "No se pudo eliminar");
        
        return "persona_eliminar";
    } 
    
    @RequestMapping(method = RequestMethod.GET, value = "monitoriaValidar.htm")
    public String processSubmit9(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit9...");
        return "monitoria";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "monitoriaValidarForm.htm")
    public String processSubmit10(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        EstudianteMySQLDAO pDao = new EstudianteMySQLDAO();
            
        Logger.getLogger(EstudianteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit10...");
        
        String codigo = req.getParameter("codigo_estudiante");
        String pass = req.getParameter("password");
        String cod_cur = req.getParameter("codigo_curso");
        
        Estudiante p = new Estudiante();
        
        p.setCodigo_estudiante(codigo);
        p.setPassword(pass);
        p.setEst_curso(cod_cur);
        //---Validacion_1
        List<Estudiante> datos = pDao.validarEstudiante(p, MySqlDataSource.getConexionBD());
        //---Validacion_2
        List<Estudiante> datos2 = pDao.validarEstudiante2(p, MySqlDataSource.getConexionBD());
        //--Validacion_3
        boolean res = pDao.validarEstudiante3(p, MySqlDataSource.getConexionBD());
        //--Validacion_4
        boolean res2 = pDao.validarEstudiante4(p, MySqlDataSource.getConexionBD());
        
        Logger.getLogger(EstudianteControllers.class.getName()).log(Level.SEVERE, null, "Validar + " + codigo + "-" + datos.size());
        
        model.put("listaEstudiantes", datos);
        System.out.print("T datos:"+datos.size());
        if (datos.size() > 0 && datos2.size() == 0 && res == true && res2 == true)
        {
            model.put("mensaje", "¡El estudiante es valido!");
            /*boolean res3 = pDao.crearContrato(p, MySqlDataSource.getConexionBD());
            if( res3 == true)
            {
                model.put("mensaje", "¡El contrato se creo exitosamente!");
            }
            else
            {
                model.put("mensaje", "El contrato NO se creo.");
            }*/
        }    
        else
        { 
            model.put("mensaje", "El estudiante NO es valido, intente el proximo semestre.");
        }
        return "monitoria";
    } 

    @Override
    public String value() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

