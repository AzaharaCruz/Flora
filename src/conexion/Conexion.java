/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Azahara
 */
public class Conexion {

    public Connection conectar() {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/flora";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, "root", "root");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Error");
        }
        return conexion;
    }
    
    public ResultSet visualizar (String nombre) {
    Connection conexion = conectar ();
    ResultSet consulta = null;
    try{
        PreparedStatement ps = conexion.prepareStatement("select*from plantas where nombre like '*" + nombre + "*'");
         consulta = ps.executeQuery();
         //for por el resultset y crear lista de plantaas
    }catch(Exception e){
    System.out.println ("Error en la consulta");
    }
        return consulta;
    }
    
    public Usuario login (String usuario, String pass) {
    Connection conexion = conectar ();
    try{
        PreparedStatement ps = conexion.prepareStatement("select * from flora.usuarios where nombre = " + usuario + " and pass = "+pass+";");
        ResultSet consulta = ps.executeQuery();
        
         //for por el resultset y crear lista de plantaas
    }catch(Exception e){
    System.out.println ("Error en la consulta");
    }
        return new Usuario();
    }
    
}
