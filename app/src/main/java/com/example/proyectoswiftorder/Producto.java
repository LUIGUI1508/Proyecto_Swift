package com.example.proyectoswiftorder;

public class Producto {
    private String nombreProducto;
    private String presentacion;
    private String precio;
    private String descripcion;

    public Producto() {
        // Constructor vacío necesario para Firebase
    }

    public Producto(String nombreProducto, String presentacion, String precio, String descripcion) {
        this.nombreProducto = nombreProducto;
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getter y Setter para nombreProducto
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    // Getter y Setter para presentacion
    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    // Getter y Setter para precio
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    // Getter y Setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
