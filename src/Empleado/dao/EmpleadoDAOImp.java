/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.dao;

import Conexion.ConexionBD;
import Empleado.dominio.Empleado;
import java.io.*;
import java.nio.file.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import util.Colors;

/**
 *
 * @author Marta_08
 */
public class EmpleadoDAOImp implements EmpleadoDAO {

    private final String archivoEmpleados;

    public EmpleadoDAOImp() {
        this.archivoEmpleados = "Empleados.txt";
    }

    @Override
    public List<Empleado> leerEmpleado() {
        List<Empleado> empleadoList = new ArrayList<>();
        try {
            ConexionBD.cargarDriver();
            Connection connection = ConexionBD.conectar();
            ResultSet resultadoEmpleado;
            try (Statement sentencia = connection.createStatement()) {
                resultadoEmpleado = sentencia.executeQuery("select * FROM empleados  ");
                while (resultadoEmpleado.next()) {
                    int codigoEmpleado = resultadoEmpleado.getInt("e_codigo");
                    String nombreEmpleado = resultadoEmpleado.getString("e_nombre");
                    String apellidosEmpleado = resultadoEmpleado.getString("e_apellidos");
                    String passwordEmpleado = resultadoEmpleado.getString("e_password");
                    empleadoList.add(new Empleado(codigoEmpleado, nombreEmpleado, apellidosEmpleado, passwordEmpleado));
                }
            }
            resultadoEmpleado.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleadoList;
    }

    @Override
    public void actualizarEmpleados(String nuevaPassword, int codigoEmpleado) {
       try {
            ConexionBD.cargarDriver();
            Connection connection = ConexionBD.conectar();
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate("update empleados set e_password=" + "'"+nuevaPassword+"'"+ " where e_codigo=" + codigoEmpleado);
            connection.close();
            sentencia.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
