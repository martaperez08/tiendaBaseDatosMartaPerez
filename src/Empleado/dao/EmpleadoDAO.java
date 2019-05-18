/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.dao;

import Empleado.dominio.Empleado;
import java.util.List;

/**
 *
 * @author Marta_08
 */
public interface EmpleadoDAO {
    List<Empleado> leerEmpleado();
    void actualizarEmpleados(List<Empleado> listEmpleado);
    
    
}