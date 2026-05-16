import java.util.Scanner;

public class Program {

    static Estudiante[] estudiantes = new Estudiante[5];
    static int contador = 0;

    public static void main(String[] args) {

        Program.RegistrarEstudiante();

    }

    public static void MostrarEstudiantes(){

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
        sc.close();
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