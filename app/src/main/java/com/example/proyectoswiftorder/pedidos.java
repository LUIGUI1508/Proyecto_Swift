package com.example.proyectoswiftorder;

public class pedidos {

    private String cliente;
    private String cedula;
    private String direccion;
    private String fecha;
    private String telefono;

    // Constructor vacío requerido por Firebase
    public pedidos() {
    }

    public pedidos(String cliente, String cedula, String direccion, String fecha, String telefono) {
        this.cliente = cliente;
        this.cedula = cedula;
        this.direccion = direccion;
        this.fecha = fecha;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
