/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.control;

import util.Colors;
import Empleado.dao.EmpleadoDAOImp;
import Empleado.dominio.Empleado;
import Exceptions.*;
import java.util.*;

/**
 *
 * @author Marta_08
 */
public class GestionEmpleado  {

    private static int codigoEmple;
    private static String passEmple;

    public static void sistemaGestionEmpleados() {
        boolean EmpleadoExiste = false;
        do {
            try {
                EmpleadoExiste = obtenerDatosEmpleado();
            } catch (PasswordEmpleadoIncorrecto e) {
                System.out.println(Colors.RED + "Mensaje del error: " + e.getMessage());
                System.out.println("Codigo del error: " + e.getCodigoError() + Colors.BLACK);
            } catch (CodigoEmpleadoIncorrecto ex) {
                System.out.println(Colors.RED + "Mensaje del error: " + ex.getMessage());
                System.out.println("Codigo del error: " + ex.getCodigoError() + Colors.BLACK);
            }
        } while (EmpleadoExiste == false);

    }

    public static boolean obtenerDatosEmpleado() throws PasswordEmpleadoIncorrecto, CodigoEmpleadoIncorrecto {
        Scanner lector;
        boolean formatoOK = false;
        boolean EmpleadoExiste;
        do {
            lector = new Scanner(System.in);
            System.out.println("Introduzca el codigo de empleado: ");
            if (lector.hasNextInt()) {
                codigoEmple = lector.nextInt();
                formatoOK = true;
            } else {
                System.out.println(Colors.RED + "Formato Erroneo" + Colors.BLACK);
            }
        } while (formatoOK == false);
        System.out.println("Introduzca la contrasenya del empleado: ");
        passEmple = lector.next();
        EmpleadoExiste = informacionCorrecta();
        return EmpleadoExiste;
    }

    public static boolean informacionCorrecta() throws PasswordEmpleadoIncorrecto, CodigoEmpleadoIncorrecto {
        boolean EmpleadoOK = false;
        boolean codigoNoExist = false;
        boolean passwordWrong = false;

        List<Empleado> empleadoList = ControladorEmpleado.leerEmpleados();
        Iterator<Empleado> it = empleadoList.iterator();
        while (it.hasNext() && EmpleadoOK == false && passwordWrong == false) {
            codigoNoExist = false;
            passwordWrong = false;
            Empleado emple = it.next();
            if (emple.getEmpleado_codigo() == codigoEmple && emple.getEmpleado_password().equals(passEmple)) {
                EmpleadoOK = true;
            } else if (emple.getEmpleado_codigo() == codigoEmple && emple.getEmpleado_password().equals(passEmple) == false) {
                codigoNoExist = false;
                passwordWrong = true;
            } else if (emple.getEmpleado_codigo() != codigoEmple) {
                codigoNoExist = true;
            }
        }

        if (codigoNoExist) {
            throw new CodigoEmpleadoIncorrecto("Erro. Codigo Incorrecto", CodigoError.ERROR_CODIGO_EMPLEADO);
        }
        if (passwordWrong) {
            throw new PasswordEmpleadoIncorrecto("Error. Contrasenya  Incorrecta", CodigoError.ERROR_PASSWORD_EMPLEADO);
        }
        return EmpleadoOK;

    }

    public static Empleado empleadoActual() {
        List<Empleado> empleadoList = ControladorEmpleado.leerEmpleados();
        int posicion = 0;
        for (Empleado empleado : empleadoList) {
            if (empleado.getEmpleado_codigo() == codigoEmple && empleado.getEmpleado_password().equals(passEmple)) {
                posicion = empleadoList.indexOf(empleado);
            }
        }
        return empleadoList.get(posicion);
    }

    public static void cambiarPasswordEmpleado(Empleado emple) {
        Scanner lector = new Scanner(System.in);
        String nuevaPassword;
        System.out.println("Introduzca la nueva constrasenya : ");
        nuevaPassword = lector.next();
        EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp();
        List<Empleado> listEmpleados = ControladorEmpleado.leerEmpleados();
        for (Empleado listEmpleado : listEmpleados) {
            if (listEmpleado.getEmpleado_codigo() == codigoEmple && listEmpleado.getEmpleado_password().equals(passEmple)) {
                listEmpleado.setEmpleado_password(nuevaPassword);
            }

        }
        empleadoDAOImp.actualizarEmpleados(nuevaPassword, codigoEmple);
    }
}
