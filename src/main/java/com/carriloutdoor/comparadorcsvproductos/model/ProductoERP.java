package com.carriloutdoor.comparadorcsvproductos.model;

import java.util.ArrayList;

/**
 * Producto
 * @author Gabriel Acaro Sánchez
 */
public class ProductoERP {
    // Atributos privados
    
    private String codigo;
    private String origenCsv;
    private String nombre;
    private String nombreProveedor;
    private String nombreNormalizado;
    private String codReferencia;
    private String ean;
    private String observaciones;
    private String marca;
    private String modelo;
    private String talla;
    private String calibre;
    private String color;
    private String codigoUnificado;
    
    // Constructores

    public ProductoERP() {
        codigo = "";
        origenCsv = "";
        nombre = "";
        nombreProveedor = "";
        nombreNormalizado = "";
        codReferencia = "";
        ean = "";
        observaciones = "";
        marca = "";
        modelo = "";
        talla = "";
        calibre = "";
        color = "";
        codigoUnificado = "";
    }

    public ProductoERP(String codigo, String origenCsv, String nombre, String nombreProveedor, String nombreNormalizado, String codReferencia,
            String ean, String observaciones, String marca, String modelo, String talla,String calibre, String color, String codigoUnificado) {
        this.codigo = codigo;
        this.origenCsv = origenCsv;
        this.nombre = nombre;
        this.nombreProveedor = nombreProveedor;
        this.nombreNormalizado = nombreNormalizado;
        this.codReferencia = codReferencia;
        this.ean = ean;
        this.observaciones = observaciones;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.calibre = calibre;
        this.color = color;
        this.codigoUnificado = codigoUnificado;
    }
    
    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigenCsv() {
        return origenCsv;
    }

    public void setOrigenCsv(String origenCsv) {
        this.origenCsv = origenCsv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreNormalizado() {
        return nombreNormalizado;
    }

    public void setNombreNormalizado(String nombreNormalizado) {
        this.nombreNormalizado = nombreNormalizado;
    }

    public String getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(String codReferencia) {
        this.codReferencia = codReferencia;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCodigoUnificado() {
        return codigoUnificado;
    }

    public void setCodigoUnificado(String codigoUnificado) {
        this.codigoUnificado = codigoUnificado;
    }

    // Otros metodos


    
    // ToString


    @Override
    public String toString() {
        return "ProductoERP{" +
                "codigo='" + codigo + '\'' +
                ", origenCsv='" + origenCsv + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                ", nombreNormalizado='" + nombreNormalizado + '\'' +
                ", codReferencia='" + codReferencia + '\'' +
                ", ean='" + ean + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", talla='" + talla + '\'' +
                ", calibre='" + calibre + '\'' +
                ", color='" + color + '\'' +
                ", codigoUnificado='" + codigoUnificado + '\'' +
                '}';
    }
}
