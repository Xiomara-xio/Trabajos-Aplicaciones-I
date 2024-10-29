package Controller;
import Clases.Curso;
import Clases.Estudiante;
import Clases.Matricula;
import Conexion.conexion;
import java.util.List;

/**
 *
 * @author Elvis
 */
public class EstudianteController {
    private conexion estudianteDAO;

    public EstudianteController() {
        estudianteDAO = new conexion();
    }

    // Métodos para Estudiante
    public boolean agregarEstudiante(int id_matricula, int id_curso, String nombre, String apellido, String dni){
        return estudianteDAO.agregarEstudiante(id_matricula, id_curso, nombre, apellido, dni);
    }
    
    public List<Estudiante> obtenerEstudiante(){
        return estudianteDAO.obtenerEstudiante();
    }
    
   public boolean eliminarEstudiante(String dni){
       return estudianteDAO.eliminarEstudiante(dni);
   }
     
   public Integer obtenerIdEstudiantePorDNI(String dni){
       return estudianteDAO.obtenerIdEstudiantePorDNI(dni);
   }  
}