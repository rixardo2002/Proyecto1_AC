package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class MetodosClientes {

    /**
     * 
     * @author Ricardo Gómez Bastante Ricardo Gómez Ramos
     */
    public static Cliente crearCliente() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cliente c = new Cliente("Patricia", "672456732", "Ciudad Real", 20);
        return c;
    }
/**
     * 
     * @author Ricardo Gómez Bastante 
     */
    public static void clienteAFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cliente cli = MetodosClientes.crearCliente();
        File f = new File(".\\clientes\\" + cli.getNombre() + ".txt");//declara fichero
        
    boolean salir=false;
            
        if (!f.exists()) {
            f.createNewFile();
        } else {
            do {
                System.out.print("Dime un nuevo nombre, el tuyo ya esta usado: ");
                String nombre;
                nombre = br.readLine();

                if (!nombre.equals(cli.getNombre())) {
                    cli.setNombre(nombre);
                    f = new File(".\\clientes\\" + cli.getNombre() + ".txt");
                    f.createNewFile();
                     salir=true;
                    
                }
            } while (!salir);

        }
        FileWriter fw = new FileWriter(f); //crear el flujo de salida
        fw.write(cli.toString());
        fw.flush();
        fw.close();
    }

//    public static void clienteDesdeFile() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Dime el nombre de Cliente que estas buscando");
//
//            File f = new File(".\\clientes\\" + cli.getNombre() + ".txt");//declara fichero
//            BufferedReader fbr = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8));
//
//            String linea;
//            while ((linea = fbr.readLine()) != null) {
//                System.out.println(linea);
//            }
//
//            fbr.close();
//        } catch (FileNotFoundException fn) {
//            System.out.println("No se encuentra el fichero en la ruta indicada");
//        } catch (IOException io) {
//            System.out.println("Error de E/S ");
//        }
//    }
}
