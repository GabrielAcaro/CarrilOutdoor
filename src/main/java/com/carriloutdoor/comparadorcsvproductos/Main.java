package main.java.com.carriloutdoor.comparadorcsvproductos;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.BuscadorProductosService;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.CsvService;
import main.java.com.carriloutdoor.comparadorcsvproductos.service.InformeResultadoService;

/**
 * Main
 * @author Gabriel Acaro Sánchez
 */
public class Main {
    
    //Variables constantes del programa
    
    public static final String[] COLUMNASERP = {
        "1. Nombre del producto",
        "2. Codigo",
        "3. Codigo de barras / Ean",
        "4. Codigo de referencia",
        "5. Medida / Talla / Calibre",
        "6. Nombre Proveedor",
        "7. Observaciones"
    };

    public static final String[] COLUMNASPRESTASHOP = {
        "1. Nombre del producto",
        "2. ID",
        "3. ID Combinacion",
        "4. Codigo de barras / Ean",
        "5. Codigo de referencia",
        "6. Medida / Talla / Calibre",
        "7. Atributos"
    };
    
    
    // Variables static del programa (rutas de archivos)
    
        private static String rutaCsvArtErp = "C:\\Users\\gabri\\WorkSpace_Netbeans\\ProgramasArmeria\\ComparadorCSVProductos\\data\\entrada\\listadoArticulosERP.csv";
        private static String rutaCsvSubArtErp = "C:\\Users\\gabri\\WorkSpace_Netbeans\\ProgramasArmeria\\ComparadorCSVProductos\\data\\entrada\\listadoSubarticulosERP.csv";
        private static String rutaCsvArtPrestaShop = "C:\\Users\\gabri\\WorkSpace_Netbeans\\ProgramasArmeria\\ComparadorCSVProductos\\data\\entrada\\listadoPrestashop.csv";
        
    //Comienzo del metodo que muestra el menu del programa
    public static void menu() {
        System.out.println("\nIntroduzca una de estas opciones para usar el programa:\n");
            System.out.println("Mostrar la informacion completa del CSV seleccionado: 1)");
            System.out.println("Mostrar toda la informacion del intervalo entre dos valores de fila del CSV seleccionado: 2)");
            System.out.println("Mostrar toda la informacion del intervalo entre dos valores de columna del CSV seleccionado: 3)");
            System.out.println("Mostrar la informacion del intervalo entre dos valores de fila y dos de columna del CSV seleccionado: 4)");
            System.out.println("Buscar producto por nombre, ID combinacion, Codigo de Barras, etc: 5)");
            System.out.println("Salir del programa: 0)");
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
        // pedirRutasCSV();
        CsvService.leerLineasCsv(rutaCsvArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvSubArtErp, listaProductosERP, listaProductosPrestaShop);
        CsvService.leerLineasCsv(rutaCsvArtPrestaShop, listaProductosERP, listaProductosPrestaShop);
        System.out.println(""); // Salto de linea
        
        do {
            menu(); // Llamamos al menu del programa
            userOption = Integer.parseInt(scanner()); // Pedimos al usuario que opcion del programa usar
            
            switch (userOption) {
                case 1 -> {
                    InformeResultadoService.pedirListaUserInfoCompleta(listaProductosERP, listaProductosPrestaShop);
                }
                
                case 2 -> {
                    InformeResultadoService.pedirListaUserInfoIntervaloFilas(listaProductosERP, listaProductosPrestaShop);
                }
                
                case 3 -> {
                    InformeResultadoService.pedirListaUserInfoIntervaloColumnas(listaProductosERP, listaProductosPrestaShop);
                }

                case 4 -> {
                    InformeResultadoService.pedirListaUserInfoIntervaloFilasColumnas(listaProductosERP, listaProductosPrestaShop);
                }

                case 5 -> {
                    BuscadorProductosService.solicitarListaUser(listaProductosERP, listaProductosPrestaShop);
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
