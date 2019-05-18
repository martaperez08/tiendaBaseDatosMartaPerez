/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.control;

import Empleado.control.GestionEmpleado;
import Empleado.dominio.Empleado;
import producto.control.GestionPedidos;
import tienda.vista.VistaTienda;
import util.Colors;

/**
 *
 * @author Marta_08
 */
public class GestionTienda {

    private static Empleado empleado;

    public static void start() {
        System.out.println("*******BIENVENIDO AL PROGRAMA TIENDAS BY MARTA*********");
        GestionEmpleado.sistemaGestionEmpleados();
        empleado = GestionEmpleado.empleadoActual();
        System.out.println(Colors.GREEN + "\nDATOS CORRECTOS !" + Colors.BLACK);
        System.out.println("\nHa inidicado sesion " + empleado.getEmpleado_nombre() + "\n");
        iniciarMenuPrincipal();

    }

    public static void iniciarMenuPrincipal() {

        switch (VistaTienda.menuPrincipal(empleado)) {
            case HACER_PEDIDO:
                GestionPedidos.menuHacerPedido();
                iniciarMenuPrincipal();
                break;
            case MODIFICAR_PRODUCTO:
                GestionPedidos.menuModificarProducto();
                iniciarMenuPrincipal();
                break;
            case CAMBIAR_PASSWORD:
                GestionEmpleado.cambiarPasswordEmpleado(empleado);
                iniciarMenuPrincipal();
                break;
            case CERRAR_SESION:
                System.out.println("\n\n\n");
                GestionTienda.start();
                break;
        }
    }
}
