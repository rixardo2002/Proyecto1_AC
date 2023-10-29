package es;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *
 * @author ricar
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

    // Método para generar el XML a partir de un cliente
    public static void generarXMLCliente(Cliente cliente) {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement(CLIENTES);
            doc.appendChild(rootElement);

            // Crear el elemento para representar el cliente
            Element clienteElement = doc.createElement(CLIENTE);

            // Crear elementos para los atributos del cliente
            Element nombreElement = doc.createElement(NOMBRE);
            nombreElement.appendChild(doc.createTextNode(cliente.getNombre()));
            clienteElement.appendChild(doc.createTextNode("")); // Línea vacía para formato


            Element numeroTlfElement = doc.createElement(NUMEROTLF);
            numeroTlfElement.appendChild(doc.createTextNode(cliente.getNumeroTlf()));
            clienteElement.appendChild(doc.createTextNode("")); // Línea vacía para formato

            
            Element ciudadElement = doc.createElement(CIUDAD);
            ciudadElement.appendChild(doc.createTextNode(cliente.getCiudad()));
            clienteElement.appendChild(doc.createTextNode("")); // Línea vacía para formato

            

            Element edadElement = doc.createElement(FECHA_NAC);
            LocalDate fechaNacimiento = cliente.getFechaNacimiento();
            String fechaN = fechaNacimiento.toString();
            edadElement.appendChild(doc.createTextNode(fechaN));
            clienteElement.appendChild(doc.createTextNode("")); // Línea vacía para formato

            Element nifElement = doc.createElement(NIF);
            nifElement.appendChild(doc.createTextNode(cliente.getNif()));

            // Agregar los elementos al elemento cliente
            clienteElement.appendChild(nombreElement);
            clienteElement.appendChild(numeroTlfElement);
            clienteElement.appendChild(ciudadElement);
            clienteElement.appendChild(edadElement);
            clienteElement.appendChild(nifElement);

            // Agregar el elemento cliente al documento
            rootElement.appendChild(clienteElement);

            // Serializar el documento XML a un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            // Especifica la ubicación del archivo de salida (puedes modificar esta ruta)
            StreamResult result = new StreamResult(new java.io.File(cliente.getNif()+".xml"));
            transformer.transform(source, result);

            System.out.println("Documento XML generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void leerXMLCliente(Cliente c) {
    try {
        File file = new File(c.getNif()+".xml");  // Ruta al archivo XML generado

        // Configurar el analizador de documentos XML
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(file);

        // Obtener el elemento raíz del documento XML
        Element rootElement = doc.getDocumentElement();

        // Obtener una lista de elementos "Cliente" (puede haber solo uno en este caso)
        NodeList clienteNodes = rootElement.getElementsByTagName(CLIENTE);

        // Iterar a través de los nodos "Cliente" (generalmente solo habrá uno)
        for (int i = 0; i < clienteNodes.getLength(); i++) {
            Node clienteNode = clienteNodes.item(i);

            if (clienteNode.getNodeType() == Node.ELEMENT_NODE) {
                Element clienteElement = (Element) clienteNode;

                // Leer los elementos dentro del cliente del XML
                String nombre = clienteElement.getElementsByTagName(NOMBRE).item(0).getTextContent();
                String numeroTlf = clienteElement.getElementsByTagName(NUMEROTLF).item(0).getTextContent();
                String ciudad = clienteElement.getElementsByTagName(CIUDAD).item(0).getTextContent();
                String fechaNac =clienteElement.getElementsByTagName(FECHA_NAC).item(0).getTextContent();
                String nif = clienteElement.getElementsByTagName(NIF).item(0).getTextContent();

                // Crear un nuevo objeto Cliente con los datos leídos
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaNac, formatoFecha);
                Cliente cliente = new Cliente(nombre, numeroTlf, ciudad, fecha, nif);

                // Imprimir los datos del cliente
                System.out.println("Cliente leído del archivo XML:");
                System.out.println(cliente);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}