package es;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static es.MetodosClientes.*;
import static es.MetodosConcesionario.*;
import static es.CreadorClienteXML.*;
import static es.MetodosCoche.*;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

/**
 *
 * @author ricar
 */
public class Proyecto_AC_app {

    private static final Properties myProperties = new Properties();

    public static void main(String[] args) throws IOException, AWTException, InterruptedException, FileNotFoundException, ClassNotFoundException {
        //Logger logger = LogManager.getRootLogger();
        Utilidades U = new Utilidades();
        MetodosConcesionario mc = new MetodosConcesionario();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String leer;
        int opc;
        //logger.trace("Entrada a la clase principal");
        //logger.error("Prueba de un error");
        //String rutaCarpetaCliente = ".\\clientes";
        String marca, modelo;
        boolean salir = false, salirClientes = false, salirConcesionario = false, salirCoches = false;
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
                                agregarClienteAClientesXML(cliente);

                                break;

                            //borrar cliente
                            case 2:
                                String nif;
                                nif = U.PedirNIF();

                                MetodosClientes.eliminarCliente(nif);
                                break;

                            //Modificar cliente
                            case 3:
                                String nif2;
                                nif2 = U.PedirNIF();
                                Cliente c = MetodosClientes.buscarCliente(nif2);
                                MetodosClientes.modificarCliente(c);
                                break;

                            //mostrar datos del cliente
                            case 4:
                                clienteDesdeFile();
                                break;

                            case 5:
                                //Leemos el xml de todos los clientes creados
                                System.out.println("Todos los clientes creados:");
                                System.out.println("");
                                leerClientesDesdeXML();
                                break;

                            //salir del menú de clientes
                            case 6:
                                salirClientes = true;
                                break;

                            default:
                                throw new AssertionError();
                        }
                    } while (!salirClientes);
                    salirClientes = false;
                    break;
                case 2:
                    do {
                        U.MenúConcesionario();
                        leer = br.readLine();
                        opc = Integer.parseInt(leer);
                        switch (opc) {

                            //crear concesionario
                            case 1:
                                crearCarpetaYArchivoConcesionarios();
                                Concesionario concesionario = CrearConcesionario();
                                concesionarioADat(concesionario);

                                break;

                            //borrar concesionario
                            case 2:
                                int idconce;
                                do {
                                    System.out.println("ID del concesionario que desea modificar-->");
                                    idconce = Integer.parseInt(br.readLine());
                                } while (mc.BuscarConcesionario(idconce) == null);

                                mc.BajaConcesionario(idconce);
                                break;

                            //Modificar concesionario
                            case 3:
                                do {
                                    System.out.println("ID del concesionario que desea modificar-->");
                                    idconce = Integer.parseInt(br.readLine());
                                } while (mc.BuscarConcesionario(idconce) == null);

                                Concesionario concesionario2 = mc.BuscarConcesionario(idconce);

                                mc.BajaConcesionario(idconce);

                                mc.ModificarConcesionario(concesionario2);

                                try {
                                    File f = new File(".\\concesionarios\\concesionarios.dat");

                                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                                    oos.writeObject(concesionario2);

                                    oos.flush();
                                    oos.close();
                                } catch (FileNotFoundException ex) {
                                    System.out.println(ex.getLocalizedMessage());
                                } catch (IOException ex) {
                                    System.out.println(ex.getLocalizedMessage());
                                }

                                break;

                            //salir concesionario
                                 case 4:
                                salirConcesionario = true;
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } while (!salirConcesionario);
                    salirConcesionario = false;
                    break;
                case 3:
                    do {
                        U.MenuConches();
                        leer = br.readLine();
                        opc = Integer.parseInt(leer);
                        switch (opc) {

                            //crear coche
                            case 1:
                                marca = U.PedirMarcaCoche();
                                modelo = U.PedirModeloCoche();

                                Coches coche = new Coches(marca, modelo);

                                crearCoche(coche);
                                break;

                            //leer coche
                            case 2:
                                int idcoche;
                                System.out.println("ID del coche que quieres ver los datos-->");
                                idcoche = Integer.parseInt(br.readLine());

                                leerCoche(idcoche);
                                break;

                            //salir coches
                            case 3:
                                salirCoches = true;
                                break;
                            default:
                                throw new AssertionError();
                        }
                    } while (!salirCoches);
                    salirCoches = false;
                    break;
                case 4:
                    salir = true;
                    conversorXMLToHTML("clientes.xml");
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
