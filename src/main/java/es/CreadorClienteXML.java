package es;

import java.io.File;
import java.time.LocalDate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



/**
 *
 * @author Ricardo Gómez Ramos & Ricardo Gómez 
 */
public class CreadorClienteXML {
    
// Declaración de constantes para los elementos XML
    private static final String CLIENTES = "Clientes";
    private static final String CLIENTE = "Cliente";
    private static final String NOMBRE = "Nombre";
    private static final String NUMEROTLF = "NumeroTlf";
    private static final String CIUDAD = "Ciudad";
    private static final String FECHA_NAC = "Fecha_nac";
    private static final String NIF = "NIF";

   
    
    /**Método para generar el XML a partir de los clientes
     * @author Ricardo Gómez Ramos
     * @param cliente
     */
    public static void agregarClienteAClientesXML(Cliente cliente) {
    try {
        File archivoXML = new File("clientes.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc;

        if (archivoXML.exists()) {
            // Si el archivo XML ya existe, cargarlo
            doc = docBuilder.parse(archivoXML);
        } else {
            // Si el archivo XML no existe, crear un nuevo documento
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement(CLIENTES);
            doc.appendChild(rootElement);
            doc.appendChild(doc.createTextNode("\n"));
        }

        // Crear el elemento para representar el nuevo cliente
        Element clienteElement = doc.createElement(CLIENTE);
        clienteElement.appendChild(doc.createTextNode("\n")); // Línea vacía

        // Crear elementos para los atributos del cliente
        Element nombreElement = doc.createElement(NOMBRE);
        nombreElement.appendChild(doc.createTextNode(cliente.getNombre()));
        clienteElement.appendChild(nombreElement);
        clienteElement.appendChild(doc.createTextNode("\n")); // Línea vacía

        Element numeroTlfElement = doc.createElement(NUMEROTLF);
        numeroTlfElement.appendChild(doc.createTextNode(cliente.getNumeroTlf()));
        clienteElement.appendChild(numeroTlfElement);
        clienteElement.appendChild(doc.createTextNode("\n")); // Línea vacía

        Element ciudadElement = doc.createElement(CIUDAD);
        ciudadElement.appendChild(doc.createTextNode(cliente.getCiudad()));
        clienteElement.appendChild(ciudadElement);
        clienteElement.appendChild(doc.createTextNode("\n")); // Línea vacía

        Element edadElement = doc.createElement(FECHA_NAC);
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        String fechaN = fechaNacimiento.toString();
        edadElement.appendChild(doc.createTextNode(fechaN));
        clienteElement.appendChild(edadElement);
        clienteElement.appendChild(doc.createTextNode("\n")); // Línea vacía

        Element nifElement = doc.createElement(NIF);
        nifElement.appendChild(doc.createTextNode(cliente.getNif()));

        // Agregar los elementos al elemento cliente
        clienteElement.appendChild(nifElement);

        // Agregar el elemento cliente al documento
        doc.getDocumentElement().appendChild(clienteElement);
        doc.getDocumentElement().appendChild(doc.createTextNode("\n")); // Línea vacía

        // Serializar el documento XML actualizado
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        // Especifica la ubicación del archivo de salida
        StreamResult result = new StreamResult(archivoXML);
        transformer.transform(source, result);

        System.out.println("Cliente agregado al archivo XML exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * @author Ricardo Gómez Ramos
     */
    public static void leerClientesDesdeXML() {
    try {
        File archivoXML = new File("clientes.xml");  // Ruta al archivo XML que contiene varios clientes

        if (!archivoXML.exists()) {
            System.out.println("El archivo XML no existe.");
            return;
        }

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(archivoXML);

        // Obtener el elemento raíz
        Element rootElement = doc.getDocumentElement();

        // Obtener una lista de elementos "Cliente"
        NodeList clienteNodes = rootElement.getElementsByTagName(CLIENTE);

        System.out.println("Clientes leídos del archivo XML:");

        for (int i = 0; i < clienteNodes.getLength(); i++) {
            Element clienteElement = (Element) clienteNodes.item(i);

            // Leer los elementos dentro del cliente
            String nombre = clienteElement.getElementsByTagName(NOMBRE).item(0).getTextContent();
            String numeroTlf = clienteElement.getElementsByTagName(NUMEROTLF).item(0).getTextContent();
            String ciudad = clienteElement.getElementsByTagName(CIUDAD).item(0).getTextContent();
            String fechaNacimientoStr = clienteElement.getElementsByTagName(FECHA_NAC).item(0).getTextContent();
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            String nif = clienteElement.getElementsByTagName(NIF).item(0).getTextContent();

            // Crear un nuevo objeto Cliente
            Cliente cliente = new Cliente(nombre, numeroTlf, ciudad, fechaNacimiento, nif);

            // Imprimir los datos del cliente
            System.out.println(cliente);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    /**
     * @author Ricardo Gómez Ramos & Ricardo Gómez Bastante
     * @param xmlFichero 
     */
    public static void conversorXMLToHTML(String xmlFichero) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File(xmlFichero);

            if (!xmlFile.exists()) {
                System.out.println("El archivo XML no existe.");
                return;
            }

            // Crear un documento XML a partir del archivo
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);

            // Crear el elemento raíz
            Element rootElement = doc.createElement("html");
            doc.appendChild(rootElement);

            // Crear un elemento "body"
            Element bodyElement = doc.createElement("body");
            rootElement.appendChild(bodyElement);

            // Crear elementos HTML a partir de datos en el XML
            Element h1Element = doc.createElement("h1");
            Text h1Text = doc.createTextNode("Título del HTML");
            h1Element.appendChild(h1Text);
            bodyElement.appendChild(h1Element);

            Element pElement = doc.createElement("p");
            Text pText = doc.createTextNode("Este es un párrafo en el HTML.");
            pElement.appendChild(pText);
            bodyElement.appendChild(pElement);

            // Especifica la ubicación del archivo HTML de salida
            File htmlFile = new File("clientes.html");

            // Prepara la transformación para convertir el documento DOM a un archivo HTML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(htmlFile);

            // Realiza la transformación
            transformer.transform(source, result);

            System.out.println("Documento HTML generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}