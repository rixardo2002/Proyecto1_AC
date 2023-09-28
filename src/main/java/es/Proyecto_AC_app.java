

package es;

import java.io.File;

/**
 *
 * @author ricar
 */
public class Proyecto_AC_app {

    public static void main(String[] args) {
        
        String rutaCarpetaCliente =".\\Clientes";
        File Clientes = new File(rutaCarpetaCliente);

        // Verifica si la carpeta ya existe
        if (!Clientes.exists()) {
            // Intenta crear la carpeta
             Clientes.mkdirs(); 
        }
        
        
    }
}
