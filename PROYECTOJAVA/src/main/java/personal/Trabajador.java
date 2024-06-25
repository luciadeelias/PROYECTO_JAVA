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
public class Trabajador extends Individuo{
    private LocalDate fechaContrato;
    private float salario;

    public Trabajador(String nombreCompleto, String dni, LocalDate fechaContrato, float salario) {
        super(nombreCompleto, dni);
        this.fechaContrato = fechaContrato;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "NombreCompleto=" + getNombreCompleto() + " Dni=" + getDni() + " FechaContrato=" + getFechaContrato()+" Salario=" + getSalario()  + "}";
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
