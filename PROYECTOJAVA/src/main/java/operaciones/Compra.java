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
public class Compra extends Operacion{
    public Compra(double monto, String detalle, LocalDate fecha) {
        this.setMonto(monto);
        this.setDetalle(detalle);
        this.setFecha(fecha);
    }

    @Override
    public String toString() {
        return "Compra [monto=" + getMonto() + ", detalle=" + getDetalle() + ", fecha=" + getFecha() + "]";
    }
}
