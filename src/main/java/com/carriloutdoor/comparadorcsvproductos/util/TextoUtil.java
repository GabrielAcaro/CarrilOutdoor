package com.carriloutdoor.comparadorcsvproductos.util;

/**
 * TextoUtil
 * @author Gabriel Acaro Sánchez
 */
public class TextoUtil {
    public static String[] obtenerPalabras(String texto) {
        String[] textoDividido = new String[0];

        texto = normalizarTexto(texto);

        if (!texto.isEmpty()) {
            textoDividido = texto.split(" ");
        }

        return textoDividido;
    }

    public static String normalizarTexto(String texto) {
        String resultado = "";

        if (texto != null) {
            resultado = texto;
            resultado = quitarAcentos(resultado);
            resultado = convertirMayusculas(resultado);
            resultado = limpiarCaracteresBasicos(resultado);
            resultado = limpiarEspacios(resultado);
        }

        return resultado;
    }

    public static String quitarAcentos(String texto) {
        if (texto == null) {
            texto = "";
        } else {
            // Replacements de minusculas
            texto = texto.replace("á", "a");
            texto = texto.replace("é", "e");
            texto = texto.replace("í", "i");
            texto = texto.replace("ó", "o");
            texto = texto.replace("ú", "u");
            texto = texto.replace("ü", "u");

            // Replacements de mayusculas
            texto = texto.replace("Á", "A");
            texto = texto.replace("É", "E");
            texto = texto.replace("Í", "I");
            texto = texto.replace("Ó", "O");
            texto = texto.replace("Ú", "U");
            texto = texto.replace("Ü", "U");
        }

        return texto;
    }

    public static String convertirMayusculas(String texto) {
        String resultado = "";

        resultado = texto.toUpperCase();

        return resultado;
    }

    public static String limpiarEspacios(String texto) {
        String resultado = "";

        if (texto == null) {
            texto = "";
        } else {
            resultado = texto.trim();
            resultado = resultado.replaceAll("\\s+", " ");
        }

        return resultado;
    }

    public static String limpiarCaracteresBasicos(String texto) {
        String resultado = "";

        if (texto == null) {
            texto = "";
        }else {
            resultado = texto.replace("("," ");
            resultado = resultado.replace(")"," ");
            resultado = resultado.replace("["," ");
            resultado = resultado.replace("]"," ");
            resultado = resultado.replace("{"," ");
            resultado = resultado.replace("}"," ");
            resultado = resultado.replace("\""," ");
            resultado = limpiarEspacios(resultado);
        }

        return resultado;
    }

    public static boolean contienePalabraExacta(String texto, String palabra) {
        String textoNormalizado = "", palabraNormalizada = "";
        boolean resultado = false;

        if (texto != null && palabra != null) {
            textoNormalizado = " " + normalizarTexto(texto) + " ";
            palabraNormalizada = " " + normalizarTexto(palabra) + " ";

            resultado = textoNormalizado.contains(palabraNormalizada);
        }

        return resultado;
    }
}
