/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personal;

import operaciones.Compra;
import java.util.ArrayList;
/**
 *
 * @author administrador
 */
public class Proveedor extends Individuo{
     private ArrayList<Compra> compras;

    public Proveedor(String nombreCompleto, String dni) {
        super(nombreCompleto, dni);
        compras = new ArrayList<>();
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void addCompra(Compra compra) {
        this.compras.add(compra);
    }

    @Override
    public String toString() {
        return "Proveedor{" + "NombreCompleto=" + getNombreCompleto() + " Dni=" + getDni() + " Compras=" + getCompras().toString() + '}';
    }
}
