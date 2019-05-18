/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class ConexionBD {
    
 private static final String HOST;
    private static final String PORT;
    private static final String DATABASE;
    private static final String USER;
    private static final String PASSWORD;
    private static final String URL_PARAM;
    private static final String URL;

    static {
        //se ejecuta una vez dependiendo de las veces  que llamamos a la clase

        HOST = "localhost";
        PORT = "3306";
        DATABASE = "tienda";
        USER = "root";
        PASSWORD = "";
        URL_PARAM = "?serverTimezone=UTC";
        URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + URL_PARAM;
        cargarDriver();
    }

    public static Connection conectar() {
        Connection connection = null;
        try {
            // cremamos la conection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException ex) {
            System.out.println("No se puede conectar a la base de datos");
        }
        return connection;
        // en el sitio donde se hace la consulta dentra la reponsabilidad de cerrar la consulta
    }

    public static void cargarDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando driver, MYSQL");

        }

    }
}
