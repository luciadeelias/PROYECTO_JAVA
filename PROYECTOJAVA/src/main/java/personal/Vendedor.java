/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personal;

import java.time.LocalDate;
/**
 *
 * @author administrador
 */
public class Vendedor extends Individuo{
     private int numVentas;
    private LocalDate fechaContrato;

    public Vendedor(String nombreCompleto, String dni, LocalDate fechaContrato) {
        super(nombreCompleto, dni);
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "NombreCompleto=" + getNombreCompleto() + " Dni=" + getDni() + " Ventas=" + getNumVentas() + " FechaContrato=" + getFechaContrato() + '}';
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

    public void addVentas(int numVentas) {
        this.numVentas += numVentas;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
}
