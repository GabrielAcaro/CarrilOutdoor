package main.java.com.carriloutdoor.comparadorcsvproductos.service;

import java.util.ArrayList;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;

/**
 * InformeResultadoService
 * @author Gabriel Acaro Sánchez
 */
public class InformeResultadoService {
    public static void mostrarInfoCompletaProductosERP(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        System.out.println("\nInformacion detallada y completa de los productos del ERP: \n");
        
        for (ProductoERP p : listaProductosERP) {
            System.out.println("Nombre del producto: " + p.getNombre() + "\n");
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Codigo de barras / Ean: " + p.getEan());
            System.out.println("Codigo de referencia: " + p.getCodReferencia() + "\n");
            System.out.println("Medida / Talla / Calibre: " + p.getTalla());
            System.out.println("Proveedor: " + p.getNombreProveedor());
            System.out.println("Observaciones: " + p.getObservaciones() + "\n");
            System.out.println("/////////////////////////\n");
        }
    }
}
