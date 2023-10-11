package es;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static es.MetodosClientes.*;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author ricar
 */
public class Proyecto_AC_app {
private static final Properties myProperties = new Properties();
    public static void main(String[] args) throws IOException {
        //Logger logger = LogManager.getRootLogger();

        //logger.trace("Entrada a la clase principal");
        //logger.error("Prueba de un error");
        //String rutaCarpetaCliente = ".\\clientes";
        try {

            Proyecto_AC_app.myProperties.load(new FileInputStream("properties.properties"));
        } catch (IOException e) {
            System.out.println("No se pueden cargar la inicialización del programa. Saliendo...");
            System.exit(100);
        }
        String archivo_clientes = Proyecto_AC_app.myProperties.getProperty("archivo_clientes");

        File Clientes = new File(myProperties.getProperty(archivo_clientes));
        //File Clientes = new File(rutaCarpetaCliente);

        //Verifica si la carpeta ya existe
        if (!Clientes.exists()) {
            //Intenta crear la carpeta
            Clientes.mkdirs();
        }
        Cliente cliente=crearCliente();
        
        clienteAFile(cliente);
        
        clienteDesdeFile();
    }
}
