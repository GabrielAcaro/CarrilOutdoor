package main.java.com.carriloutdoor.comparadorcsvproductos;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.CsvService;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.InformeResultadoService;

/**
 * Main
 * @author Gabriel Acaro Sánchez
 */
public class Main {
    // Variables static del programa (rutas de archivos)
        private static String rutaCsvArtErp = "";
        private static String rutaCsvSubArtErp = "";
        private static String rutaCsvArtPrestaShop = "";
        
    //Comienzo del metodo que muestra el menu del programa
    public static void menu() {
        System.out.println("\nIntroduzca una de estas opciones para usar el programa:\n");
            System.out.println("Mostrar la informacion completa del CSV seleccionado: 1)");
            System.out.println("Mostrar la informacion del intervalo entre dos valores de fila introducidos del CSV seleccionado: 2)");
            System.out.println("Mostrar la informacion del intervalo entre dos valores de columna introducidos del CSV seleccionado: 3)");
            System.out.println("Buscar producto por nombre, ID combinacion, Codigo de Barras, etc: 4)");
    }
    
    // Metodo de scanner global
    public static String scanner() {
        Scanner entry = new Scanner(System.in);
        
        return entry.nextLine();
    }
    
    // Metodo para pedir la ruta de los CSV al user
    public static void pedirRutasCSV() {
        System.out.println("Introduzca la ruta del CSV de Articulos del ERP:");
        rutaCsvArtErp = scanner();
        
        System.out.println("Introduzca la ruta del CSV de SubArticulos del ERP:");
        rutaCsvSubArtErp = scanner();
        
        System.out.println("Introduzca la ruta del CSV de Articulos PrestaShop:");
        rutaCsvArtPrestaShop = scanner();
    }
    
    // Comienzo de la logica princial del programa
    public static void main(String[] args) {
        
        // Declaracion de variables/objetos
        ArrayList<ProductoERP> listaProductosERP = new ArrayList<>();
        ArrayList<ProductoPrestaShop> listaProductosPrestaShop = new ArrayList<>();
        int userOption = 0;
        
        // Saludo
        System.out.println("Bienvenido al comparador de CSV de CarrilOutdoor!\n");
        
        // Pedimos la ruta de los CSV y los cargamos a un ArrayList
        pedirRutasCSV();
        CsvService.leerLineasCsv(rutaCsvArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvSubArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvArtPrestaShop, listaProductosERP, listaProductosPrestaShop);
        System.out.println(""); // Salto de linea
        
        do {
            menu(); // Llamamos al menu del programa
            userOption = Integer.parseInt(scanner()); // Pedimos al usuario que opcion del programa usar
            
            switch (userOption) {
                case 1 -> {
                    InformeResultadoService.mostrarInfoCompletaProductosERP(listaProductosERP, listaProductosPrestaShop);
                }
                
                case 0 -> {
                    System.out .println("Saliendo del programa...");
                    System.out.println("Saliste del programa correctamente.\n");
                }
                
                default -> {
                    System.out.println("");
                }
            }
        }while (userOption != 0);
    }
}
