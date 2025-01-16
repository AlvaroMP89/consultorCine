package com.mycompany.consultacinexml;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConsultaCineXml 
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, org.xml.sax.SAXException 
    {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el parámetro de búsqueda
        System.out.println("Ingrese el título de la película, nombre del director o actor que quiera buscar:");
        
        // Convertir la entrada a minúsculas para comparación
        String consulta = scanner.nextLine().toLowerCase(); 

        // Referencia al fichero XML 
        File file1 = new File("src\\main\\java\\xml\\xmlData1.xml");

        // DocumentBuilderFactory y DocumentBuilder para generar un documento XML en memoria
        DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = dbf1.newDocumentBuilder();

         // Se vuelca el contenido del fichero xml al objeto document1 (parse)
        // Importar: import org.w3c.dom.Document; NO LA DE SWING
        Document document1 = db1.parse(file1);

        // Normalizar el contenido XML
        document1.getDocumentElement().normalize();

        // Extraer el nombre del nodo raíz
        System.out.println("Elemento raíz: " + document1.getDocumentElement().getNodeName());

        // Extraer todos los nodos "pelicula"
        NodeList nodeList1 = document1.getElementsByTagName("pelicula");

        boolean encontrado = false;

        // Recorrer la lista de nodos para buscar coincidencias
        for (int i = 0; i < nodeList1.getLength(); i++) {
               
           // Se extrae el nodo actual 
            Node node1 = nodeList1.item(i);

            // Verificar si el nodo es un elemento
            if (node1.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) node1;

                // Extraer la información de la película (título, director, actor, etc.)
                String titulo = element1.getElementsByTagName("titulo").item(0).getTextContent().toLowerCase();
                String director = element1.getElementsByTagName("director").item(0).getTextContent().toLowerCase();
                String actor = element1.getElementsByTagName("actor").item(0).getTextContent().toLowerCase();

                // Verificar si hay una coincidencia en cualquiera de los campos (título, director, actor)
                if (titulo.contains(consulta) || director.contains(consulta) || actor.contains(consulta)) {
                    encontrado = true;
                    System.out.println("\nPelícula encontrada:");
                    System.out.println("Título: " + titulo);
                    System.out.println("Director: " + director);
                    System.out.println("Actor: " + actor);
                    System.out.println("---------------------------------");
                }
            }
        }

        // Si no se encontraron resultados
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias para: " + consulta);
        }

        scanner.close();
    }
}

    
    

