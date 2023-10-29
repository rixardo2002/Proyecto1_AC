package es;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author jaime
 */
public class Utilidades {

    /**
     *
     * @author jaime
     */
    public void MenuClientesInicio() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        cls();
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                         MENÚ CLIENTE                         **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        Thread.sleep(1000);
        cls();

        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("******* 1.Crear Cliente     ******");
        System.out.println("******* 2.Borrar Cliente    ******");
        System.out.println("******* 3.Modificar Cliente ******");
        System.out.println("******* 4.Mostrar Cliente   ******");
        System.out.println("******* 5.Mostrar Clientes  ******");
        System.out.println("******* 6.Salir             ******");
        System.out.println("**********************************");
        System.out.println("**********************************");
    }

    /**
     *
     * @author jaime
     */
    public void MenuClienteCrear() throws InterruptedException, AWTException {

        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                      HAZTE NUEVO CLIENTE                     **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        Thread.sleep(2000);
        cls();
    }

    /**
     *
     * @author jaime
     */
    public String PedirNombre() throws IOException {
        String nombre;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("NOMBRE DE USUARIO--> ");
            nombre = br.readLine();
        } while (nombre != null && nombre.trim().isEmpty());
        return nombre;

    }

    /**
     *
     * @author jaime
     */
    public String PedirCiudad() throws IOException {
        String ciudad;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("CIUDAD --> ");
            ciudad = br.readLine();
        } while (ciudad != null && ciudad.trim().isEmpty());
        return ciudad;

    }

    /**
     *
     * @author jaime
     */
    public String PedirNIF() throws IOException {
        String NIF, NC;
        do {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("NIF --> ");
            NIF = br.readLine();
            NC = NIF.trim();

        } while (NIF == null || NC.length() != 9 || NC.isEmpty());
        return NIF;

    }

    /**
     *
     * @author jaime
     */
    public String PedirTLF() throws IOException {
        String tlf, tlfC;
        do {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("TLF --> ");
            tlf = br.readLine();
            tlf = tlf.trim();
        } while (tlf == null || tlf.isEmpty() || tlf.length() != 9);
        return tlf;
    }

    /**
     *
     * @author jaime y ricardo g
     * @param br
     * @return
     * @throws java.io.IOException
     */
    //Falta cambiar si en vez de la edad vamos a pedir la fecha de nacimiento
    public LocalDate obtenerFechaNacimientoValida(BufferedReader br) throws IOException {
        while (true) {
            System.out.println("Introduce la fecha de nacimiento en el formato 'YYYY-MM-DD': ");
            String fechaNacimientoStr = br.readLine();

            try {
                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
                return fechaNacimiento;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Debe ser 'YYYY-MM-DD'. Intenta de nuevo.");
            }
        }
    }

    /**
     *
     * @author jaime
     */
    public void MenúConcesionario() {

        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                      MENÚ CONCESIONARIO                      **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("");
        System.out.println("****************************************");
        System.out.println("****************************************");
        System.out.println("******* 1.Crear Concesionario     ******");
        System.out.println("******* 2.Borrar Concesionario    ******");
        System.out.println("******* 3.Modificar Concesionario ******");
        System.out.println("******* 4.Salir                   ******");
        System.out.println("****************************************");
        System.out.println("****************************************");

    }

    /**
     *
     * @author jaime
     */
    public static String PedirNombreConcesionario() throws IOException {

        //char nombre[16];
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre-->");
        name = br.readLine();

        return name;

    }

    /**
     *
     * @author jaime
     */
    public static String PedirLocalidadConcesionario() throws IOException {
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Localidad-->");
        name = br.readLine();

        return name;
    }

    /**
     *
     * @author jaime
     */
    public  void MenúDeInicio() throws AWTException, InterruptedException {
        System.out.println("************************************************************************");
        System.out.println("************************************************************************");
        System.out.println("**                      BIENVENIDO A NUESTRA APP                      **");
        System.out.println("************************************************************************");
        System.out.println("************************************************************************");
        System.out.println("");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("**       SELECCIONE LA OPCIÓN QUE DESEE       **");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.println("******* 1.Ir al menú de clientes          ******");
        System.out.println("******* 2.Ir al menú de concesionarios    ******");
        System.out.println("******* 3.Ir al menú de coches            ******");
        System.out.println("******* 4.Salir                           ******");
        System.out.println("************************************************");
        System.out.println("************************************************");
        System.out.print("---->>");

    }

    /**
     * @author Julián
     */
    public void MenuConches() {

        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("**                        MENÚ COCHES                           **");
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        System.out.println("");
        System.out.println("****************************************");
        System.out.println("****************************************");
        System.out.println("******* 1.Crear Choche            ******");
        System.out.println("******* 2.Buscar Coche            ******");
        System.out.println("******* 3.Salir                   ******");
        System.out.println("****************************************");
        System.out.println("****************************************");

    }

    /**
     * @author Julián
     */
    public String PedirMarcaCoche() throws IOException {
        String marca;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Marca-->");
        marca = br.readLine();

        return marca;
    }

    /**
     * @author Julián
     */
    public String PedirModeloCoche() throws IOException {
        String modelo;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Modelo-->");
        modelo = br.readLine();

        return modelo;
    }

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
