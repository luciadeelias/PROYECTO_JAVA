/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import gestion.Vehiculo;
import personal.Cliente;
/**
 *
 * @author administrador
 */
public class Factura {
    private static int contadorFacturas = 0;
    private int id;
    private Venta venta;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Factura(Venta venta, Cliente cliente, Vehiculo vehiculo) {
        this.id = ++contadorFacturas;
        this.venta = new Venta(venta);
        this.cliente = new Cliente(cliente);
        this.vehiculo = new Vehiculo(vehiculo);
    }

    public int getId() {
        return id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", venta=" + venta +
                ", cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
