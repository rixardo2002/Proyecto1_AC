package es;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static es.MetodosClientes.*;
import static es.CreadorClienteXML.*;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author ricar
 */
public class Proyecto_AC_app {

    private static final Properties myProperties = new Properties();

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        //Logger logger = LogManager.getRootLogger();
        Utilidades U = new Utilidades();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String leer;
        int opc;
        //logger.trace("Entrada a la clase principal");
        //logger.error("Prueba de un error");
        //String rutaCarpetaCliente = ".\\clientes";
        boolean salir = false, salirClientes = false;
        do {
            U.MenúDeInicio();
            leer = br.readLine();
            opc = Integer.parseInt(leer);
            switch (opc) {
                case 1:

                    //este switch es para que cuando seleccionas la opcion de clientes entras dentro del menú de clientes.
                    do {
                        U.MenuClientesInicio();
                        leer = br.readLine();
                        opc = Integer.parseInt(leer);
                        switch (opc) {

                            //crear cliente
                            case 1:
                                U.MenuClienteCrear();
                                Cliente cliente = crearCliente();
                                clienteAFile(cliente);
                                
                                // Generar y guardar el archivo XML del cliente
                                generarXMLCliente(cliente);
                                    
                                // Leer y mostrar los datos del cliente desde el archivo XML
                                leerXMLCliente(cliente);
            
                                break;

                            //borrar cliente
                            case 2:
                                String nif;
                                nif = U.PedirNIF();

                                MetodosClientes.eliminarCliente(nif);
                                break;

                            //Modificar cliente
                            case 3:

                                break;

                            //mostrar datos del cliente
                            case 4:
                                clienteDesdeFile();
                                break;

                            //salir del menú de clientes
                            case 5:
                                salir = true;
                                break;

                            default:
                                throw new AssertionError();
                        }
                    } while (!salirClientes);
                    break;
                case 2:

                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    throw new AssertionError();
            }

        } while (!salir);

        try {
            Proyecto_AC_app.myProperties.load(new FileInputStream("properties.properties"));
        } catch (IOException e) {
            System.out.println("No se pueden cargar la inicialización del programa. Saliendo...");

        }

        String archivo_clientes = Proyecto_AC_app.myProperties.getProperty("archivo_clientes");
        File Clientes = new File(archivo_clientes);
        //File Clientes = new File(rutaCarpetaCliente);

        //Verifica si la carpeta ya existe
        if (!Clientes.exists()) {
            //Intenta crear la carpeta
            Clientes.mkdirs();
        }

    }
}
