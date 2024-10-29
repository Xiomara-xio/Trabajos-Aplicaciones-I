package Conexion;

import Clases.Curso;
import Clases.Estudiante;
import Clases.Matricula;
import Clases.Usuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class conexion {
    private String url = "jdbc:sqlserver://brayanweb123.database.windows.net;databaseName=Colegio";
    private String usuario = "brayan123"; 
    private String contraseña = "Apomayta123";
    
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, contraseña);
    }
    
    //MI CODIGO
    public boolean verificarCredenciales(String usuario, String contraseña) {
    String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";

    try (Connection conexion = conectar(); 
         PreparedStatement pstmt = conexion.prepareStatement(sql)) {

        pstmt.setString(1, usuario);
        pstmt.setString(2, contraseña);

        ResultSet rs = pstmt.executeQuery();
        return rs.next(); // Devuelve true si hay un resultado
    } catch (SQLException e) {
        e.printStackTrace(); // Imprime la traza del error
    }
    return false; // Retorna false si hubo un error o no se encontraron resultados
}

    public int agregarUsuario(String nombre, String apellido, String dni, String usuario, String contraseña) {
        String sql = "INSERT INTO Usuarios (nombre, apellido, dni, usuario, contraseña) VALUES (?, ?, ?, ?, ?);";

        try (Connection conexion = conectar(); 
             PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, dni);
            pstmt.setString(4, usuario);
            pstmt.setString(5, contraseña);

            int filasAfectadas = pstmt.executeUpdate(); // Cuántas filas fueron afectadas, debe ser 1
            if (filasAfectadas > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Puedes mejorar este manejo de errores
        }

        return 0; 
    }

    public List<Usuarios> obtenerUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

        try (Connection conexion = conectar(); 
             PreparedStatement stmt = conexion.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDni(rs.getString("dni"));
                usuario.setUsuario(rs.getString("usuario"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public Usuarios obtenerLosCamposUsuariosModificar(String dni){
        Usuarios usuario = null;
        String sql = "Select nombre,apellido,usuario,contraseña FROM Usuarios WHERE dni = ?";
        
        try (Connection conexion = conectar(); 
         PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
        stmt.setString(1, dni);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuarios();
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setContraseña(rs.getString("contraseña"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public boolean actualizarUsuario(String nombre, String apellido, String usuario, String contraseña, String dni) {
        String sql = "UPDATE Usuarios " +
                     "SET nombre = ?, apellido = ?, usuario = ?, contraseña = ?" +
                     "WHERE DNI = ?"; 

        try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, usuario);
            stmt.setString(4, contraseña); 
            stmt.setString(5, dni); 

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public boolean eliminarUsuarioPorDNI(String dni) {
        String sql = "DELETE FROM Usuarios WHERE DNI = ?";

        try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, dni);

            int filasAfectadas = stmt.executeUpdate(); // Obtener el número de filas afectadas
            return filasAfectadas > 0; // Retorna true si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retorna false si ocurre un error o no se eliminó ningún registro
    }
    
    public int agregarCursoObtenerIDCurso(String duracion, String estado) {
        String sql = "INSERT INTO Curso (DuracionSemanas, Estado) VALUES (?, ?);";

        try (Connection conexion = conectar(); 
             PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, duracion);
            pstmt.setString(2, estado);


            int filasAfectadas = pstmt.executeUpdate(); // Cuántas filas fueron afectadas, debe ser 1
            if (filasAfectadas > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Puedes mejorar este manejo de errores
        }
        return 0; 
    }
    
    public int agregarMatriculaObtenerIDMatricula(String modalidad, String correo) {
        String sql = "INSERT INTO Matricula (Modalidad, correo) VALUES (?, ?);";
    try (Connection conexion = conectar(); 
         PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setString(1, modalidad); // Establece el valor de modalidad
        pstmt.setString(2, correo);    // Establece el valor de correo

        int filasAfectadas = pstmt.executeUpdate();
        if (filasAfectadas > 0) {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna el id_matricula generado
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Imprime el error en la consola
    }
    return 0; 
    }
    
    public boolean agregarEstudiante(int id_matricula, int id_curso, String nombre, String apellido, String dni) {
    String sql = "INSERT INTO Estudiantes (id_matricula, id_curso, Nombre, Apellido, DNI) " +
                 "VALUES (?, ?, ?, ?, ?)";
    try (Connection conexion = conectar(); 
         PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        
        pstmt.setInt(1, id_matricula); // Establecer id_matricula
        pstmt.setInt(2, id_curso);      // Establecer id_curso
        pstmt.setString(3, nombre);     // Establecer nombre
        pstmt.setString(4, apellido);    // Establecer apellido
        pstmt.setString(5, dni);         // Establecer DNI

        int filasAfectadas = pstmt.executeUpdate(); // Ejecuta la inserción y obtiene el número de filas afectadas
        return filasAfectadas > 0; // Devuelve true si se afectó al menos una fila
    } catch (SQLException e) {
        e.printStackTrace(); // Imprime la traza del error
    }
    return false; // Retorna false si hubo un error o no se insertó ninguna fila
}
    
    public List<Estudiante> obtenerEstudiante() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT id,Nombre,Apellido,DNI FROM Estudiantes";

        try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("Nombre"));
                estudiante.setApellido(rs.getString("Apellido"));
                estudiante.setDni(rs.getString("DNI"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<Curso> obtenerCurso() {
    List<Curso> cursos = new ArrayList<>();
    String sql = "SELECT id_curso, DuracionSemanas, Estado FROM Curso";

    try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Curso curso = new Curso();
            curso.setId(rs.getInt("id_curso")); // Asegúrate de obtener el ID
            curso.setDuracionSemanas(rs.getInt("DuracionSemanas"));
            curso.setEstado(rs.getString("Estado"));
            cursos.add(curso);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cursos;
}
    
    public List<Matricula> obtenerMatricula() {
        List<Matricula> matriculas = new ArrayList<>();
        String sql = "SELECT Modalidad,correo FROM Matricula";

        try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Matricula matricula = new Matricula();
                
                matricula.setModalidad(rs.getString("Modalidad"));
                matricula.setCorreo(rs.getString("correo"));
                matriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matriculas;
    }
    
    public Integer obtenerIdEstudiantePorDNI(String dni) {
    String sql = "SELECT id FROM Estudiantes WHERE DNI = ?";
    try (Connection conexion = conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
        stmt.setString(1, dni);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id"); // Devuelve el ID del estudiante
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Retorna null si no se encontró el estudiante
}
    
    public boolean eliminarEstudiante(String dni) {
    String sqlIdentificacion = "DELETE FROM Estudiantes WHERE DNI = ?";
    try (PreparedStatement stmtIdentificacion = conectar().prepareStatement(sqlIdentificacion)) {
        stmtIdentificacion.setString(1, dni);
        return stmtIdentificacion.executeUpdate() > 0;  
    } catch (SQLException e) {
        e.printStackTrace();
        return false;  // 
    }
}

    public boolean eliminarMatricula(int id) {
        String sqlCarrera = "DELETE Matricula WHERE id_matricula = ? ";
        try (PreparedStatement stmtCarrera = conectar().prepareStatement(sqlCarrera)) {
            stmtCarrera.setInt(1, id);
            return stmtCarrera.executeUpdate() > 0;  // Retorna verdadero si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna falso si ocurre un error
        }
    }

    public boolean eliminarCurso(int id) {
        String sqlAlumnos = "DELETE FROM Curso WHERE id_curso = ?";
        try (PreparedStatement stmtAlumnos = conectar().prepareStatement(sqlAlumnos)) {
            stmtAlumnos.setInt(1, id);
            return stmtAlumnos.executeUpdate() > 0;  // Retorna verdadero si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna falso si ocurre un error
        }
    }
    
    
    
    
    
    
  
    
}


