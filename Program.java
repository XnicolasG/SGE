import java.util.Scanner;

public class Program {

    static Estudiante[] estudiantes = new Estudiante[5];
    static int contador = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        do {
            System.out.println("Selecciona que deseas hacer.");
            System.out.println("1. Registrar estudiante.");
            if (contador != 0){
                System.out.println("2. Mostrar listado de estudiantes.");
                System.out.println("3. Filtrar estudiantes por ID");
            } 
            System.out.println("0. Salir.");

            option = sc.nextInt();
            sc.nextLine();

            if (option == 1)
                Program.RegistrarEstudiante();
            else if (option == 2)
                Program.MostrarEstudiantes();
            else if (option == 3){
                Program.FiltrarEstudiantes(null);
            }
        } while (option != 0);
        sc.close();
        
    }

    public static void FiltrarEstudiantes(String id) {
        

    }

    public static void MostrarEstudiantes() {
        if (contador != 0) {
            System.out.println("Hay " + contador + "/5 estudiantes registrados:");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }else{
                System.out.println("Aun no hay estudiantes registrados.");
        }
    }

    public static void RegistrarEstudiante() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre de estudiante");
        String nombre = sc.nextLine();

        System.out.println("Ingrese programa del estudiante");
        String carrera = sc.nextLine();

        String id = "S" + (contador + 1);

        estudiantes[contador] = new Estudiante(id, nombre, carrera);

        System.out.println(estudiantes[contador]);
        contador++;
        // sc.close();
    }

}

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