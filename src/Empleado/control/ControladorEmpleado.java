/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.control;

import Empleado.dao.EmpleadoDAO;
import Empleado.dao.EmpleadoDAOImp;
import Empleado.dominio.Empleado;
import java.util.List;

/**
 *
 * @author Marta_08
 */
public class ControladorEmpleado {
     static public List<Empleado> leerEmpleados() {
        EmpleadoDAO edao = new EmpleadoDAOImp();
        return edao.leerEmpleado();
    }
}
