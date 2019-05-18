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
public class PasswordEmpleadoIncorrecto extends RuntimeException {

    private  int codigoError;
    
    public PasswordEmpleadoIncorrecto(String msg) {
        super(msg);
    }
    
    public PasswordEmpleadoIncorrecto(String mesaje,CodigoError codigoError) {
        super(mesaje);
        this.codigoError=codigoError.getCodigoException();
    }

    public int getCodigoError() {
        return codigoError;
    }

  
    
}