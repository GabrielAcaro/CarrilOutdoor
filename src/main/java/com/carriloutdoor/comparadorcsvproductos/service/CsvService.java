package main.java.com.carriloutdoor.comparadorcsvproductos.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;

/**
 * CsvService
 * @author Gabriel Acaro Sánchez
 */
public class CsvService {
    
    // Metodo que corrige y limpia la ruta que el usuario introduzca
    
    public static String limpiarRutaCsv(String rutaCsv) {
        // Cambiamos los slash a un formato que java entienda (\\)
        
        rutaCsv = rutaCsv.replace("\\\\", "/");
        rutaCsv = rutaCsv.replace("\\", "/");
        rutaCsv = rutaCsv.replace("/", "\\\\");
        
        return rutaCsv;
    }
    
    // Metodo que separa las columnas del csv y las almacena en un ArrayList
    
    public static ArrayList<String> separarColumnasCsv(String linea) {
        
        // Declaracion de varialbes/objetos
        
        ArrayList<String> columnas = new ArrayList<>();
        String columnaActual = "";
        boolean dentroComillas = false;
        
        // Logica que divide el csv y lo almacena
        for (int i = 0; i < linea.length(); i++) { // Recorremos la linea que leemos
            char caracter = linea.charAt(i); // Almacenamos cada letra de la linea segun la iteracion
            
            if (caracter == '"') { // Si la letra que almacenamos contiene texto entre comillas dobles, el booleano es true
                dentroComillas = !dentroComillas;
            } else if (caracter == ',' && !dentroComillas) { // Si encuentra una "," y no esta entre comillas dobles, dividimos esa parte de la linea como una nueva columna
                columnas.add(columnaActual);
                columnaActual = "";
            } else { // Almacenamos las letras concatenadas en la variable
                columnaActual += caracter;
            }
        }
        
        columnas.add(columnaActual); // Añadimos la linea dividida al ArrayList
        return columnas;
    }

    // Metodo que almacena la informacion separada en el ArrayList de productos ERP
    public static void convertirFilaAProductoERP(String[] columnas, ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = new ProductoERP(); // Objeto aux
        
        // Almacenamos las columnas de la linea en el objeto
        p.setCodigo(columnas[0]);
        p.setNombre(columnas[1]);
        p.setNombreProveedor(columnas[2]);
        p.setObservaciones(columnas[3]);
        p.setTalla(columnas[4]);
        p.setEan(columnas[5]);
        p.setCodReferencia(columnas[6]);
            
        listaProductosERP.add(p); // Añadimos el objeto a la lista
    }
    
    // Metodo que almacena la informacion separada en el ArrayList de productos ERP 
    public static void convertirFilaAProductoPrestaShop(String[] columnas, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        ProductoPrestaShop p = new ProductoPrestaShop(); // Objeto aux
        
        // Almacenamos las columnas de la linea en el objeto
        p.setId(Integer.parseInt(columnas[0]));
        p.setIdCombinacion(Integer.parseInt(columnas[1]));
        p.setNombre(columnas[2]);
        p.setCodReferencia(columnas[3]);
        p.setEan(columnas[4]);
        p.setAtributos(columnas[5]);
            
        listaProductosPrestaShop.add(p); // Añadimos el objeto a la lista
    }
    
    public static String detectarTipoCsv(String cabecera) {
        if (cabecera.contains("CODIGO")) {
            return "ERP";
        }

        if (cabecera.contains("ID")) {
            return "PRESTASHOP";
        }

        return "DESCONOCIDO";
        }
    
    public static void leerLineasCsv(String rutaArchivo, ArrayList<ProductoERP> listaProductosERP,
        ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        String[] columnas = new String[0];
        
        String linea = "", cabecera = "", tipoCsv = "", rutaLimpia = "";
        int filasProcesadas = 0, filasVacias = 0;
        boolean csvValido = false;
        
        try (
            FileReader fr = new FileReader(limpiarRutaCsv(rutaArchivo));
            BufferedReader br = new BufferedReader(fr);
            ){
        
        rutaLimpia = limpiarRutaCsv(rutaArchivo);
        cabecera = br.readLine();
        
        if (cabecera == null) {
            System.err.println("El CSV esta vacio: " + rutaArchivo);
        } else {
            tipoCsv = detectarTipoCsv(cabecera);
            csvValido = !"DESCONOCIDO".equals(tipoCsv);
            
            if (!csvValido) {
                System.err.println("El formato del csv es DESCONOCIDO!");
            } else {
                while ((linea = br.readLine()) != null) {
                    
                    if (linea.trim().isEmpty()) {
                        filasVacias++;
                    } else {
                        columnas = separarColumnasCsv(linea).toArray(new String[0]);
                        
                        if ("ERP".equals(tipoCsv)) {
                            convertirFilaAProductoERP(columnas, listaProductosERP);
                            filasProcesadas++;
                        } else if ("PRESTASHOP".equals(tipoCsv)) {
                            convertirFilaAProductoPrestaShop(columnas, listaProductosPrestaShop);
                            filasProcesadas++;
                        }
                    }
                }
                
                System.out.println("CSV " + tipoCsv + " cargado correctamente.\n");
                System.out.println("Filas procesadas: " + filasProcesadas);
                System.out.println("Filas vacias ignoradas: " + filasVacias + "\n");
            }
        }
        
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero con la ruta dada!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S!");
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("El fichero CSV contiene un numero con formato incorrecto!");
            System.err.println(e.getMessage());
        }
    }
    
    // METODOS DE PRUEBAS
    
    /*
    public static void diagnosticarCsv(String rutaArchivo, int maxLineas) {
        try (
                FileReader fr = new FileReader(limpiarRutaCsv(rutaArchivo));
                BufferedReader br = new BufferedReader(fr);
        ) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null && numeroLinea < maxLineas) {
                numeroLinea++;

                String separador = detectarSeparador(linea);
                ArrayList<String> columnas = separarColumnasCsv(linea);

                System.out.println("====================================");
                System.out.println("Linea: " + numeroLinea);
                System.out.println("Separador detectado: " + nombreSeparador(separador));
                System.out.println("Numero de columnas: " + columnas.size());

                for (int i = 0; i < columnas.size(); i++) {
                    System.out.println("[" + i + "] = " + columnas.get(i));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero con la ruta dada!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S!");
            System.err.println(e.getMessage());
        }
    }

    private static String detectarSeparador(String linea) {
        if (linea.contains("\t")) {
            return "\t";
        }

        if (linea.contains("|")) {
            return "\\|";
        }

        if (linea.contains(";")) {
            return ";";
        }

        if (linea.contains(",")) {
            return ",";
        }

        return ";";
    }

    private static String nombreSeparador(String separador) {
        if (separador.equals("\t")) {
            return "TAB";
        }

        if (separador.equals("\\|")) {
            return "|";
        }

        if (separador.equals(";")) {
            return ";";
        }

        if (separador.equals(",")) {
            return ",";
        }

        return "DESCONOCIDO";
    }
    */
}