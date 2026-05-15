package main.java.com.carriloutdoor.comparadorcsvproductos.model;

/**
 * ProductoPrestaShop
 * @author Gabriel Acaro Sánchez
 */
public class ProductoPrestaShop {
    
    // Atributos privados
    
    private int id;
    private int idCombinacion;
    private String nombre;
    private String nombreNormalizado;
    private String codReferencia;
    private String ean;
    private String atributos;
    private String marca;
    private String modelo;
    private String talla;
    private String color;
    private String codigoUnificado;
    
    // Constructores

    public ProductoPrestaShop() {
        id = 0;
        idCombinacion = 0;
        nombre = "";
        nombreNormalizado = "";
        codReferencia = "";
        ean = "";
        atributos = "";
        marca = "";
        modelo = "";
        talla = "";
        color = "";
        codigoUnificado = "";
    }

    public ProductoPrestaShop(int id, int idCombinacion, String nombre, String nombreNormalizado, String codReferencia,
            String ean, String atributos, String marca, String modelo, String talla, String color, String codigoUnificado) {
        this.id = id;
        this.idCombinacion = idCombinacion;
        this.nombre = nombre;
        this.nombreNormalizado = nombreNormalizado;
        this.codReferencia = codReferencia;
        this.ean = ean;
        this.atributos = atributos;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.color = color;
        this.codigoUnificado = codigoUnificado;
    }
    
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCombinacion() {
        return idCombinacion;
    }

    public void setIdCombinacion(int idCombinacion) {
        this.idCombinacion = idCombinacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
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
        return "ProductoPrestaShop{" + "id=" + id + ", idCombinacion=" + idCombinacion + ", nombre=" + nombre 
                + ", nombreNormalizado=" + nombreNormalizado + ", codReferencia=" + codReferencia + ", ean=" + ean 
                + ", atributos=" + atributos + ", marca=" + marca + ", modelo=" + modelo + ", talla=" + talla 
                + ", color=" + color + ", codigoUnificado=" + codigoUnificado + '}';
    }
}
