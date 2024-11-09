import java.util.ArrayList;
import java.util.Scanner;

// Clase principal que contiene el menú y las operaciones CRUD

public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu(); // Muestra el menú de opciones
            opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    agregarJugador(); // Llama al método para agregar un jugador
                    break;
                case 2:
                    eliminarJugador(); // Llama al método para eliminar un jugador
                    break;
                case 3:
                    buscarJugador(); // Llama al método para buscar un jugador
                    break;
                case 4:
                    editarJugador();  // Llama al método para editar un jugador
                    break;
                case 5:
                    listarJugadores(); // Llama al método para listar todos los jugadores
                    break;
                case 6:
                    System.out.println("Saliendo del programa..."); // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo."); // Mensaje de opción no válida
            }
        } while (opcion != 6); // Repite el menú hasta que el usuario elija salir
    }

// Método para mostrar el menú de opciones

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar jugador");
        System.out.println("2. Eliminar jugador");
        System.out.println("3. Buscar jugador");
        System.out.println("4. Editar jugador");
        System.out.println("5. Listar jugadores");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

// Método para agregar un jugador

    private static void agregarJugador() {
        System.out.print("Ingrese el nombre del jugador: "); 
        String nombre = scanner.nextLine(); // Lee el nombre del jugador
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt(); // Lee la edad del jugador
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la posición del jugador: ");
        String posicion = scanner.nextLine(); // Lee la posición del jugador

// Crea un nuevo objeto Jugador y lo agrega a la lista

        Jugador jugador = new Jugador(nombre, edad, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado exitosamente.");
        listarJugadores(); // Muestra la lista actualizada de jugadores
    }

// Método para eliminar un jugador

    private static void eliminarJugador() {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt(); // Lee el ID del jugador a eliminar
        Jugador jugador = buscarJugadorPorID(id); // Busca el jugador por ID
        if (jugador != null) {
            jugadores.remove(jugador); // Elimina el jugador de la lista
            System.out.println("Jugador eliminado exitosamente.");
        } else {
            System.out.println("Jugador no encontrado."); // Mensaje si el jugador no se encuentra
        }
        listarJugadores(); // Muestra la lista actualizada de jugadores
    }

// Método para buscar un jugador

    private static void buscarJugador() {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt(); // Lee el ID del jugador a buscar
        Jugador jugador = buscarJugadorPorID(id); // Busca el jugador por ID
        if (jugador != null) {
            System.out.println(jugador); // Muestra los datos del jugador encontrado
        } else {
            System.out.println("Jugador no encontrado."); // Mensaje si el jugador no se encuentra
        }
    }

    // Método para editar un jugador

    private static void editarJugador() {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt(); // Lee el ID del jugador a editar
        scanner.nextLine(); // Limpiar el buffer
        Jugador jugador = buscarJugadorPorID(id); // Busca el jugador por ID
        if (jugador != null) {
            // Lee los nuevos datos del jugador
            System.out.print("Ingrese el nuevo nombre del jugador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del jugador: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese la nueva posición del jugador: ");
            String posicion = scanner.nextLine();
            // Actualiza los datos del jugador
            jugador.setNombre(nombre);
            jugador.setEdad(edad);
            jugador.setPosicion(posicion);
            System.out.println("Jugador editado exitosamente.");
            listarJugadores(); // Muestra la lista actualizada de jugadores
        } else {
            System.out.println("Jugador no encontrado."); // Mensaje si el jugador no se encuentra
        }
    }

// Método para listar todos los jugadores
    private static void listarJugadores() {
        System.out.println("\n--- Lista de Jugadores ---");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador); // Muestra los datos de cada jugador en la lista
        }
    }

// Método auxiliar para buscar un jugador por ID

    private static Jugador buscarJugadorPorID(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador; // Retorna el jugador si se encuentra
            }
        }
        return null; // Retorna null si el jugador no se encuentra
    }
}