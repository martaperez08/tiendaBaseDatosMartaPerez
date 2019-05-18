/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.dao;

import Conexion.ConexionBD;
import Empleado.control.GestionEmpleado;
import producto.control.GestionPedidos;
import java.io.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {

            ConexionBD.cargarDriver();
            Connection connection = ConexionBD.conectar();
            System.out.println("-----TABLA PRODUCTO -------");
            Statement sentenciaProducto = connection.createStatement();
            ResultSet resultadoProducto = sentenciaProducto.executeQuery("select * FROM productos");
            while (resultadoProducto.next()) {
                String nombreProducto = resultadoProducto.getString("p_nombre");
                String descripcionProducto = resultadoProducto.getString("p_descripcion");
                int codigoProducto = resultadoProducto.getInt("p_codigo");
                double precioProducto = resultadoProducto.getDouble("p_precio");
                Producto pro = new Producto(codigoProducto, nombreProducto, descripcionProducto, precioProducto);
                productos.add(pro);
            }

            sentenciaProducto.close();
            resultadoProducto.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
        return productos;

    }

    @Override
        public void actualizarNombreProducto(String nuevoNombre, int codigoProducto) {
        try {
            ConexionBD.cargarDriver();
            Connection connection = ConexionBD.conectar();
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate("update productos set p_nombre=" + "'"+nuevoNombre +"'"+ " where p_codigo=" + codigoProducto);
            connection.close();
            sentencia.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    @Override
    public void actualizarPrecioProducto(double nuevoPrecio, int codigoProducto) {
       try {
            ConexionBD.cargarDriver();
            Connection connection = ConexionBD.conectar();
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate("update productos set p_precio=" + nuevoPrecio + " where p_codigo=" + codigoProducto);
            sentencia.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
