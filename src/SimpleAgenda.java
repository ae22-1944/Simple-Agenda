import java.util.Scanner;

public class SimpleAgenda {
    private static String[] contactos = new String[10];

    public static void agregarContacto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el contacto a agregar");
        String nuevo_contacto = sc.nextLine();

        int counter = -1;
        for (String c : contactos) {
            counter++;
            if (c != null && c.equals(nuevo_contacto)) {
                System.out.println("Ya se ha agregado anteriormente");
                return; // Exit the method if contact already exists
            }
        }
        contactos[counter] = nuevo_contacto;
        System.out.println("Agregado satisfactoriamente");
    }

    public static void removerContacto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el contacto a remover");
        String contacto_eliminar = sc.nextLine();

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(contacto_eliminar)) {
                contactos[i] = null;
                System.out.println("El contacto " + contacto_eliminar + " fue removido exitosamente!");
                return; // Exit the method after removing the contact
            }
        }
        System.out.println("No existe tal contacto");
    }

    public static void mostrarContacto() {
        System.out.println("Mostrando contactos...");
        for (String c : contactos) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }

    public static void main(String[] args) {
        agregarContacto();
        removerContacto();
        mostrarContacto();
    }
}
