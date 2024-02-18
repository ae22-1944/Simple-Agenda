import java.util.Scanner;

public class SimpleAgenda {
    public static void agregarContacto() {
        Scanner sc = new Scanner(System.in);

        String contacto;

        System.out.println("Ingrese el contacto a agregar");

        contacto = sc.nextLine();

        if (contacto.length() > 4 && contacto.length() < 8) {
            System.out.println("Contacto agregado con éxito");
        } else if (contacto.length() >= 8 && contacto.length() <= 30) {
            System.out.println("Agregado, contiene entre 8-30 caracteres");
        } else {
            System.out.println("Nombre muy largo");
        }
    }

    public static void removerContacto(int id) {
        if (id >= 1000 && id <= 9999) {
            System.out.println("Verificando contacto a eliminar...");
        } else {
            System.out.println("ID inválido");
        }
    }

    public static String actualizarContacto(int posicion) {
        return "N/A";
    }

    public static void mostrarContactos() {
        System.out.println("Mostrando contactos...");
    }

    public static void main(String[] args) {
        agregarContacto();
        removerContacto(5478);
        mostrarContactos();
    }
}
