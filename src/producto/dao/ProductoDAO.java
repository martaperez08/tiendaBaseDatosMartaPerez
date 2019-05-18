/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.dao;

import java.util.List;
import producto.dominio.Producto;

/**
 *
 * @author Marta_08
 */
public interface ProductoDAO {
     List<Producto> leerProducto();
     void actualizarProducto(List<Producto> listProductos);
     void escribirFactura(List<Producto> factura);
    
}

