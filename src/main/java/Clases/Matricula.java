
package Clases;
public class Matricula {
    private int id; // ID de la matrícula
    private String modalidad; // Modalidad de la matrícula
    private String correo; // Correo asociado

    // Constructor que incluye el ID
    public Matricula(int id, String modalidad, String correo) {
        this.id = id;
        this.modalidad = modalidad;
        this.correo = correo;
    }

    // Constructor por defecto
    public Matricula() {
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Object getIdCurso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}