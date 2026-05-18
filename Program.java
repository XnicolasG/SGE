import java.util.Scanner;

public class Program {

    /*
     * Iniciación de un array limitado a 5 datos con tipo Estudiantes y variable
     * estatica contador para ser
     * usado en cualqueri metodo dentro del objeto.
     */
    static Estudiante[] estudiantes = new Estudiante[5];
    static int contador = 0;

    /*
     * Por Medio de un do while se ofrece al usuario un menú de posibles opciones,
     * algunas de ellas disponibles
     * desde un principio, otras una vez ya existe un registro ya que de otra manera
     * no tiene sentido ofrecerlas
     * si no van a tener con que interactuar. Así mismo se implementa un try/catch
     * para evitar que se Ingresen
     * letras o simbolos diferentes a los numeros de las opciones del menú.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        do {
            try {
                System.out.println("Selecciona que deseas hacer.");
                System.out.println("1. Registrar estudiante.");
                if (contador != 0) {
                    System.out.println("2. Mostrar listado de estudiantes.");
                    System.out.println("3. Filtrar estudiantes por ID");
                }
                System.out.println("0. Salir.");

                option = sc.nextInt();
                sc.nextLine();

            } catch (Exception e) {
                System.out.println("Debes ingresar un número válido.");
                sc.nextLine();
                option = -1;
                continue;
            }

            if (option == 1)
                Program.RegistrarEstudiante();
            if (contador != 0) {
                if (option == 2)
                    Program.MostrarEstudiantes();
                else if (option == 3) {
                    Program.FiltrarEstudiantes();
                }
            }
            if (option == 0)
                System.out.println("Hasta luego.");

        } while (option != 0);
        sc.close();

    }
    /*
     * El metodo FiltrarEstudiantes se encarga de pedir el ID a buscar, si coincide
     * con los registros este lo imprime
     * iterando por medio de un ciclo for, de no ser encontrado el programa se
     * encarga de hacerlo saber al usuario
     */

    public static void FiltrarEstudiantes() {
        Scanner sc = new Scanner(System.in);
        boolean IdEncontrado = false;
        
        System.out.println("Ingresa le ID del estudiante:");
        String id = sc.nextLine();

        for (int i = 0; i < contador; i++) {
            Estudiante estudianteActual = estudiantes[i];

            if (estudianteActual.ID.equals(id)) {
                System.out.println(estudianteActual);
                IdEncontrado = true;
                break;
            }
        }
        if (!IdEncontrado) {
            System.out.println("No se ha encontrado algun estudiante con ese ID");
        }
    }

    /*
     * El metodo MostrarEstudiantes se encarga de mostrar cuantos estudiantes se
     * encuentran registrados y cuales por medio
     * de una iteración usando el metodo foreach
     */
    public static void MostrarEstudiantes() {
        System.out.println("Hay " + contador + "/5 estudiantes registrados:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

    }

    /*
     * Metodo RegistrarEstudiante se encarga de resgistrar estudiantes, pidiendo el
     * nombre y programa al que pertenece,
     * el ID se generar automaticamente basando en el valor del contador.
     * ademas muestra el registro una vez queda hecho y valida si ya se registro el
     * limite de datos disponibles el array estudiante
     */
    public static void RegistrarEstudiante() {

        Scanner sc = new Scanner(System.in);

        if (contador < 5) {

            System.out.println("Ingrese nombre de estudiante");
            String nombre = sc.nextLine();

            System.out.println("Ingrese programa del estudiante");
            String carrera = sc.nextLine();

            String id = "S" + (contador + 1);

            estudiantes[contador] = new Estudiante(id, nombre, carrera);

            System.out.println(estudiantes[contador]);
            contador++;
        } else {
            System.out.println("Ya existen 5 estudiantes registrados, no es posible agregar más.");
        }
    }

}

/*
 * Creación de Objeto Estudiante para estructura de datos a guardar como
 * estudiantes,
 * Se sobreescribio el metodo toString para mostrar de manera personalizada la
 * información
 */
class Estudiante {
    String ID;
    String Nombre;
    String Carrera;

    Estudiante(String id, String nombre, String carrera) {
        this.ID = id;
        this.Nombre = nombre;
        this.Carrera = carrera;
    }

    @Override
    public String toString() {
        return ID + " - " + Nombre + " - " + Carrera;
    }
}