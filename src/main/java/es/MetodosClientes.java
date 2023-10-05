package es;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ricar
 */
public class MetodosClientes {
    
    public static Cliente crearCliente(){
        Cliente c = new Cliente("Patricia","672456732","Ciudad Real",20);
        return c; 
    }
    
    public static void clienteAFile() throws IOException {
        Cliente cli=MetodosClientes.crearCliente();
        File f = new File(".\\clientes\\"+cli.getNombre()+".txt");//declara fichero
        if (!f.exists()){
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f); //crear el flujo de salida
        fw.write(cli.toString());
        fw.flush();
        fw.close();
    }
    public static void clienteDesdeFile(){
        
    }
    
}
