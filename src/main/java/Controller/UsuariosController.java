package Controller;

import Clases.Usuarios;
import Conexion.conexion;
import java.util.List;

public class UsuariosController {
    
    private conexion coneccion;
    
    public UsuariosController() {
        this.coneccion = new conexion();
    }
    
    public boolean verificarCredenciales(String usuario, String contraseña){
        return coneccion.verificarCredenciales(usuario, contraseña);
    }
    
    public int agregarUsuario(String nombre, String apellido, String dni, String usuario, String contraseña){
        return coneccion.agregarUsuario(nombre, apellido, dni, usuario, contraseña);
    }
    
    public List<Usuarios> obtenerUsuarios(){
        return coneccion.obtenerUsuarios();
    }
    
    public Usuarios obtenerLosCamposUsuariosModificar(String dni){
        return coneccion.obtenerLosCamposUsuariosModificar(dni);
    }
    
     public boolean actualizarUsuario(String nombre, String apellido, String usuario, String contraseña, String dni) {
        return coneccion.actualizarUsuario(nombre, apellido, usuario, contraseña, dni);
    }
     
     public boolean eliminarUsuarioPorDNI(String dni){
         return coneccion.eliminarUsuarioPorDNI(dni);
     } 
     
}
