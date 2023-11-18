/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.Hilos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JHON BENITEZ
 */
public class SimulacionCobroSupermercado {

    public static void main(String[] args) throws InterruptedException {

        {
            List<Cajera> cajeras = new ArrayList<>();
            List<Cliente> clientes = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);

                                                            // menu de opciones 
            System.out.print("Ingrese el número de cajeras: ");
            int numCajeras = scanner.nextInt();

            for (int i = 1; i <= numCajeras; i++) {
                System.out.print("Ingrese el nombre de la cajera " + i + ": ");
                String nombreCajera = scanner.next();

                System.out.print("Ingrese el número de productos para el cliente " + i + ": ");
                int numProductos = scanner.nextInt();

                List<Producto> productos = new ArrayList<>();
                for (int j = 1; j <= numProductos; j++) {
                    System.out.print("Ingrese el nombre del producto " + j + ": ");
                    String nombreProducto = scanner.next();

                    System.out.print("Ingrese el precio del producto " + j + ": ");
                    double precioProducto = scanner.nextDouble();

                    Producto producto = new Producto(nombreProducto, precioProducto);
                    productos.add(producto);
                }

                Cliente cliente = new Cliente("Cliente " + i, productos);
                clientes.add(cliente);

                Cajera cajera = new Cajera(nombreCajera, cliente);
                cajeras.add(cajera);
            }

            for (Cajera cajera : cajeras) {
                Thread hiloCajera = new Thread(cajera);
                hiloCajera.start();
            }

            for (Cliente cliente : clientes) {
                cliente.totalPrecio();
            }

            for (Cajera cajera : cajeras) {
                cajera.join();
            }

            double tiempoTotal = 0;
            for (Cajera cajera : cajeras) {
                tiempoTotal += cajera.getTiempoTotal();
            }

            System.out.println("Tiempo total de todas las compras: " + tiempoTotal + " milisegundos");
        }
    }
}
