/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hilos;

import java.util.List;

/**
 *
 * @author JHON BENITEZ
 */
class Cliente {

    private String nombre;
    private List<Producto> productos;

    public Cliente(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
// este sera el metodo que claculara el precio de los productos 
    public void totalPrecio() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        System.out.println("El costo total de los productos del cliente " + nombre + " es: " + total);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
