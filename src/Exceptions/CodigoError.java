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
public enum CodigoError {
    ERROR_CODIGO_EMPLEADO(111),
    ERROR_PASSWORD_EMPLEADO(222);
    
    private int codigoException;
    
    private CodigoError(int codigoEx){
     this.codigoException=codigoEx;
    }

    public int getCodigoException() {
        return codigoException;
    }
    
}