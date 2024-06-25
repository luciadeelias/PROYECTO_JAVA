/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personal;

import operaciones.Venta;
import java.util.ArrayList;
/**
 *
 * @author administrador
 */
public class Cliente extends Individuo implements Comparable<Cliente> {
    private ArrayList<Venta> historialVentas;

    public Cliente(String nombreCompleto, String dni) {
        super(nombreCompleto, dni);
        historialVentas = new ArrayList<>();
    }

    public Cliente(Cliente c) {
        super(c.getNombreCompleto(), c.getDni());
        historialVentas = new ArrayList<>(c.getVentas());
    }

    @Override
    public String toString() {
        return "Cliente{" + "NombreCompleto=" + getNombreCompleto() + " Dni=" + getDni() + " Ventas=" + historialVentas.toString() + '}';
    }

    public void addVenta(Venta venta) {

        this.historialVentas.add(venta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return this.getDni().compareTo(other.getDni()) == 0;
    }

    public double getTotalVentas() {
        double total = 0;
        for (Venta venta : historialVentas) {
            total += venta.getMonto();
        }
        return total;
    }

    @Override
    public int compareTo(Cliente o) {
        double misVentas = this.getTotalVentas();
        double susVentas = o.getTotalVentas();
        return Double.compare(misVentas, susVentas);
    }

    public ArrayList<Venta> getVentas() {

        return this.historialVentas;
    }
}