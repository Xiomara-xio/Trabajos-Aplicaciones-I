
package Clases;
public class Curso {
    private int id; // ID del curso
    private int duracionSemanas; // Duración del curso en semanas
    private String estado; // Estado del curso

    // Constructor que incluye el ID
    public Curso(int id, int duracionSemanas, String estado) {
        this.id = id;
        this.duracionSemanas = duracionSemanas;
        this.estado = estado;
    }

    // Constructor por defecto
    public Curso() {
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracionSemanas() {
        return duracionSemanas;
    }

    public void setDuracionSemanas(int duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}