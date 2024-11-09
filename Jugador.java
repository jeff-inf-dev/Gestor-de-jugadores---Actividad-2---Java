// Clase Jugador que representa a un jugador

public class Jugador {
    private static int contadorID = 1; // Contador estático para generar IDs únicos
    private int id;
    private String nombre;
    private int edad;
    private String posicion;

// Constructor de la clase Jugador
    public Jugador(String nombre, int edad, String posicion) {
        this.id = contadorID++;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

 // Getters y Setters para los atributos de Jugador
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

// Método toString para representar al jugador como una cadena de texto

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Posición: " + posicion;
    }
}