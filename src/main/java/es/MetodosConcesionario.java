
package es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Julián
 */
public class MetodosConcesionario {
    Utilidades U;
    public Concesionario CrearConcesionario() throws IOException{

        Concesionario concesionario=new Concesionario();
        concesionario.setNombreConcesionario(U.PedirNombreConcesionario());
        concesionario.setLocalidadConcesionario(U.PedirLocalidadConcesionario());
        return concesionario;
             
    }
    
    
    public Concesionario ModificarConcesionario(Concesionario concesionario) throws IOException{
        boolean salir=false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        String leer;
        do {
            System.out.println("Que desea modificar??");
            System.out.println("1.Nombre del concesionario");
            System.out.println("2.Localidad del concesionario");
            System.out.println("3.salir");
            leer=br.readLine();
            opc=Integer.parseInt(leer);
            switch (opc) {
                case 1:
                     concesionario.setNombreConcesionario(U.PedirNombreConcesionario());
                    break;
                case 2:
                    concesionario.setLocalidadConcesionario(U.PedirLocalidadConcesionario());
                    break;
                case 3:
                    salir=true;
                 
                default:
                    System.out.println("No elegiste la opcion correcta");
            }
            
        } while (salir);
       
        
        
        return concesionario;
        
    }
}
