package com.carriloutdoor.comparadorcsvproductos.service;

import com.carriloutdoor.comparadorcsvproductos.config.ConstantesNormalizacion;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoERP;
import com.carriloutdoor.comparadorcsvproductos.model.ProductoPrestaShop;
import com.carriloutdoor.comparadorcsvproductos.util.TextoUtil;

import java.util.ArrayList;

/**
 * NormalizadorService
 * @author Gabriel Acaro Sánchez
 */
public class NormalizadorService {

    public static void normalizarProductosERP(ArrayList<ProductoERP> listaProductosERP) {
        String nombreProductoNormalizado = "";

        for (int i = 0; i < listaProductosERP.size(); i++) {
            nombreProductoNormalizado = TextoUtil.normalizarTexto(listaProductosERP.get(i).getNombre());
            listaProductosERP.get(i).setNombreNormalizado(nombreProductoNormalizado);
        }
    }

    public static void detectorAtributosProductosERP(ArrayList<ProductoERP> listaProductosERP) {
        normalizarProductosERP(listaProductosERP);

        detectarMarcaProductoERP(listaProductosERP);
        detectarCalibreProductoERP(listaProductosERP);
        limpiarTallasInvalidasProductoERP(listaProductosERP);
        detectarTallaProductoERP(listaProductosERP);
        detectarColorProductoERP(listaProductosERP);
    }

    public static void detectarMarcaProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        String nombreNormalizado = "", marcaDetectada = "", marcaActual = "";

        if (listaProductosERP != null) {
            for (int i = 0; i < listaProductosERP.size(); i++) {
                nombreNormalizado = listaProductosERP.get(i).getNombreNormalizado();
                marcaActual = listaProductosERP.get(i).getMarca();
                marcaDetectada = "";

                if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                    nombreNormalizado = TextoUtil.normalizarTexto(listaProductosERP.get(i).getNombre());
                    listaProductosERP.get(i).setNombreNormalizado(nombreNormalizado);
                }

                if ((marcaActual == null || marcaActual.trim().isEmpty()) && nombreNormalizado != null && !nombreNormalizado.trim().isEmpty()) {
                    marcaDetectada = detectarMarcaDesdeNombre(nombreNormalizado);

                    if (!marcaDetectada.isEmpty()) {
                        listaProductosERP.get(i).setMarca(marcaDetectada);
                    }
                }
            }
        }
    }

    public static String detectarMarcaDesdeNombre(String nombreNormalizado) {
        String resultado = "", marca = "", nombre = "";
        boolean encontrado = false;

        if (nombreNormalizado != null) {
            nombre = TextoUtil.normalizarTexto(nombreNormalizado);

            for (int i = 0; i < ConstantesNormalizacion.MARCAS.length && !encontrado; i++) {
                marca = TextoUtil.normalizarTexto(ConstantesNormalizacion.MARCAS[i]);

                if (nombre.contains(" " + marca + " ")) {
                    resultado = ConstantesNormalizacion.MARCAS[i];
                    encontrado = true;
                } else if (nombre.startsWith(marca + " ")) {
                    resultado = ConstantesNormalizacion.MARCAS[i];
                    encontrado = true;
                } else if (nombre.endsWith(" " + marca)) {
                    resultado = ConstantesNormalizacion.MARCAS[i];
                    encontrado = true;
                } else if (nombre.equals(marca)) {
                    resultado = ConstantesNormalizacion.MARCAS[i];
                    encontrado = true;
                }
            }
        }

        return resultado;
    }

    public static void detectarColorProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        detectarColorDesdeObservacionesProductoERP(listaProductosERP);
        detectarColorDesdeNombreProductoERP(listaProductosERP);
        detectarColorDesdeCodigo(listaProductosERP);
    }

    public static void detectorColoresProductosPrestaShop(ArrayList<ProductoPrestaShop> listaProductosPrestaShop) {
        // normalizarProductosPrestaShop(listaProductosPrestaShop);

        // detectarColorProductoPrestaShop(listaProductosPrestaShop);

    }

    public static boolean coincideColor(String texto, String patronColor) {
        String textoNormalizado = "", patronNormalizado = "";
        boolean resultado = false;
        boolean esColorCompuesto = false;

        if (texto != null && patronColor != null) {
            textoNormalizado = TextoUtil.normalizarTexto(texto);
            patronNormalizado = TextoUtil.normalizarTexto(patronColor);

            esColorCompuesto = patronNormalizado.contains(" ") || patronNormalizado.contains("/") || patronNormalizado.contains("-");

            if (esColorCompuesto) {
                resultado = textoNormalizado.contains(patronNormalizado);
            } else {
                resultado = TextoUtil.contienePalabraExacta(textoNormalizado, patronNormalizado);
            }
        }

        return resultado;
    }

    public static void detectarColorDesdeObservacionesProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = null;
        String observaciones = "", colorDetectado = "";
        boolean encontrado = false;
        int j = 0;

        for (int i = 0; i < listaProductosERP.size(); i++) {
            p = listaProductosERP.get(i);
            observaciones = listaProductosERP.get(i).getObservaciones();
            encontrado = false;
            j = 0;

            if (productoAdmiteColorERP(p) && observaciones != null && !observaciones.trim().isEmpty()) {
                observaciones = TextoUtil.normalizarTexto(observaciones);

                while (j < ConstantesNormalizacion.COLORES.length && !encontrado) {
                    if (coincideColor(observaciones, ConstantesNormalizacion.COLORES[j][0])) {
                        colorDetectado = ConstantesNormalizacion.COLORES[j][1];
                        listaProductosERP.get(i).setColor(colorDetectado);
                        encontrado = true;
                    }
                    j++;
                }
            }
        }
    }

    public static void detectarColorDesdeNombreProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = null;

        String nombreNormalizado = "", colorDetectado = "", colorActual = "";
        boolean encontrado = false;
        int j = 0;

        for (int i = 0; i < listaProductosERP.size(); i++) {
            p = listaProductosERP.get(i);
            nombreNormalizado = listaProductosERP.get(i).getNombreNormalizado();
            colorActual = listaProductosERP.get(i).getColor();
            colorDetectado = "";
            encontrado = false;
            j = 0;

            if (productoAdmiteColorERP(p) && (colorActual == null || colorActual.trim().isEmpty()) && nombreNormalizado != null && !nombreNormalizado.trim().isEmpty()) {
                while (j < ConstantesNormalizacion.COLORES.length && !encontrado) {
                    if (coincideColor(nombreNormalizado, ConstantesNormalizacion.COLORES[j][0])) {
                        colorDetectado = ConstantesNormalizacion.COLORES[j][1];
                        listaProductosERP.get(i).setColor(colorDetectado);
                        encontrado = true;
                    }

                    j++;
                }
            }
        }
    }

    public static void detectarColorDesdeCodigo(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = null;

        String codigo = "", colorActual = "", colorDetectado = "";
        boolean encontrado = false;
        int j = 0;

        for (int i = 0; i < listaProductosERP.size(); i++) {
            p = listaProductosERP.get(i);
            codigo = listaProductosERP.get(i).getCodigo();
            colorActual = listaProductosERP.get(i).getColor();
            colorDetectado = "";
            encontrado = false;
            j = 0;

            if (productoAdmiteColorERP(p) && (colorActual == null || colorActual.trim().isEmpty()) && codigo != null && !codigo.trim().isEmpty()) {
                codigo = TextoUtil.normalizarTexto(codigo);

                while (j < ConstantesNormalizacion.COLORES.length && !encontrado) {
                    if (codigo.contains(ConstantesNormalizacion.COLORES[j][0])) {
                        colorDetectado = ConstantesNormalizacion.COLORES[j][1];
                        listaProductosERP.get(i).setColor(colorDetectado);
                        encontrado = true;
                    }

                    j++;
                }
            }
        }
    }

    public static void detectarCalibreProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP p = null;

        String nombreNormalizado = "", calibreActual = "", calibreDetectado = "";

        if (listaProductosERP != null) {
            for (int i = 0; i < listaProductosERP.size(); i++) {
                p = listaProductosERP.get(i);
                nombreNormalizado = p.getNombreNormalizado();
                calibreActual = p.getCalibre();
                calibreDetectado = "";

                if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                    nombreNormalizado = TextoUtil.normalizarTexto(p.getNombre());
                    p.setNombreNormalizado(nombreNormalizado);
                }

                if (productoPuedeTenerCalibreERP(p) && (calibreActual == null || calibreActual.trim().isEmpty()) && nombreNormalizado != null && !nombreNormalizado.trim().isEmpty()) {
                    calibreDetectado = detectarCalibreDesdeNombre(nombreNormalizado);

                    if (!calibreDetectado.isEmpty()) {
                        p.setCalibre(calibreDetectado);
                    }
                }
            }
        }
    }

    public static String detectarCalibreDesdeNombre(String nombreNormalizado) {
        String resultado = "", nombre = "", patron = "";
        boolean encontrado = false;

        if (nombreNormalizado != null) {
            nombre = normalizarTextoCalibre(nombreNormalizado);

            for (int i = 0; i < ConstantesNormalizacion.CALIBRES.length && !encontrado; i++) {
                patron = normalizarTextoCalibre(ConstantesNormalizacion.CALIBRES[i][0]);

                if (TextoUtil.contienePalabraExacta(nombre, patron)) {
                    resultado = ConstantesNormalizacion.CALIBRES[i][1];
                    encontrado = true;
                }
            }
        }

        return resultado;
    }

    private static String normalizarTextoCalibre(String texto) {
        String resultado = "";

        if (texto != null) {
            resultado = TextoUtil.normalizarTexto(texto);
            resultado = resultado.replace(",", ".");
            resultado = resultado.replace("CAL.", "CAL ");
            resultado = resultado.replace("CAL-", "CAL ");
            resultado = resultado.replace("CAL/", "CAL ");
            resultado = resultado.replace("C/", "C ");
            resultado = resultado.replace("C.", "C ");
            resultado = resultado.replace("C-", "C ");
            resultado = TextoUtil.limpiarEspacios(resultado);
        }

        return resultado;
    }

    public static void detectarTallaProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP producto = null;

        String nombreNormalizado = "", tallaActual = "", calibreActual = "", tallaDetectada = "";

        if (listaProductosERP != null) {
            for (int i = 0; i < listaProductosERP.size(); i++) {
                producto = listaProductosERP.get(i);
                nombreNormalizado = producto.getNombreNormalizado();
                tallaActual = producto.getTalla();
                calibreActual = producto.getCalibre();
                tallaDetectada = "";

                if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                    nombreNormalizado = TextoUtil.normalizarTexto(producto.getNombre());
                    producto.setNombreNormalizado(nombreNormalizado);
                }

                if (productoAdmiteTallaERP(producto) && (tallaActual == null || tallaActual.trim().isEmpty()) && (calibreActual == null || calibreActual.trim().isEmpty()) && nombreNormalizado != null && !nombreNormalizado.trim().isEmpty()) {
                    tallaDetectada = detectarTallaDesdeNombre(nombreNormalizado);

                    if (!tallaDetectada.isEmpty()) {
                        producto.setTalla(tallaDetectada);
                    }
                }
            }
        }
    }

    public static String detectarTallaDesdeNombre(String nombreNormalizado) {
        String[] palabras = new String[0];

        String resultado = "", nombre = "", ultimaPalabra = "", penultimaPalabra = "", talla = "";
        boolean encontrado = false;
        int posicionUltimaPalabra = 0;

        if (nombreNormalizado != null) {
            nombre = normalizarTextoTalla(nombreNormalizado);
            palabras = TextoUtil.obtenerPalabras(nombre);

            if (nombre.endsWith("T UNI") || nombre.endsWith("T UNICA") || nombre.endsWith("TALLA UNICA")) {
                resultado = "UNICA";
                encontrado = true;
            }

            if (palabras.length > 0 && !encontrado) {
                posicionUltimaPalabra = palabras.length - 1;
                ultimaPalabra = palabras[posicionUltimaPalabra];

                if (posicionUltimaPalabra > 0) {
                    penultimaPalabra = palabras[posicionUltimaPalabra - 1];
                }

                if (!esUnidadMedidaNoTalla(ultimaPalabra, penultimaPalabra)) {
                    for (int i = 0; i < ConstantesNormalizacion.TALLAS_ROPA.length && !encontrado; i++) {
                        talla = ConstantesNormalizacion.TALLAS_ROPA[i];

                        if (ultimaPalabra.equals(talla)) {
                            resultado = normalizarTalla(talla);
                            encontrado = true;
                        }
                    }

                    for (int i = 0; i < ConstantesNormalizacion.TALLAS_NUMERICAS.length && !encontrado; i++) {
                        talla = ConstantesNormalizacion.TALLAS_NUMERICAS[i];

                        if (ultimaPalabra.equals(talla)) {
                            resultado = talla;
                            encontrado = true;
                        }
                    }
                }
            }
        }

        return resultado;
    }

    private static String normalizarTextoTalla(String texto) {
        String resultado = "";

        if (texto != null) {
            resultado = TextoUtil.normalizarTexto(texto);
            resultado = resultado.replace("ª", " ");
            resultado = resultado.replace("T/", "T ");
            resultado = resultado.replace("T-", "T ");
            resultado = TextoUtil.limpiarEspacios(resultado);
        }

        return resultado;
    }

    private static String normalizarTalla(String talla) {
        String resultado = "";

        if (talla != null) {
            resultado = talla;

            if (talla.equals("U") || talla.equals("UNI")) {
                resultado = "UNICA";
            }
        }

        return resultado;
    }

    private static boolean esUnidadMedidaNoTalla(String palabra, String palabraAnterior) {
        boolean resultado = false;
        boolean esTallaRopa = false;

        if (palabra != null) {
            esTallaRopa = esTallaRopaValida(palabra);

            if (!esTallaRopa) {
                if (palabra.endsWith("ML") || palabra.endsWith("MM") || palabra.endsWith("CM") || palabra.endsWith("KG") || palabra.endsWith("GR") || palabra.endsWith("OZ") || palabra.endsWith("MAH") || palabra.endsWith("LUM")) {
                    resultado = true;
                }else if (palabra.matches("[0-9]+X[0-9]+.*")) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    private static boolean esNumeroEntero(String texto) {
        boolean resultado = false;

        if (texto != null && !texto.trim().isEmpty()) {
            resultado = texto.matches("[0-9]+");
        }

        return resultado;
    }

    private static boolean contieneNumero(String texto) {
        boolean resultado = false;

        if (texto != null) {
            resultado = texto.matches(".*[0-9].*");
        }

        return resultado;
    }

    public static boolean productoAdmiteTallaERP(ProductoERP producto) {
        String nombreNormalizado = "";
        boolean resultado = false;

        if (producto != null) {
            nombreNormalizado = producto.getNombreNormalizado();

            if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                nombreNormalizado = TextoUtil.normalizarTexto(producto.getNombre());
            }

            if (!productoTieneCalibre(producto)) {
                resultado = nombreContieneTipo(nombreNormalizado, ConstantesNormalizacion.TIPOS_ADMITEN_TALLA);
            }
        }

        return resultado;
    }

    public static boolean productoAdmiteColorERP(ProductoERP producto) {
        String nombreNormalizado = "";
        boolean resultado = false;

        if (producto != null) {
            nombreNormalizado = producto.getNombreNormalizado();

            if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                nombreNormalizado = TextoUtil.normalizarTexto(producto.getNombre());
            }

            if (!productoTieneCalibre(producto)) {
                resultado = nombreContieneTipo(nombreNormalizado, ConstantesNormalizacion.TIPOS_ADMITEN_COLOR);
            }
        }

        return resultado;
    }

    public static boolean productoPuedeTenerCalibreERP(ProductoERP producto) {
        String nombreNormalizado = "";
        boolean resultado = false;

        if (producto != null) {
            nombreNormalizado = producto.getNombreNormalizado();

            if (nombreNormalizado == null || nombreNormalizado.trim().isEmpty()) {
                nombreNormalizado = TextoUtil.normalizarTexto(producto.getNombre());
            }

            resultado = nombreContieneTipo(nombreNormalizado, ConstantesNormalizacion.TIPOS_PUEDEN_TENER_CALIBRE);
        }

        return resultado;
    }

    private static boolean productoTieneCalibre(ProductoERP producto) {
        String calibre = "";
        boolean resultado = false;

        if (producto != null) {
            calibre = producto.getCalibre();

            if (calibre != null && !calibre.trim().isEmpty()) {
                resultado = true;
            }
        }

        return resultado;
    }

    private static boolean nombreContieneTipo(String nombreNormalizado, String[] tipos) {
        String nombre = "", tipo = "";
        boolean resultado = false;

        if (nombreNormalizado != null && tipos != null) {
            nombre = TextoUtil.normalizarTexto(nombreNormalizado);

            for (int i = 0; i < tipos.length && !resultado; i++) {
                tipo = TextoUtil.normalizarTexto(tipos[i]);

                if (TextoUtil.contienePalabraExacta(nombre, tipo)) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    public static void limpiarTallasInvalidasProductoERP(ArrayList<ProductoERP> listaProductosERP) {
        ProductoERP producto = null;

        String tallaActual = "";
        boolean tallaValida = false;

        if (listaProductosERP != null) {
            for (int i = 0; i < listaProductosERP.size(); i++) {
                producto = listaProductosERP.get(i);
                tallaActual = producto.getTalla();
                tallaValida = false;

                if (tallaActual != null && !tallaActual.trim().isEmpty()) {
                    tallaActual = TextoUtil.normalizarTexto(tallaActual);
                    tallaValida = esTallaValidaProductoERP(producto, tallaActual);

                    if (!tallaValida) {
                        producto.setTalla("");
                    } else {
                        producto.setTalla(tallaActual);
                    }
                }
            }
        }
    }

    private static boolean esTallaValidaProductoERP(ProductoERP producto, String talla) {
        boolean resultado = false;

        if (producto != null && talla != null && !talla.trim().isEmpty()) {
            if (productoAdmiteTallaERP(producto)) {
                resultado = esTallaRopaValida(talla) || esTallaNumericaValida(talla);
            }
        }

        return resultado;
    }

    private static boolean esTallaRopaValida(String talla) {
        boolean resultado = false;

        if (talla != null) {
            for (int i = 0; i < ConstantesNormalizacion.TALLAS_ROPA.length && !resultado; i++) {
                if (talla.equals(ConstantesNormalizacion.TALLAS_ROPA[i])) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    private static boolean esTallaNumericaValida(String talla) {
        boolean resultado = false;

        if (talla != null) {
            for (int i = 0; i < ConstantesNormalizacion.TALLAS_NUMERICAS.length && !resultado; i++) {
                if (talla.equals(ConstantesNormalizacion.TALLAS_NUMERICAS[i])) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }
}
