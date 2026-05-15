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
    /*
├── 
├── separarColumnas(String linea)
├── limpiarValor(String valor)
├── convertirEnteroSeguro(String valor)
└── detectarSeparador(String linea)
    */
    public static String limpiarRutaCsv(String rutaCsv) {
        // Cambiamos los slash a un formato que java entienda (\\)
        
        rutaCsv = rutaCsv.replace("\\\\", "/");
        rutaCsv = rutaCsv.replace("\\", "/");
        rutaCsv = rutaCsv.replace("/", "\\\\");
        
        return rutaCsv; // Retornamos la ruta que java entiende
    }
    
    public static void convertirFilaAProductoERP(String[] columnas, ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = new ProductoERP();
        
        if (columnas.length >= 7) {
            p.setCodigo(columnas[0].replace("\"", ""));
            p.setNombre(columnas[1].replace("\"", ""));
            p.setNombreProveedor(columnas[2].replace("\"", ""));
            p.setObservaciones(columnas[3].replace("\"", ""));
            p.setTalla(columnas[4].replace("\"", ""));
            p.setEan(columnas[5].replace("\"", ""));
            p.setCodReferencia(columnas[6].replace("\"", ""));
            
            listaProductosERP.add(p); // Añadimos el objeto a la lista
        } else {
            System.out.println("El csv no tiene las columnas necesarias");
        }
    }
    
    public static void convertirFilaAProductoPrestaShop(String[] columnas, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        ProductoPrestaShop p = new ProductoPrestaShop();
        
        if (columnas.length >= 6) {
            p.setId(Integer.parseInt(columnas[0]));
            p.setIdCombinacion(Integer.parseInt(columnas[1]));
            p.setNombre(columnas[2].replace("\"", ""));
            p.setCodReferencia(columnas[3].replace("\"", ""));
            p.setEan(columnas[4].replace("\"", ""));
            p.setAtributos(columnas[5].replace("\"", ""));
            
            listaProductosPrestaShop.add(p); // Añadimos el objeto a la lista
        } else {
            System.out.println("El csv no tiene las columnas necesarias");
        }
    }
    
    public static String detectarTipoCsv(String cabecera) {
        if (cabecera.equalsIgnoreCase("CODIGO;NOMBRE;NOMBRE PROVEEDOR;OBSERVACIONES;MEDIDA;CODIGO DE BARRAS;COD REFERENCIA")) {
            return "ERP";
        }

        if (cabecera.equalsIgnoreCase("ID Producto;ID Combinacion;Nombre del Producto;Referencia;EAN;Atributos (Ej: XL, Roja)")) {
            return "PRESTASHOP";
        }

        return "DESCONOCIDO";
        }
    
    public static void leerLineasCsv(String rutaArchivo, ArrayList<ProductoERP> listaProductosERP,
            ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        String linea = "", cabecera = "", tipoCsv = "";
        
        try (
                FileReader fr = new FileReader(limpiarRutaCsv(rutaArchivo));
                BufferedReader br = new BufferedReader(fr);
                ){
            cabecera = br.readLine();
            tipoCsv = detectarTipoCsv(cabecera);
            
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(";", -1);
                
                if (tipoCsv.equals("ERP")) {
                    convertirFilaAProductoERP(columnas, listaProductosERP);
                    
                }else if (tipoCsv.equals("PRESTASHOP")) {
                    convertirFilaAProductoPrestaShop(columnas, listaProductosPrestaShop);
                    
                }
            }
            
            if (tipoCsv.equals("DESCONOCIDO")) {
                System.err.println("El formato del csv es DESCONOCIDO!");
            } else {
                System.out.println("Informacion del csv del ERP cargada correctamente!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero con la ruta dada!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S!");
            System.err.println(e.getMessage());
        }catch(NumberFormatException e) {
            System.err.println("El fichero CSV introducido es el incorrecto!");
            System.err.println(e.getMessage());
        }
    }
}