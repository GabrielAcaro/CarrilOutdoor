package main.java.com.carriloutdoor.comparadorcsvproductos;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.CsvService;

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
        System.out.println("Introduzca una de estas opciones para usar el programa:");
            System.out.println("");
            System.out.println("");
            System.out.println("");
    }
    
    public static String scanner() {
        Scanner entry = new Scanner(System.in);
        
        return entry.nextLine();
    }
    
    public static void pedirRutasCSV() {
        System.out.println("Introduzca la ruta del CSV de Articulos del ERP:");
        rutaCsvArtErp = scanner();
        
        System.out.println("Introduzca la ruta del CSV de SubArticulos del ERP:");
        rutaCsvSubArtErp = scanner();
        
        System.out.println("Introduzca la ruta del CSV de Articulos PrestaShop:");
        rutaCsvArtPrestaShop = scanner();
    }
    
    public static void main(String[] args) {
        ArrayList<ProductoERP> listaProductosERP = new ArrayList<>();
        ArrayList<ProductoPrestaShop> listaProductosPrestaShop = new ArrayList<>();
        int userOption = 0;
        
        System.out.println("Bienvenido al comparador de CSV de CarrilOutdoor!\n");
        
        pedirRutasCSV();
        
        CsvService.leerLineasCsv(rutaCsvArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvSubArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvArtPrestaShop, listaProductosERP, listaProductosPrestaShop);
        
        do {
            menu();
            userOption = Integer.parseInt(scanner());
            
            switch (userOption) {
                case 1 -> {
                    
                }
                
                case 0 -> {
                    System.out.println("Saliendo del programa...");
                    System.out.println("Saliste del programa correctamente.\n");
                }
                
                default -> {
                    System.out.println("Introduzca un numero entre el          ");
                }
            }
            
        }while (userOption != 0);
    }
}
