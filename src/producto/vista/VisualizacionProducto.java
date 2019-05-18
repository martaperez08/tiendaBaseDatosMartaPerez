/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto.vista;

import Empleado.control.GestionEmpleado;
import java.util.*;
import static producto.control.GestionPedidos.*;
import producto.control.MenuHacerPedido;
import producto.control.MenuModificarProducto;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import tienda.vista.VistaTienda;
import util.Colors;

/**
 *
 * @author Marta_08
 */
public class VisualizacionProducto {

    private static List<Producto> factura = new ArrayList<>();

    public static MenuModificarProducto menuModificarProducto() {

        int opcion;

        System.out.println("*****MENU MODIFICAR PRODUCTO*******\n" + "2.1 Modificar nombre de producto " + "\n" + "2.2 Modificar precio de producto " + "\n"
                + "2.3 Modificar código de producto " + "\n");
        opcion = opcionMenuModificarProducto();
        MenuModificarProducto menuModificarProducto = null;
        switch (opcion) {
            case 1:
                menuModificarProducto = MenuModificarProducto.MODIFICAR_NOMBRE_PRODUCTO;
                break;
            case 2:
                menuModificarProducto = MenuModificarProducto.MODIFICAR_PRECIO_PRODUCTO;
                break;
            case 3:
                menuModificarProducto = MenuModificarProducto.MODIFICAR_CODIGO_PRODUCTO;
                break;

        }
        return menuModificarProducto;

    }

    public static MenuHacerPedido menuHacerPedido() {
        int opcion;

        System.out.println("\n\n*****MENU HACER PEDIDO*******\n" + "1.1 Añadir producto a la cecsta " + "\n" + "1.2 Visualizar precio total de la cesta " + "\n"
                + "1.3 Imprimir factura " + "\n" + "1.4 Terminar pedido \n");
        opcion = opcionMenuHacerPedido();
        MenuHacerPedido menuHacerPedido = null;
        switch (opcion) {
            case 1:
                menuHacerPedido = MenuHacerPedido.ANYADIR_PRODUCTO;
                break;
            case 2:
                
                menuHacerPedido = MenuHacerPedido.VISUALIZAR_PRECIO_CESTA;
                break;
            case 3:
                menuHacerPedido = MenuHacerPedido.IMPRIMIR_FACTURA;
                break;
            case 4:
                menuHacerPedido = MenuHacerPedido.TERMINAR_PEDIDO;
                break;

        }
        return menuHacerPedido;
    }

}
