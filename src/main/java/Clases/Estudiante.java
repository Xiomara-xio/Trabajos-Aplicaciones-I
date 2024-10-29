    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Clases;

    import java.sql.Date;

    /**
     *
     * @author Elvis
     */
    public class Estudiante {
        private int id; // ID del estudiante
        private int idMatricula; // ID de la matrícula
        private int idCurso; // ID del curso
        private String nombre; // Nombre del estudiante
        private String apellido; // Apellido del estudiante
        private String dni; // DNI del estudiante

        // Constructor que incluye todos los campos
        public Estudiante(int id, int idMatricula, int idCurso, String nombre, String apellido, String dni) {
            this.id = id;
            this.idMatricula = idMatricula;
            this.idCurso = idCurso;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
        }

        // Constructor por defecto
        public Estudiante() {
        }

        // Métodos getters y setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIdMatricula() {
            return idMatricula;
        }

        public void setIdMatricula(int idMatricula) {
            this.idMatricula = idMatricula;
        }

        public int getIdCurso() {
            return idCurso;
        }

        public void setIdCurso(int idCurso) {
            this.idCurso = idCurso;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

    }
