package Controller;
import Clases.Curso;
import Conexion.conexion;
import java.sql.Connection;
import java.util.List;
public class CursoController {
    private conexion estudianteDAO;

    // Constructor que inicializa el DAO
    public CursoController() {
        this.estudianteDAO = new conexion();
    }



    
    public int agregarCursoObtenerIDCurso(String duracion, String estado){
        return estudianteDAO.agregarCursoObtenerIDCurso(duracion, estado);
    }
    
    public List<Curso> obtenerCurso(){
        return estudianteDAO.obtenerCurso();
    }
    
    
    public boolean eliminarCurso(int id){
        return estudianteDAO.eliminarCurso(id);
    }
  
}
