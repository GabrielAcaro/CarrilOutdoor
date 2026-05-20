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
        int userOptionList = 0, userOptionField = 0, i = 0, id = 0, idCombinacion = 0;
        boolean encontrado = false;
        String nombre = "", codigo = "", ean = "", codReferencia = "", nombreProveedor = "";

        System.out.println("Introduzca uno de estos numero para elegir la lista en la que buscar: ");
        System.out.println("Lista de productos ERP: 1)");
        System.out.println("Lista de productos Prestashop: 2)");

        userOptionList = Integer.parseInt(Main.scanner());

        if (userOptionList == 1) {
            System.out.println("Introduzca uno de estos numeros para elegir por que campo buscar:\n");
            mostrarOpcionesBusquedaERP();
            userOptionField = Integer.parseInt(Main.scanner());

            switch (userOptionField) {
                case 1 -> {
                    System.out.println("Introduzca el nombre a buscar en la lista: ");
                    nombre = Main.scanner();

                    while (i < listaProductosERP.size() && !encontrado) {
                        if (nombre.equals(listaProductosERP.get(i).getNombre())) {
                                        mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 2 -> {
                    System.out.println("Introduzca el codigo a buscar en la lista: ");
                    codigo = Main.scanner();

                    while (i < listaProductosERP.size() && !encontrado) {
                        if (codigo.equals(listaProductosERP.get(i).getCodigo())) {
                            mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 3 -> {
                    System.out.println("Introduzca el Codigo de Barras / Ean a buscar en la lista: ");
                    ean = Main.scanner();

                    while (i < listaProductosERP.size() && !encontrado) {
                        if (ean.equals(listaProductosERP.get(i).getEan())) {
                            mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 4 -> {
                    System.out.println("Introduzca el codReferencia a buscar en la lista: ");
                    codReferencia = Main.scanner();

                    while (i < listaProductosERP.size() && !encontrado) {
                        if (codReferencia.equals(listaProductosERP.get(i).getCodReferencia())) {
                            mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 5 -> {
                    System.out.println("Introduzca el nombreProveedor a buscar en la lista: ");
                    nombreProveedor = Main.scanner();

                    while (i < listaProductosERP.size() && !encontrado) {
                        if (nombreProveedor.equals(listaProductosERP.get(i).getNombreProveedor())) {
                            mostrarInfoProductosERPEncontrado(listaProductosERP, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }
            }
        } else if (userOptionList == 2) {
            System.out.println("Introduzca uno de estos numeros para elegir por que campo buscar:\n");
            mostrarOpcionesBusquedaPrestaShop();
            userOptionField = Integer.parseInt(Main.scanner());

            switch (userOptionField) {
                case 1 -> {
                    System.out.println("Introduzca el nombre a buscar en la lista: ");
                    nombre = Main.scanner();

                    while (i < listaProductosPrestaShop.size() && !encontrado) {
                        if (nombre.equals(listaProductosPrestaShop.get(i).getNombre())) {
                            mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 2 -> {
                    System.out.println("Introduzca el ID a buscar en la lista: ");
                    id = Integer.parseInt(Main.scanner());

                    while (i < listaProductosPrestaShop.size() && !encontrado) {
                        if (id == listaProductosPrestaShop.get(i).getId()) {
                            mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 3 -> {
                    System.out.println("Introduzca el ID Combinacion a buscar en la lista: ");
                    idCombinacion = Integer.parseInt(Main.scanner());

                    while (i < listaProductosPrestaShop.size() && !encontrado) {
                        if (idCombinacion == listaProductosPrestaShop.get(i).getIdCombinacion()) {
                            mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 4 -> {
                    System.out.println("Introduzca el Codigo de Barras / Ean a buscar en la lista: ");
                    ean = Main.scanner();

                    while (i < listaProductosPrestaShop.size() && !encontrado) {
                        if (ean.equals(listaProductosPrestaShop.get(i).getEan())) {
                            mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }

                case 5 -> {
                    System.out.println("Introduzca el codReferencia a buscar en la lista: ");
                    codReferencia = Main.scanner();

                    while (i < listaProductosPrestaShop.size() && !encontrado) {
                        if (codReferencia.equals(listaProductosPrestaShop.get(i).getCodReferencia())) {
                            mostrarInfoProductosPrestaShopEncontrado(listaProductosPrestaShop, i);
                            encontrado = true;
                        } else {
                            encontrado = false;
                        }
                        i++;
                    }
                }
            }
        } else {
            System.err.println("Introduzca un numero entre el 1 y el 2!");
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
}
