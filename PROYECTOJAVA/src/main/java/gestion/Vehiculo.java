/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

/**
 *
 * @author administrador
 */
public class Vehiculo {
    private String modelo;
    private String matricula;
    private float precio;
    private int cantidad;
    private ColorVehiculo color;

    public Vehiculo(String modelo, String matricula, float precio, ColorVehiculo color) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
        this.cantidad = 0;
        this.color = color;
    }

    public Vehiculo(Vehiculo v) {
        this.modelo = v.getModelo();
        this.matricula = v.getMatricula();
        this.precio = v.getPrecio();
        this.cantidad = v.getCantidad();
        this.color = v.getColor();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ColorVehiculo getColor() {
        return color;
    }

    public void setColor(ColorVehiculo color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", matricula=" + matricula + ", cantidad=" + cantidad + ", precio=" + precio + ", color=" + color + '}';
    }
}