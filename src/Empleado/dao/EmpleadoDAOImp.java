/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.dao;

import Empleado.dominio.Empleado;
import java.io.*;
import java.nio.file.*;
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
        String lineaDatos;
        try (BufferedReader lector = Files.newBufferedReader(Paths.get(archivoEmpleados))) {
            while (lector.readLine() != null) {
                lector.readLine();
                lineaDatos = lector.readLine().trim();
                int codigoEmpleado = Integer.parseInt(lineaDatos);
                lector.readLine();
                lineaDatos = lector.readLine().trim();
                String nombreEmpleado = lineaDatos;
                lector.readLine();
                lineaDatos = lector.readLine().trim();
                String apellidosEmpleado = lineaDatos;
                lector.readLine();
                lineaDatos = lector.readLine().trim();
                String passwordEmpleado = lineaDatos;
                empleadoList.add(new Empleado(codigoEmpleado, nombreEmpleado, apellidosEmpleado, passwordEmpleado));
            }
        } catch (IOException ex) {
            System.out.println(Colors.RED+"Error archivo. " + Colors.BLACK);
            
        }
        return empleadoList;
    }

    @Override
    public void actualizarEmpleados(List<Empleado> listEmpleado) {
         File fichero = new File(archivoEmpleados);
        fichero.delete();
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            System.out.println(Colors.RED+"Erros en fichero"+Colors.BLACK);;
        }

        try (BufferedWriter salida = Files.newBufferedWriter(
                Paths.get(archivoEmpleados), StandardOpenOption.WRITE)) {
            for (Empleado empleado : listEmpleado) {

                salida.write("[empleado]");
                salida.newLine();
                salida.write("[codigo]");
                salida.newLine();
                salida.write(String.valueOf(empleado.getEmpleado_codigo()));
                salida.newLine();
                salida.write("[nombre]");
                salida.newLine();
                salida.write(empleado.getEmpleado_nombre());
                salida.newLine();
                salida.write("[apellidos]");
                salida.newLine();
                salida.write(empleado.getEmpleado_apellido());
                salida.newLine();
                salida.write("[contrasenya]");
                salida.newLine();
                salida.write(empleado.getEmpleado_password());
                salida.newLine();
            }

        } catch (IOException ex) {
            System.out.println(Colors.RED+"No se ha podido escribir en el archivo"+Colors.BLACK);
        }
    }
    

    
}
