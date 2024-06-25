/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.time.LocalDate;

/**
 *
 * @author administrador
 */
public abstract class Operacion {
    private double monto;
    private String detalle;
    private LocalDate fecha;

    public Operacion(double monto, String detalle, LocalDate fecha){
        this.monto = getMonto();
        this.detalle =getDetalle();
        this.fecha = getFecha();
    }

    protected Operacion() {
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
