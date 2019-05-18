/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.dominio;




/**
 *
 * @author Marta_08
 */
public class Producto {

    private int producto_codigo;
    private String producto_nombre;
    private String producto_descripcion;
    private double producto_precio;
    

    public Producto(int producto_codigo, String producto_nombre, String producto_descripcion, double precio) {
        this.producto_codigo = producto_codigo;
        this.producto_nombre = producto_nombre;
        this.producto_descripcion = producto_descripcion;
        this.producto_precio = precio;
        
    }

    public Producto() {
        this(0, null, null, 0.0);
    }

    public int getProducto_codigo() {
        return producto_codigo;
    }

    public void setProducto_codigo(int producto_codigo) {
        this.producto_codigo = producto_codigo;
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    public String getProducto_descripcion() {
        return producto_descripcion;
    }

    public void setProducto_descripcion(String producto_descripcion) {
        this.producto_descripcion = producto_descripcion;
    }

    public double getPrec() {
        return producto_precio;
    }

    public void setPrec(double precio) {
        this.producto_precio = precio;
    }

   
    public String toString(){
    return  String.format("Codigo_Producto: %d       Nombre_Producto: %s       Descripcion_Producto: %s       Precio_Producto: %.2f",
            getProducto_codigo(),getProducto_nombre(),getProducto_descripcion(),getPrec());
            
    }
}
