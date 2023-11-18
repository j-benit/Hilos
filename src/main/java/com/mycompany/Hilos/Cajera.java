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

        // bucle que itera sobre los productos de la compra del cliente.
        for (int i = 0; i < cliente.getProductos().size(); i++) {
            this.procesarProducto(cliente.getProductos().get(i));
        }
    
        for (int i = 0; i < cliente.getProductos().size(); i++) {
            long startTime = System.currentTimeMillis();
            this.procesarProducto(cliente.getProductos().get(i));
            long endTime = System.currentTimeMillis();
            tiempoTotal += (endTime - startTime);
        }
    }
// método privado llamado "procesarProducto" que toma como parámetro un objeto "Producto". Simula el tiempo
    private void procesarProducto(Producto producto) {
        try {
            Thread.sleep(1000); // Simula el tiempo necesario para procesar un producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
