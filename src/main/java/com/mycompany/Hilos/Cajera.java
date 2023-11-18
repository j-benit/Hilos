/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Hilos;

/**
 *
 * @author JHON BENITEZ
 */
class Cajera extends Thread {

    private String nombre;
    private Cliente cliente;
    private double tiempoTotal;

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("La cajera " + this.nombre + " comienza a procesar la compra del cliente " + cliente.getNombre());
        for (int i = 0; i < cliente.getProductos().size(); i++) {
            this.procesarProducto(cliente.getProductos().get(i));
        }
        System.out.println("La cajera " + this.nombre + " ha terminado de procesar la compra del cliente " + cliente.getNombre());

        for (int i = 0; i < cliente.getProductos().size(); i++) {
            long startTime = System.currentTimeMillis();
            this.procesarProducto(cliente.getProductos().get(i));
            long endTime = System.currentTimeMillis();
            tiempoTotal += (endTime - startTime);
        }
    }

    private void procesarProducto(Producto producto) {
        try {
            Thread.sleep(1000); // Simula el tiempo necesario para procesar un producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("La cajera " + this.nombre + " ha procesado el producto " + producto.getNombre());
    }
}
