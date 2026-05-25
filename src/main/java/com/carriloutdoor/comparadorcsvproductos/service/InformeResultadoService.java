package com.carriloutdoor.comparadorcsvproductos.service;

import java.util.ArrayList;
import com.carriloutdoor.comparadorcsvproductos.Main;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;

/**
 * InformeResultadoService
 * @author Gabriel Acaro Sánchez
 */
public class InformeResultadoService {
    
    // Pedir Seleccion Lista (ERP o PrestaShop) y Llamada a metodos
    
    // Pedir seleccion lista info completa (ERP o PrestaShop)
    public static void pedirListaUserInfoCompleta(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        int userOption = 0;
        
        System.out.println("Pulse un numero para elegir la lista de productos que quiere mostrar:\n");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");
        userOption = Integer.parseInt(Main.scanner());
        
        if (userOption == 1) {
            mostrarInfoCompletaProductosERP(listaProductosERP);
        } else if (userOption == 2) {
            mostrarInfoCompletaProductosPrestaShop(listaProductosPrestaShop);
        } else {
            System.err.println("Introduzca un numero entre el 1 y el 2!");
        }
    }
    
    // Pedir seleccion lista intervalo filas (ERP o PrestaShop)
    public static void pedirListaUserInfoIntervaloFilas(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop){
        int[] filas = new int[0];
        
        int userOption = 0;
        
        System.out.println("Pulse un numero para elegir la lista de productos que quiere mostrar:\n");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");
        userOption = Integer.parseInt(Main.scanner());
        
        switch (userOption) {
            case 1 -> {
                if (!listaProductosERP.isEmpty()) {
                    filas = pedirIntervaloFilasProductosERP(listaProductosERP);
                    if (filas[0] >= 0 && filas[1] >= filas[0]) {
                        mostrarInfoIntervaloFilasProductosERP(listaProductosERP, filas);
                    }else {
                        System.err.println("No se introdujo los intervalos de filas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }
            
            case 2 -> {
                if (!listaProductosPrestaShop.isEmpty()) {
                    filas = pedirIntervaloFilasProductosPrestaShop(listaProductosPrestaShop);
                    if (filas[0] >= 0 && filas[1] >= filas[0]) {
                        mostrarInfoIntervaloFilasProductosPrestaShop(listaProductosPrestaShop, filas);
                    }else {
                        System.err.println("No se introdujo los intervalos de filas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }
            
            default -> {
                System.err.println("Introduzca un numero entre el 1 y el 2!");
            }
        }
    }
    
    // Pedir seleccion lista intervalo columnas (ERP o PrestaShop)
    public static void pedirListaUserInfoIntervaloColumnas(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop){
        String[] colsERP = Main.COLUMNASERP;
        String[] colsPrestaShop = Main.COLUMNASPRESTASHOP;
        int[] columnas = new int[0];
        
        int userOption = 0;
        
        System.out.println("Pulse un numero para elegir la lista de productos que quiere mostrar:\n");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");
        userOption = Integer.parseInt(Main.scanner());
        
        switch (userOption) {
            case 1 -> {
                if (!listaProductosERP.isEmpty()) {
                    columnas = pedirIntervaloColumnasProductosERP(colsERP);
                    if (columnas[0] >= 0 && columnas[1] >= columnas[0]) {
                        mostrarInfoIntervaloColumnasProductosERP(listaProductosERP, columnas);
                    }else {
                        System.err.println("No se introdujeron los intervalos de columnas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }
            
            case 2 -> {
                if (!listaProductosPrestaShop.isEmpty()) {
                    columnas = pedirIntervaloColumnasProductosPrestaShop(colsPrestaShop);
                    if (columnas[0] >= 0 && columnas[1] >= columnas[0]) {
                        mostrarInfoIntervaloColumnasProductosPrestaShop(listaProductosPrestaShop, columnas);
                    }else {
                        System.err.println("No se introdujeron los intervalos de columnas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }
            
            default -> {
                System.err.println("Introduzca un numero entre el 1 y el 2!");
            }
        }
    }

    // Pedir seleccion lista intervalo columnas (ERP o PrestaShop)
    public static void pedirListaUserInfoIntervaloFilasColumnas(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop){
        String[] colsERP = Main.COLUMNASERP;
        String[] colsPrestaShop = Main.COLUMNASPRESTASHOP;
        int[] filas = new int[0];
        int[] columnas = new int[0];

        int userOption = 0;

        System.out.println("Pulse un numero para elegir la lista de productos que quiere mostrar:\n");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");
        userOption = Integer.parseInt(Main.scanner());

        switch (userOption) {
            case 1 -> {
                if (!listaProductosERP.isEmpty()) {
                    filas = pedirIntervaloFilasProductosERP(listaProductosERP);
                    columnas = pedirIntervaloColumnasProductosERP(colsERP);
                    if (columnas[0] >= 0 && columnas[1] >= columnas[0] && filas[0] >= 0 && filas[1] >= filas[0]) {
                        mostrarInfoIntervaloFilasColumnasProductosERP(listaProductosERP, filas, columnas);
                    }else {
                        System.err.println("No se introdujeron los intervalos de filas o columnas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }

            case 2 -> {
                if (!listaProductosPrestaShop.isEmpty()) {
                    columnas = pedirIntervaloColumnasProductosPrestaShop(colsPrestaShop);
                    if (columnas[0] >= 0 && columnas[1] >= columnas[0]) {
                        mostrarInfoIntervaloColumnasProductosPrestaShop(listaProductosPrestaShop, columnas);
                    }else {
                        System.err.println("No se introdujeron los intervalos de columnas correctamente!");
                    }
                } else {
                    System.err.println("No se cargaron los datos de los productos correctamente!");
                }
            }

            default -> {
                System.err.println("Introduzca un numero entre el 1 y el 2!");
            }
        }
    }
    
    // Pedir Intervalo Numerico
    
    // Pedir intervalo numerico filas
    public static int[] pedirIntervaloFilasProductosERP(ArrayList<ProductoERP> listaProductosERP) {
        int[] filas = new int[2];
        
        int fila1 = 0, fila2 = 0, aux = 0;
        boolean filasCorrectas = false;
        
        do {
            System.out.println("Introduzca el intervalo de filas que quiera mostrar: ");
            
            System.out.println("Intervalo 1:");
            fila1 = Integer.parseInt(Main.scanner());
            
            System.out.println("");
            
            System.out.println("Intervalo 2:");
            fila2 = Integer.parseInt(Main.scanner());
            
            if (fila1 <= 0 || fila1 > listaProductosERP.size() || fila2 <= 0 || fila2 > listaProductosERP.size()) {
                System.err.println("Introduzca valores entre el 1 y el " + listaProductosERP.size() + "!");
                filasCorrectas = false;
            } else {
                filasCorrectas = true;
            }
        
        } while (!filasCorrectas);
        
        if (fila1 > fila2) {
            aux = fila2;
            fila2 = fila1;
            fila1 = aux;
        }
        
        filas[0] = fila1 - 1;
        filas[1] = fila2 - 1;
            
        return filas;
    }
    
    public static int[] pedirIntervaloFilasProductosPrestaShop(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        int[] filas = new int[2];
        
        int fila1 = 0, fila2 = 0, aux = 0;
        boolean filasCorrectas = false;
        do {
            System.out.println("Introduzca el intervalo de filas que quiera mostrar: ");
            
            System.out.println("Intervalo 1:");
            fila1 = Integer.parseInt(Main.scanner());
            
            System.out.println("");
            
            System.out.println("Intervalo 2:");
            fila2 = Integer.parseInt(Main.scanner());
            
            if (fila1 <= 0 || fila1 > listaProductosPrestaShop.size() || fila2 <= 0 || fila2 > listaProductosPrestaShop.size()) {
                System.err.println("Introduzca valores entre el 1 y el " + listaProductosPrestaShop.size() + "!");
                filasCorrectas = false;
            } else {
                filasCorrectas = true;
            }
            
        } while (!filasCorrectas);
        
        if (fila1 > fila2) {
            aux = fila2;
            fila2 = fila1;
            fila1 = aux;
        }
        
        filas[0] = fila1 - 1;
        filas[1] = fila2 - 1;
        
        return filas;
    }
    
    // Pedir intervalo numerico columnas productos ERP
    public static int[] pedirIntervaloColumnasProductosERP(String[] nombresColumnasERP) {
        int[] columnas = new int[2];
        
        int col1 = 0, col2 = 0, aux = 0;
        boolean colCorrectas = false;
        
        System.out.println("Columnas disponibles: " + String.join(", ", nombresColumnasERP) + "\n");
        
        do {
            System.out.println("Introduzca el intervalo de columnas que quiera mostrar: ");
            System.out.println("Intervalo 1:");
            col1 = Integer.parseInt(Main.scanner());
            
            System.out.println("");
            
            System.out.println("Intervalo 2:");
            col2 = Integer.parseInt(Main.scanner());
            
            if (col1 <= 0 || col1 > nombresColumnasERP.length || col2 <= 0 || col2 > nombresColumnasERP.length) {
                System.err.println("Introduzca valores entre el 1 y el " + nombresColumnasERP.length + "!");
                colCorrectas = false;
            } else {
                colCorrectas = true;
            }
            
        } while (!colCorrectas);
        
        if (col1 > col2) {
            aux = col2;
            col2 = col1;
            col1 = aux;
        }
        
        columnas[0] = col1 - 1;
        columnas[1] = col2 - 1;
        
        return columnas;
    }
    
    // Pedir intervalo numerico columnas productos PrestaShop
    public static int[] pedirIntervaloColumnasProductosPrestaShop(String[] nombresColumnasPrestaShop) {
        int[] columnas = new int[2];
        
        int col1 = 0, col2 = 0, aux = 0;
        boolean colCorrectas = false;
        
        System.out.println("Columnas disponibles: " + String.join(", ", nombresColumnasPrestaShop) + "\n");
        
        do {
            System.out.println("Introduzca el intervalo de columnas que quiera mostrar: ");
            System.out.println("Intervalo 1:");
            col1 = Integer.parseInt(Main.scanner());
            
            System.out.println("");
            
            System.out.println("Intervalo 2:");
            col2 = Integer.parseInt(Main.scanner());
            
            if (col1 <= 0 || col1 > nombresColumnasPrestaShop.length || col2 <= 0 || col2 > nombresColumnasPrestaShop.length) {
                System.err.println("Introduzca valores entre el 1 y el " + nombresColumnasPrestaShop.length + "!");
                colCorrectas = false;
            } else {
                colCorrectas = true;
            }
            
        } while (!colCorrectas);
        
        if (col1 > col2) {
            aux = col2;
            col2 = col1;
            col1 = aux;
        }
        
        columnas[0] = col1 - 1;
        columnas[1] = col2 - 1;
        
        return columnas;
    }
    
    // Mostrar Informacion
    
    //Mostrar info completa ERP
    public static void mostrarInfoCompletaProductosERP(ArrayList<ProductoERP> listaProductosERP) {
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
    
    //Mostrar info completa PrestaShop
    public static void mostrarInfoCompletaProductosPrestaShop(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        System.out.println("\nInformacion detallada y completa de los productos de PrestaShop: \n");
        
        for (ProductoPrestaShop p : listaProductosPrestaShop) {
            System.out.println("Nombre del producto: " + p.getNombre() + "\n");
            System.out.println("ID: " + p.getId());
            System.out.println("ID Combinacion: " + p.getIdCombinacion());
            System.out.println("Codigo de barras / Ean: " + p.getEan());
            System.out.println("Codigo de referencia: " + p.getCodReferencia() + "\n");
            System.out.println("Medida / Talla / Calibre: " + p.getTalla());
            System.out.println("Atributos: " + p.getAtributos() + "\n");
            System.out.println("/////////////////////////\n");
        }
    }
    
    // Mostrar info intervalo filas del ERP
    public static void mostrarInfoIntervaloFilasProductosERP(ArrayList<ProductoERP> listaProductosERP, int[] filas) {
        System.out.println("Informacion detallada y completa de los productos del ERP ( Filas: " + (filas[0] + 1) + " a " + (filas[1] + 1) + ")\n");
        
        for (int i = filas[0]; i <= filas[1]; i++) {
            System.out.println("Nombre del producto: " + listaProductosERP.get(i).getNombre() + "\n");
            System.out.println("Codigo: " + listaProductosERP.get(i).getCodigo());
            System.out.println("Codigo de barras / Ean: " + listaProductosERP.get(i).getEan());
            System.out.println("Codigo de referencia: " + listaProductosERP.get(i).getCodReferencia() + "\n");
            System.out.println("Medida / Talla / Calibre: " + listaProductosERP.get(i).getTalla());
            System.out.println("Proveedor: " + listaProductosERP.get(i).getNombreProveedor());
            System.out.println("Observaciones: " + listaProductosERP.get(i).getObservaciones() + "\n");
            System.out.println("/////////////////////////\n");
        }
    }
    
    // Mostrar info intervalo filas de PrestaShop
    public static void mostrarInfoIntervaloFilasProductosPrestaShop(ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int[] filas) {
        System.out.println("Informacion detallada y completa de los productos de PrestaShop ( Filas: " + (filas[0] + 1) + " a " + (filas[1] + 1) + ")\n");
        
        for (int i = filas[0]; i <= filas[1]; i++) {
            System.out.println("Nombre del producto: " + listaProductosPrestaShop.get(i).getNombre() + "\n");
            System.out.println("ID: " + listaProductosPrestaShop.get(i).getId());
            System.out.println("ID Combinacion: " + listaProductosPrestaShop.get(i).getIdCombinacion());
            System.out.println("Codigo de barras / Ean: " + listaProductosPrestaShop.get(i).getEan()+ "\n");
            System.out.println("Codigo de referencia: " + listaProductosPrestaShop.get(i).getCodReferencia());
            System.out.println("Medida / Talla / Calibre: " + listaProductosPrestaShop.get(i).getTalla());
            System.out.println("Atributos: " + listaProductosPrestaShop.get(i).getAtributos()+ "\n");
            System.out.println("/////////////////////////\n");
        }
    }
    
    // Metodo complementario de mostrarInfoIntervaloColumnasProductosERP()
    private static String[] obtenerCamposProductosERP(ProductoERP p) {
        String[] campos = new String[7];

        campos[0] = "Nombre del producto: " + p.getNombre();
        campos[1] = "Codigo: " + p.getCodigo();
        campos[2] = "Codigo de barras / Ean: " + p.getEan();
        campos[3] = "Codigo de referencia: " + p.getCodReferencia();
        campos[4] = "Medida / Talla / Calibre: " + p.getTalla();
        campos[5] = "Nombre Proveedor: " + p.getNombreProveedor();
        campos[6] = "Observaciones: " + p.getObservaciones();

        return campos;
    }
    
    // Metodo complementario de mostrarInfoIntervaloColumnasProductosPrestaShop()
    private static String[] obtenerCamposProductosPrestaShop(ProductoPrestaShop p) {
        String[] campos = new String[7];

        campos[0] = "Nombre del producto: " + p.getNombre();
        campos[1] = "ID: " + p.getId();
        campos[2] = "ID Combinacion: " + p.getIdCombinacion();
        campos[3] = "Codigo de barras / Ean: " + p.getEan();
        campos[4] = "Codigo de referencia: " + p.getCodReferencia();
        campos[5] = "Medida / Talla / Calibre: " + p.getTalla();
        campos[6] = "Atributos: " + p.getAtributos();

        return campos;
    }
    
    // Mostrar info intervalo columnas ERP
    public static void mostrarInfoIntervaloColumnasProductosERP(ArrayList<ProductoERP> listaProductosERP, int[] columnas) {
        ProductoERP p = new ProductoERP();
        String[] campos = new String[0];
        
        System.out.println("Informacion detallada y completa de los productos del ERP ( Columnas: " + (columnas[0] + 1) + " a " + (columnas[1] + 1) + ")\n");
        
        for (int i = 0; i < listaProductosERP.size(); i++) {
            p = listaProductosERP.get(i);
            campos = obtenerCamposProductosERP(p);

            for (int j = columnas[0]; j <= columnas[1]; j++) {
                System.out.println(campos[j]);
            }

            System.out.println("/////////////////////////\n");
        }
    }
    
    // Mostrar info intervalo columnas PrestaShop
    public static void mostrarInfoIntervaloColumnasProductosPrestaShop(ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int[] columnas) {
        ProductoPrestaShop p = new ProductoPrestaShop();
        String[] campos = new String[0];

        System.out.println("Informacion detallada de los productos de PrestaShop ( Columnas: " + (columnas[0] + 1) + " a " + (columnas[1] + 1) + ")\n");

        for (int i = 0; i < listaProductosPrestaShop.size(); i++) {
            p = listaProductosPrestaShop.get(i);
            campos = obtenerCamposProductosPrestaShop(p);

            for (int j = columnas[0]; j <= columnas[1]; j++) {
                System.out.println(campos[j]);
            }

            System.out.println("/////////////////////////\n");
        }
    }

    // Mostrar info intervalo filas y columnas ERP
    public static void mostrarInfoIntervaloFilasColumnasProductosERP(ArrayList<ProductoERP> listaProductosERP, int[] filas, int[] columnas) {
        ProductoERP p = new ProductoERP();
        String[] campos = new String[0];

        System.out.println("Informacion detallada de los productos de ERP ( Filas: " + (filas[0] + 1) + (filas[1] + 1) + "Columnas: "
                + (columnas[0] + 1) + " a " + (columnas[1] + 1) + ")\n");

        for (int i = filas[0]; i <= filas[1]; i++) {
            p = listaProductosERP.get(i);
            campos = obtenerCamposProductosERP(p);

            for (int j = columnas[0]; j <= columnas[1]; j++) {
                System.out.println(campos[j]);
            }
            System.out.println("/////////////////////////\n");
        }
    }
}