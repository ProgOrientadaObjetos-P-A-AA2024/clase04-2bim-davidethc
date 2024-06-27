/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {
    public static void main(String[] args) {
        
      
Scanner scanner = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        
        System.out.println("Ingrese el número de arriendos:");
        int numeroArriendos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        for (int i = 0; i < numeroArriendos; i++) {
            System.out.println("Seleccione el tipo de arriendo:");
            System.out.println("1. Arriendo Local Comida");
            System.out.println("2. Arriendo Local Comercial");
            System.out.println("3. Arriendo Local Sesiones");
            int tipoArriendo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            System.out.println("Ingrese el nombre del arrendatario:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el valor base del arriendo:");
            double valorBase = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (tipoArriendo) {
                case 1:
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(nombre, valorBase);
                    System.out.println("Ingrese el IVA (en porcentaje):");
                    int iva = scanner.nextInt();
                    System.out.println("Ingrese el valor del agua (en $):");
                    double valorAgua = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la luz (en $):");
                    double valorLuz = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    arriendoComida.establecerIva(iva);
                    arriendoComida.establecerValorAgua(valorAgua);
                    arriendoComida.establecerValorLuz(valorLuz);
                    listaArriendos.add(arriendoComida);
                    break;
                case 2:
                    ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(nombre, valorBase);
                    System.out.println("Ingrese el valor adicional fijo (en $):");
                    double valorAdicionalFijo = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    arriendoComercial.establecerValorAdicionalFijo(valorAdicionalFijo);
                    listaArriendos.add(arriendoComercial);
                    break;
                case 3:
                    ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(nombre, valorBase);
                    System.out.println("Ingrese el valor de las sillas (en $):");
                    double valorSillas = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la amplificación (en $):");
                    double valorAmplificacion = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    arriendoSesiones.establecerValorSillas(valorSillas);
                    arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);
                    listaArriendos.add(arriendoSesiones);
                    break;
                default:
                    System.out.println("Tipo de arriendo no válido.");
                    i--; // Disminuir el contador para repetir la iteración
                    break;
            }
        }
        
        for (Arriendo arriendo : listaArriendos) {
            arriendo.establecerArriendoMensual();
        }
        
        CentroComercial centro = new CentroComercial("La Pradera", listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);
    }
}