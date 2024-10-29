package Controller;
import Clases.Matricula;
import Conexion.conexion;
import java.util.List;

public class MatriculaController {
    
    
    private conexion estudianteDAO;
    
    public MatriculaController() {
        this.estudianteDAO = new conexion();
    }
    
      
 

 
public int agregarMatriculaObtenerIDMatricula(String modalidad, String correo){
    return estudianteDAO.agregarMatriculaObtenerIDMatricula(modalidad, correo);
}
 
 public List<Matricula> obtenerMatricula(){
     return estudianteDAO.obtenerMatricula();
 }
 
  public boolean eliminarMatricula(int id){
      return estudianteDAO.eliminarMatricula(id);
  }
 
 
}
