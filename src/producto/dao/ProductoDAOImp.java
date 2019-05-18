/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.dao;

import Empleado.control.GestionEmpleado;
import producto.control.GestionPedidos;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import producto.dominio.Producto;
import util.Colors;
/**
 *
 * @author Marta_08
 */
public class ProductoDAOImp implements ProductoDAO {

    private final String archivoProducto;
    private final String archivoFactura;

    public ProductoDAOImp() {
        this.archivoProducto = "Productos.txt";
        this.archivoFactura = "Factura.txt";
    }

    @Override
    public List<Producto> leerProducto() {
        List<Producto> productos = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.CHINA);
        Number numero;
        String lineDatos;
        try (BufferedReader archivo = Files.newBufferedReader(Paths.get(archivoProducto))) {
            while (archivo.readLine() != null) {
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineDatos);
                int codigo = numero.intValue();
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String nombre = lineDatos;
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                String descripcion = lineDatos;
                archivo.readLine();
                lineDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineDatos);
                double precio = numero.doubleValue();
                Producto pro = new Producto(codigo, nombre, descripcion, precio);
                productos.add(pro);
            }
        } catch (ParseException e) {
            System.out.println(Colors.RED+"Formato erroneo ficero"+Colors.BLACK);
        } catch (IOException ex) {
            System.out.println(Colors.RED+"Erro en archivo"+Colors.BLACK);
        }
        return productos;

    }

    @Override
    public void actualizarProducto(List<Producto> listProductos) {
        File fichero = new File(archivoProducto);
        fichero.delete();
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println(Colors.RED+"Erros en fichero"+Colors.BLACK);;
        }

        try (BufferedWriter salida = Files.newBufferedWriter(
                Paths.get(archivoProducto), StandardOpenOption.WRITE)) {
            for (Producto producto : listProductos) {
                salida.write("[producto]");
                salida.newLine();
                salida.write("[codigo]");
                salida.newLine();
                salida.write(String.valueOf(producto.getProducto_codigo()));
                salida.newLine();
                salida.write("[nombre]");
                salida.newLine();
                salida.write(producto.getProducto_nombre());
                salida.newLine();
                salida.write("[descripcion]");
                salida.newLine();
                salida.write(producto.getProducto_descripcion());
                salida.newLine();
                salida.write("[precio]");
                salida.newLine();
                salida.write(String.valueOf(producto.getPrec()));
                salida.newLine();
            }

        } catch (IOException ex) {
            System.out.println("No se ha podido escribir en el archivo");
        }
    }

    @Override
    public void escribirFactura(List<Producto> factura) {
        File fichero = new File(archivoFactura);
        fichero.delete();
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println(Colors.RED+"Erros en fichero"+Colors.BLACK);;
        }

        try (BufferedWriter salida = Files.newBufferedWriter(
                Paths.get(archivoFactura), StandardOpenOption.WRITE)) {
            salida.write("----------------------------------------");
            salida.newLine();
            for (Producto producto : factura) {
                salida.write("Codigo:   " + String.valueOf(producto.getProducto_codigo()));
                salida.newLine();
                salida.write("Nombre :  " + producto.getProducto_nombre());
                salida.newLine();
                salida.write(" Descripcion:  " + producto.getProducto_descripcion());
                salida.newLine();
                salida.write("Precio:  " + String.valueOf(producto.getPrec()));
                salida.newLine();
            }
            salida.write("----------------------------------------");
            salida.newLine();
             salida.write(GestionPedidos.PrecioTotal(factura));
             salida.newLine();
            salida.write("Atendio por: "+ GestionEmpleado.empleadoActual().getEmpleado_nombre());
            
        } catch (IOException ex) {
            System.out.println(Colors.RED+"No se ha podido escribir en el archivo"+ Colors.BLACK);
        }
    }
    }

    
   


