/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado.dominio;
/**
 *
 * @author Marta_08
 */
public class Empleado {
    private int empleado_codigo;
    private String empleado_nombre;
    private String empleado_apellido;
    private String empleado_password;
    

    public Empleado(int empleado_codigo, String empleado_nombre, String empleado_apellido, String empleado_password) {
        this.empleado_codigo = empleado_codigo;
        this.empleado_nombre = empleado_nombre;
        this.empleado_apellido = empleado_apellido;
        this.empleado_password = empleado_password;
    }
    public Empleado(){
        this(0, null, null, null);
    }

    public int getEmpleado_codigo() {
        return empleado_codigo;
    }

    public void setEmpleado_codigo(int empleado_codigo) {
        this.empleado_codigo = empleado_codigo;
    }

    public String getEmpleado_nombre() {
        return empleado_nombre;
    }

    public void setEmpleado_nombre(String empleado_nombre) {
        this.empleado_nombre = empleado_nombre;
    }

    public String getEmpleado_apellido() {
        return empleado_apellido;
    }

    public void setEmpleado_apellido(String empleado_apellido) {
        this.empleado_apellido = empleado_apellido;
    }

    public String getEmpleado_password() {
        return empleado_password;
    }

    public void setEmpleado_password(String empleado_password) {
        this.empleado_password = empleado_password;
    }
    
    public String toString(){
     return  String.format("%d %s %s %s", getEmpleado_codigo(),getEmpleado_nombre(),getEmpleado_apellido(),getEmpleado_password());
    }
   
}
