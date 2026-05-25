package com.carriloutdoor.comparadorcsvproductos.service;

import com.carriloutdoor.comparadorcsvproductos.Main;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;

import java.util.ArrayList;

/**
 * BuscadorProductosService
 * @author Gabriel Acaro Sánchez
 */
public class BuscadorProductosService {

    // Metodo que realiza las busquedas en las listas de productos
    public static void buscarProductos(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {

        // Declaracion de variables
        int userOptionList = 0, userOptionField = 0;
        userOptionList = pedirUserOptionList();

        // Comienzo de logica del metodo
        if (userOptionList != -1) {

            switch (userOptionList) { // Switch para elegir la lista en la que buscar
                case 1 -> { // ERP
                    userOptionField = pedirUserOptionField(userOptionList); // Llamada a metodos que usamos para pedir un numero al usuario, limpiarlo y almacenarlo

                    menuBusquedaERP(listaProductosERP, listaProductosPrestaShop, userOptionList, userOptionField); // Llamada al metodo donde se ejecuta la logica de la busqueda
                }

                case 2 -> { // PrestaShop
                    userOptionField = pedirUserOptionField(userOptionList); // Llamada a metodos que usamos para pedir un numero al usuario, limpiarlo y almacenarlo

                    menuBusquedaPrestashop(listaProductosERP, listaProductosPrestaShop, userOptionList, userOptionField); // Llamada al metodo donde se ejecuta la logica de la busqueda
                }

                default -> System.err.println("Introduzca un número entre el 1 y el 2!"); // Mensaje feedback
            }
        }
    }

    // Metodo que pide el campo UserOptionList al user
    public static int pedirUserOptionList() {

        // Declaracion de variables
        String userNum = "";
        int userOptionList = 0;

        System.out.println("Introduzca uno de estos números para elegir la lista en la que buscar: ");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");

        userNum = Main.comprobarScanner(Main.scanner()); // Llamada a metodos que usamos para pedir un numero al usuario, limpiarlo y almacenarlo

        // Capturamos excepciones
        try {
            userOptionList = Integer.parseInt(userNum);
        } catch (NumberFormatException e) {
            userOptionList = -1;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        return userOptionList; // Retornamos la variable
    }

    // Metodo que pide el campo UserOptionField al user
    public static int pedirUserOptionField(int userOptionList) {

        // Declaracion de variables
        String userNum = "";
        int userOptionField = 0;

        if (userOptionList == 1) { // Si el user elige ERP
            System.out.println("Introduzca uno de estos números para elegir por que campo buscar:\n");

            mostrarOpcionesBusquedaERP(); // LLamada al metodo que muestra las opciones de busqueda
            userNum = Main.comprobarScanner(Main.scanner()); // Llamada a metodos que usamos para pedir un numero al usuario, limpiarlo y almacenarlo

            // Capturamos errores
            try {
                userOptionField = Integer.parseInt(userNum);
            } catch (NumberFormatException e) {
                userOptionField = -1;
                System.err.println("Solo se permiten numeros en este campo!");
            }

        } else if (userOptionList == 2) { // Si el user elige PrestaShop
            System.out.println("Introduzca uno de estos números para elegir por que campo buscar:\n");

            mostrarOpcionesBusquedaPrestaShop(); // LLamada al metodo que muestra las opciones de busqueda
            userNum = Main.comprobarScanner(Main.scanner()); // Llamada a metodos que usamos para pedir un numero al usuario, limpiarlo y almacenarlo

            // Capturamos errores
            try {
                userOptionField = Integer.parseInt(userNum);
            } catch (NumberFormatException e) {
                userOptionField = -1;
                System.err.println("Solo se permiten numeros en este campo!");
            }
        }

        return userOptionField; // Devolvemos el numero limpio y libre de errores
    }

    // Menu de busqueda del ERP
    public static void menuBusquedaERP(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList, int userOptionField) {
        // ERP
        switch (userOptionField) { // Menu que llama a cada metodo en funcion del campo que elija el user
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

    // Menu de busqueda del Prestashop
    public static void menuBusquedaPrestashop(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList, int userOptionField) {
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

    // Metodo que muestra el mini menu de la busqueda de productos del ERP
    public static void mostrarOpcionesBusquedaERP() {
        System.out.println("Nombre: 1");
        System.out.println("Codigo: 2");
        System.out.println("Codigo de barras / Ean: 3");
        System.out.println("Codigo de referencia: 4");
        System.out.println("Nombre del proveedor: 5");
    }

    // Metodo que muestra el mini menu de la busqueda de productos del PrestaShop
    public static void mostrarOpcionesBusquedaPrestaShop() {
        System.out.println("Nombre: 1");
        System.out.println("ID: 2");
        System.out.println("ID Combinacion: 3");
        System.out.println("Codigo de barras / Ean: 4");
        System.out.println("Codigo de referencia: 5");
    }

    // Metodo que muestra el resultado de la busqueda de productos del ERP
    public static void mostrarInfoProductosERPEncontrado(ArrayList<ProductoERP> listaProductosERP, int i) {
        System.out.println("Nombre del producto: " + listaProductosERP.get(i).getNombre() + "\n");
        System.out.println("Codigo: " + listaProductosERP.get(i).getCodigo());
        System.out.println("Codigo de barras / Ean: " + listaProductosERP.get(i).getEan());
        System.out.println("Codigo de referencia: " + listaProductosERP.get(i).getCodReferencia() + "\n");
        System.out.println("Medida / Talla / Calibre: " + listaProductosERP.get(i).getTalla());
        System.out.println("Proveedor: " + listaProductosERP.get(i).getNombreProveedor());
        System.out.println("Observaciones: " + listaProductosERP.get(i).getObservaciones() + "\n");
    }

    // Metodo que muestra el resultado de la busqueda de productos del PrestaShop
    public static void mostrarInfoProductosPrestaShopEncontrado(ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int i) {
        System.out.println("Nombre del producto: " + listaProductosPrestaShop.get(i).getNombre() + "\n");
        System.out.println("ID: " + listaProductosPrestaShop.get(i).getId());
        System.out.println("ID Combinacion: " + listaProductosPrestaShop.get(i).getIdCombinacion());
        System.out.println("Codigo de barras / Ean: " + listaProductosPrestaShop.get(i).getEan());
        System.out.println("Codigo de referencia: " + listaProductosPrestaShop.get(i).getCodReferencia() + "\n");
        System.out.println("Medida / Talla / Calibre: " + listaProductosPrestaShop.get(i).getTalla());
        System.out.println("Atributos: " + listaProductosPrestaShop.get(i).getAtributos() + "\n");
    }

    // Metodo que pide el Nombre a buscar
    public static void pedirNombre(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {

        // Declaracion de variables
        String nombre = "";
        boolean encontrado = false;

        System.out.println("Introduzca el nombre a buscar en la lista: ");
        nombre = Main.comprobarScanner(Main.scanner()); // Llamada a metodos que usamos para pedir un texto al usuario, limpiarlo y almacenarlo
        nombre = nombre.toUpperCase(); // Convertimos todo el texto a mayusculas para que las busquedas coincidan

        if (!nombre.isEmpty()) {
            if (userOptionList == 1) {
                for (int i = 0; i < listaProductosERP.size(); i++) { // Recorremos toda la lista para encontrar todas las coincidencias
                    if (listaProductosERP.get(i).getNombre() != null && listaProductosERP.get(i).getNombre().trim().toUpperCase().contains(nombre)) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) {
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) { // Recorremos toda la lista para encontrar todas las coincidencias
                    if (listaProductosPrestaShop.get(i).getNombre() != null && listaProductosPrestaShop.get(i).getNombre().trim().toUpperCase().contains(nombre)) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                    }
                }
            }
        }
        // Mensaje de feedback
        if (nombre.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    // Metodo que pide el Codigo a buscar
    public static void pedirCodigo(ArrayList<ProductoERP> listaProductosERP) {

        // Declaracion de variables
        String codigo = "";
        int i = 0;
        boolean encontrado = false;

        System.out.println("Introduzca el codigo a buscar en la lista: ");
        codigo = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo

        if (!codigo.isEmpty()) { // Logica de busqueda
            while (i < listaProductosERP.size() && !encontrado) {
                if (codigo.equals(listaProductosERP.get(i).getCodigo().trim())) {
                    mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                    encontrado = true;
                }
                i++;
            }
        }

        // Mensaje de feedback
        if (codigo.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    // Metodo que pide el Ean a buscar
    public static void pedirEan(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {

        // Declaracion de variables
        String ean = "";
        boolean encontrado = false;

        System.out.println("Introduzca el Codigo de Barras / Ean a buscar en la lista: ");
        ean = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo

        if (!ean.isEmpty()) {
            if (userOptionList == 1) { // Recorremos toda la lista para encontrar todas las coincidencias
                for (int i = 0; i < listaProductosERP.size(); i++) {
                    if (ean.equals(listaProductosERP.get(i).getEan().trim())) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) { // Recorremos toda la lista para encontrar todas las coincidencias
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) {
                    if (ean.equals(listaProductosPrestaShop.get(i).getEan().trim())) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                    }
                }
            }
        }
        // Mensaje de feedback
        if (ean.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    // Metodo que pide el Codigo de Referencia a buscar
    public static void pedirCodReferencia(ArrayList<ProductoERP> listaProductosERP, ArrayList<ProductoPrestaShop> listaProductosPrestaShop, int userOptionList) {

        // Declaracion de variables
        String codReferencia = "";
        boolean encontrado = false;

        System.out.println("Introduzca el codReferencia a buscar en la lista: ");
        codReferencia = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo

        if (!codReferencia.isEmpty()) {
            if (userOptionList == 1) {
                for (int i = 0; i < listaProductosERP.size(); i++) { // Recorremos toda la lista para encontrar todas las coincidencias
                    if (codReferencia.equals(listaProductosERP.get(i).getCodReferencia().trim())) {
                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                        encontrado = true;
                    }
                }
            } else if (userOptionList == 2) {
                for (int i = 0; i < listaProductosPrestaShop.size(); i++) { // Recorremos toda la lista para encontrar todas las coincidencias
                    if (codReferencia.equals(listaProductosPrestaShop.get(i).getCodReferencia().trim())) {
                        mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                        encontrado = true;
                       }
                }
            }
        }
        // Mensaje de feedback
        if (codReferencia.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    // Metodo que pide el Nombre del Proveedor a buscar
    public static void pedirNombreProveedor(ArrayList<ProductoERP> listaProductosERP) {

        // Declaracion de variables
        String nombreProveedor = "";
        boolean encontrado = false;

        System.out.println("Introduzca el nombre a buscar en la lista: ");
        nombreProveedor = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo
        nombreProveedor = nombreProveedor.toUpperCase();

        if (!nombreProveedor.isEmpty()) {
            for (int i = 0; i < listaProductosERP.size(); i++) { // Recorremos toda la lista para encontrar todas las coincidencias
                if (listaProductosERP.get(i).getNombreProveedor() != null && listaProductosERP.get(i).getNombreProveedor().trim().toUpperCase().contains(nombreProveedor)) {
                    mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                    encontrado = true;
                }
            }
        }

        // Mensaje de feedback
        if (nombreProveedor.isEmpty()) {
            System.err.println("Introduzca texto para poder buscar!");
        }else if (!encontrado) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }
    // Metodo que pide el Id a buscar
    public static void pedirId(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {

        // Declaracion de variables
        String textoUser = "";
        int id = 0,  i = 0;
        boolean encontrado = false, busquedaValida = true;

        System.out.println("Introduzca el ID a buscar en la lista: ");
        textoUser = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo

        try { // Capturamos excepciones
            id = Integer.parseInt(textoUser);
        } catch (NumberFormatException e) {
            busquedaValida = false;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        // Logica de busqueda
        while (i < listaProductosPrestaShop.size() && !encontrado && busquedaValida) {
            if (id == listaProductosPrestaShop.get(i).getId()) {
                mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                encontrado = true;
            }
            i++;
        }

        // Mensaje de feedback
        if (!encontrado && busquedaValida) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }

    // Metodo que pide el Id Combinacion a buscar
    public static void pedirIdCombinacion(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {

        // Declaracion de variables
        String textoUser = "";
        int idCombinacion = 0,  i = 0;
        boolean encontrado = false, busquedaValida = true;

        System.out.println("Introduzca el ID Combinacion a buscar en la lista: ");
        textoUser = Main.comprobarScanner(Main.scanner()); // Llamada a metodos para pedir un texto al usuario, limpiarlo y almacenarlo

        try { // Capturamos excepciones
            idCombinacion = Integer.parseInt(textoUser);
        } catch (NumberFormatException e) {
            busquedaValida = false;
            System.err.println("Solo se permiten numeros en este campo!");
        }

        // Logica de busqueda
        while (i < listaProductosPrestaShop.size() && !encontrado && busquedaValida) {
            if (idCombinacion == listaProductosPrestaShop.get(i).getIdCombinacion()) {
                mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                encontrado = true;
            }
            i++;
        }

        // Mensaje de feedback
        if (!encontrado && busquedaValida) {
            System.err.println("No se encontró el producto que esta buscando!\n");
        }
    }
}