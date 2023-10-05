package es;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jaime
 */
public class Utilidades {
    
    public void MenuClientesInicio() throws InterruptedException, AWTException{
        
        
        
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                         MENÚ CLIENTE                         **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        Thread.sleep(2000);
        cls();
        
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("******* 1.Crear Cliente     ******");
        System.out.println("******* 2.Borrar Cliente    ******");
        System.out.println("******* 3.Modificar Cliente ******");
        System.out.println("******* 4.Mostrar Cliente   ******");
        System.out.println("******* 3.Salir             ******");
        System.out.println("**********************************");
        System.out.println("**********************************");
    }
    public void MenuClienteCrear () throws InterruptedException, AWTException{
        
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                      HAZTE NUEVO CLIENTE                     **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        Thread.sleep(2000);
        cls();   
    }
   public String PedirNombre() throws IOException{
        String nombre;
        do {
            
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("NOMBRE DE USUARIO--> ");
        nombre=br.readLine();
        } while (nombre!=null && nombre.trim().isEmpty());
        return nombre;
        
    }
    
    public String PedirCiudad() throws IOException {
        String ciudad;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("CIUDAD --> ");
            ciudad = br.readLine();
        } while (ciudad != null && ciudad.trim().isEmpty());
        return ciudad;

    }

    /*
    *Falta la comprobacion de que sea 9 si o si 
    */
    public String PedirNIF() throws IOException {
        String NIF,NC;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("NIF --> ");
            NIF = br.readLine();
            NC=NIF;
            NC=NC.trim();
        } while (NIF != null && NIF.trim().isEmpty() && NC.length()!=9);
        return NIF;

    }
    /*
    *Falta las condiciones de que sean si o si en 9 
    */
    public String PedirTLF() throws IOException {
        String tlf,tlfC;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("NIF --> ");
            tlf = br.readLine();
            tlfC=tlf;
            tlfC=tlfC.trim();
        } while (tlf != null && tlf.trim().isEmpty() && tlfC.length()!=9);
        return tlf;

    }
    
    
    /*
    *Ver despues bien que le pasa al cls que no borra la pantalla 
    */
    public static void cls() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_L);
        Thread.sleep(1000);
    }
    
}
