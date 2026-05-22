package main.java.com.carriloutdoor.comparadorcsvproductos.service;

import main.java.com.carriloutdoor.comparadorcsvproductos.Main;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import main.java.com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;

import java.util.ArrayList;

/**
 * BuscadorProductosService
 * @author Gabriel Acaro Sánchez
 */
public class BuscadorProductosService {
    public static void solicitarListaUser(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        int userOptionList = 0, userOptionField = 0;

        userOptionList = pedirUserOptionList();

        if (userOptionList != -1) {

            switch (userOptionList) {
                case 1 -> {
                    userOptionField = pedirUserOptionField(userOptionList);

                    busquedaERP(listaProductosERP, listaProductosPrestaShop, userOptionList, userOptionField);
                }

                case 2 -> {
                    userOptionField = pedirUserOptionField(userOptionList);

                    busquedaPrestashop(listaProductosERP, listaProductosPrestaShop, userOptionList, userOptionField);
                }

                default -> System.err.println("Introduzca un número entre el 1 y el 2!");
            }
        }
    }

    public static int pedirUserOptionList() {
        String textoUser = "";
        int userOptionList = 0;

        System.out.println("Introduzca uno de estos números para elegir la lista en la que buscar: ");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");

        textoUser = Main.comprobarScanner(Main.scanner());

        try {
            userOptionList = Integer.parseInt(textoUser);
        } catch (NumberFormatException e) {
            userOptionList = -1;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        return userOptionList;
    }

    public static int pedirUserOptionField(int userOptionList) {
        String textoUser = "";
        int userOptionField = 0;

        if (userOptionList == 1) {
            System.out.println("Introduzca uno de estos números para elegir por que campo buscar:\n");
            mostrarOpcionesBusquedaERP();
            textoUser = Main.comprobarScanner(Main.scanner());

            try {
                userOptionField = Integer.parseInt(textoUser);
            } catch (NumberFormatException e) {
                userOptionField = -1;
                System.err.println("Solo se permiten numeros en este campo!");
            }
        } else if (userOptionList == 2) {
            System.out.println("Introduzca uno de estos números para elegir por que campo buscar:\n");
            mostrarOpcionesBusquedaPrestaShop();
            textoUser = Main.comprobarScanner(Main.scanner());

            try {
                userOptionField = Integer.parseInt(textoUser);
            } catch (NumberFormatException e) {
                userOptionField = -1;
                System.err.println("Solo se permiten numeros en este campo!");
            }
        }

        return userOptionField;
    }

    public static void busquedaERP(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList, int userOptionField) {
        switch (userOptionField) {
            case 1 -> {
                pedirNombre(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            case 2 -> {
                pedirCodigo(listaProductosERP);
            }

            case 3 -> {
                pedirEan(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            case 4 -> {
                pedirCodReferencia(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            case 5 -> {
                pedirNombreProveedor(listaProductosERP);
            }

            default -> {
                System.err.println("Elija un numero entre el 1 y el 5!");
            }
        }
    }

    public static void busquedaPrestashop(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList, int userOptionField) {
        switch (userOptionField) {
            case 1 -> {
                pedirNombre(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            case 2 -> {
                pedirId(listaProductosPrestaShop);
            }

            case 3 -> {
                pedirIdCombinacion(listaProductosPrestaShop);
            }

            case 4 -> {
                pedirEan(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            case 5 -> {
                pedirCodReferencia(listaProductosERP, listaProductosPrestaShop, userOptionList);
            }

            default -> {
                System.err.println("Introduzca un número entre el 1 y el 5");
            }
        }
    }

    public static void mostrarOpcionesBusquedaERP() {
        System.out.println("Nombre: 1");
        System.out.println("Codigo: 2");
        System.out.println("Codigo de barras / Ean: 3");
        System.out.println("Codigo de referencia: 4");
        System.out.println("Nombre del proveedor: 5");
    }

    public static void mostrarOpcionesBusquedaPrestaShop() {
        System.out.println("Nombre: 1");
        System.out.println("ID: 2");
        System.out.println("ID Combinacion: 3");
        System.out.println("Codigo de barras / Ean: 4");
        System.out.println("Codigo de referencia: 5");
    }

    public static void mostrarInfoProductosERPEncontrado(ArrayList<ProductoERP> listaProductosERP, int i) {
        System.out.println("Nombre del producto: " + listaProductosERP.get(i).getNombre() + "\n");
        System.out.println("Codigo: " + listaProductosERP.get(i).getCodigo());
        System.out.println("Codigo de barras / Ean: " + listaProductosERP.get(i).getEan());
        System.out.println("Codigo de referencia: " + listaProductosERP.get(i).getCodReferencia() + "\n");
        System.out.println("Medida / Talla / Calibre: " + listaProductosERP.get(i).getTalla());
        System.out.println("Proveedor: " + listaProductosERP.get(i).getNombreProveedor());
        System.out.println("Observaciones: " + listaProductosERP.get(i).getObservaciones() + "\n");
    }

    public static void mostrarInfoProductosPrestaShopEncontrado(ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int i) {
        System.out.println("Nombre del producto: " + listaProductosPrestaShop.get(i).getNombre() + "\n");
        System.out.println("ID: " + listaProductosPrestaShop.get(i).getId());
        System.out.println("ID Combinacion: " + listaProductosPrestaShop.get(i).getIdCombinacion());
        System.out.println("Codigo de barras / Ean: " + listaProductosPrestaShop.get(i).getEan());
        System.out.println("Codigo de referencia: " + listaProductosPrestaShop.get(i).getCodReferencia() + "\n");
        System.out.println("Medida / Talla / Calibre: " + listaProductosPrestaShop.get(i).getTalla());
        System.out.println("Atributos: " + listaProductosPrestaShop.get(i).getAtributos() + "\n");
    }

    public static void pedirNombre(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {
        String nombre = "";
        boolean encontrado = false;

        System.out.println("Introduzca el nombre a buscar en la lista: ");
        nombre = Main.comprobarScanner(Main.scanner());
        nombre = nombre.toUpperCase();

        if (!nombre.isEmpty()) {
            if (userOptionList == 1) {
                for (int i = 0; i < listaProductosERP.size(); i++) {
                    if (listaProductosERP.get(i).getNombre() != null && listaProductosERP.get(i).getNombre().trim().toUpperCase().contains(nombre)) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) {
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) {
                    if (listaProductosPrestaShop.get(i).getNombre() != null && listaProductosPrestaShop.get(i).getNombre().trim().toUpperCase().contains(nombre)) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                    }
                }
            }
        }

        if (nombre.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirCodigo(ArrayList<ProductoERP> listaProductosERP) {
        String codigo = "";
        int i = 0;
        boolean encontrado = false;

        System.out.println("Introduzca el codigo a buscar en la lista: ");
        codigo = Main.comprobarScanner(Main.scanner());

        if (!codigo.isEmpty()) {
            while (i < listaProductosERP.size() && !encontrado) {
                if (codigo.equals(listaProductosERP.get(i).getCodigo().trim())) {
                    mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                    encontrado = true;
                }
                i++;
            }
        }


        if (codigo.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirEan(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {
        String ean = "";
        boolean encontrado = false;

        System.out.println("Introduzca el Codigo de Barras / Ean a buscar en la lista: ");
        ean = Main.comprobarScanner(Main.scanner());

        if (!ean.isEmpty()) {
            if (userOptionList == 1) {
                for (int i = 0; i < listaProductosERP.size(); i++) {
                    if (ean.equals(listaProductosERP.get(i).getEan().trim())) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) {
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) {
                    if (ean.equals(listaProductosPrestaShop.get(i).getEan().trim())) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                    }
                }
            }
        }

        if (ean.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirCodReferencia(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {
        String codReferencia = "";
        boolean encontrado = false;

        System.out.println("Introduzca el codReferencia a buscar en la lista: ");
        codReferencia = Main.comprobarScanner(Main.scanner());

        if (!codReferencia.isEmpty()) {
            if (userOptionList == 1) {
                for (int i = 0; i < listaProductosERP.size(); i++) {
                    if (codReferencia.equals(listaProductosERP.get(i).getCodReferencia().trim())) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) {
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) {
                    if (codReferencia.equals(listaProductosPrestaShop.get(i).getCodReferencia().trim())) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                       }
                }
            }
        }

        if (codReferencia.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirNombreProveedor(ArrayList<ProductoERP> listaProductosERP) {
        String nombreProveedor = "";
        boolean encontrado = false;

        System.out.println("Introduzca el nombre a buscar en la lista: ");
        nombreProveedor = Main.comprobarScanner(Main.scanner());
        nombreProveedor = nombreProveedor.toUpperCase();

        if (!nombreProveedor.isEmpty()) {
            for (int i = 0; i < listaProductosERP.size(); i++) {
                if (listaProductosERP.get(i).getNombreProveedor() != null && listaProductosERP.get(i).getNombreProveedor().trim().toUpperCase().contains(nombreProveedor)) {
                    mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                    encontrado = true;
                }
            }
        }

        if (nombreProveedor.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirId(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        String textoUser = "";
        int id = 0,  i = 0;
        boolean encontrado = false, busquedaValida = true;

        System.out.println("Introduzca el ID a buscar en la lista: ");
        textoUser = Main.comprobarScanner(Main.scanner());

        try {
            id = Integer.parseInt(textoUser);
        } catch (NumberFormatException e) {
            busquedaValida = false;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        while (i < listaProductosPrestaShop.size() && !encontrado && busquedaValida) {
            if (id == listaProductosPrestaShop.get(i).getId()) {
                mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                encontrado = true;
            }
            i++;
        }
        if (!encontrado && busquedaValida) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    public static void pedirIdCombinacion(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        String textoUser = "";
        int idCombinacion = 0,  i = 0;
        boolean encontrado = false, busquedaValida = true;

        System.out.println("Introduzca el ID Combinacion a buscar en la lista: ");
        textoUser = Main.comprobarScanner(Main.scanner());

        try {
            idCombinacion = Integer.parseInt(textoUser);
        } catch (NumberFormatException e) {
            busquedaValida = false;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        while (i < listaProductosPrestaShop.size() && !encontrado && busquedaValida) {
            if (idCombinacion == listaProductosPrestaShop.get(i).getIdCombinacion()) {
                mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                encontrado = true;
            }
            i++;
        }

        if (!encontrado && busquedaValida) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }
}