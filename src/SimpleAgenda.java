import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class SimpleAgenda {
    private static String[] contactos = new String[10];

    public static void generarArchivo() {
        File f = new File("contactos.txt");

        try {
            if (f.createNewFile()) {
                System.out.println("El archivo fue creado exitosamente");
            } else {
                System.out.println("Un archivo con este nombre ya existe en el directorio");
            }

            FileWriter escritor = new FileWriter(f);
            escritor.write("contacto,telefono\n" +
                    "Adan,8098551212\n" +
                    "Enmanuel,8294118787\n" +
                    "Raider,8097410032\n" +
                    "Roger,8095554141\n");
            escritor.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

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
        File archivo = new File("contactos.txt");
        Scanner leerConsola = new Scanner(System.in);
        Scanner leerArchivo = null;
        boolean contactoExiste = false;

        System.out.println("Ingrese contacto a buscar");
        String contactoBuscando = leerConsola.nextLine();

        try {
            leerArchivo = new Scanner(archivo);

            // Skip the first line
            if (leerArchivo.hasNextLine()) {
                leerArchivo.nextLine();
            }

            System.out.println("Mostrando contactos...");

            while (leerArchivo.hasNextLine()) {
                String linea = leerArchivo.nextLine();
                System.out.println(linea);

                String[] partes = linea.split(",");

                if (partes[0].equalsIgnoreCase(contactoBuscando)) {
                    contactoExiste = true;
                }
            }

            if (contactoExiste) {
                System.out.println("El contacto " + contactoBuscando + " existe");
            } else {
                System.out.println("No existen registros de este contacto");
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (leerArchivo != null) {
                leerConsola.close();
                leerArchivo.close();
            }
        }
    }

    public static void main(String[] args) {
        generarArchivo();
        mostrarContacto();
        agregarContacto();
        removerContacto();
    }
}
