

package es;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ricar
 */
public class Proyecto_AC_app {

    public static void main(String[] args) {
        Logger logger = LogManager.getRootLogger();
  
        logger.trace("Entrada a la clase principal");
        logger.error("Prueba de un error");
        
        String rutaCarpetaCliente =".\\Clientes";
        File Clientes = new File(rutaCarpetaCliente);

        
         //Verifica si la carpeta ya existe
        if (!Clientes.exists()) {
             //Intenta crear la carpeta
             Clientes.mkdirs(); 
        }
        
        
    }
}
