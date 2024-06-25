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
public class Venta extends Operacion{
    public Venta(double monto, String detalle, LocalDate fecha) {
        this.setMonto(monto);
        this.setDetalle(detalle);
        this.setFecha(fecha);
    }

    public Venta(Venta v) {
        this.setMonto(v.getMonto());
        this.setDetalle(v.getDetalle());
        this.setFecha(v.getFecha());
    }

    @Override
    public String toString() {
        return "Venta [monto=" + getMonto() + ", detalle=" + getDetalle() + ", fecha=" + getFecha() + "]";
    }
}
