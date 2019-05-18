/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Marta_08
 */
public class CodigoEmpleadoIncorrecto extends RuntimeException {

    
     private  int codigoError;
     
    public CodigoEmpleadoIncorrecto(String mensaje, CodigoError codigoError) {
        super(mensaje);
        this.codigoError=codigoError.getCodigoException();
    }

    
    public CodigoEmpleadoIncorrecto(String msg) {
        super(msg);
    }

    public int getCodigoError() {
        return codigoError;
    }
    
}
