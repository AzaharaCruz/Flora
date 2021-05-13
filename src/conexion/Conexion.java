/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azahara
 */
public class Conexion {

    public Connection conectar() {
        Connection conexion = null;
        String url = "jdbc:mysql://localhost/flora";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, "root", "root");
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
   /* public ResultSet visualizar (String nombre) {
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
    }*/
    
    public Usuario login (String usuario, String pass) {
    Connection conexion = conectar ();
    Usuario usuario1 = null;
    try{
        String select = "select * from flora.usuarios where nombre = '" + usuario + "' and pass = '"+pass+"'";
        System.out.println("select:"+select);
        PreparedStatement ps = conexion.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        System.out.println("conexion.Conexion.login()");
        
         while(rs.next()){
                       System.out.println("*****************************************");
                       System.out.println("El usuario es: "+rs.getString(1));
                       System.out.println("La contraseña es: "+rs.getString(2));
                       System.out.println("El nombre es: "+rs.getString(3));
                       System.out.println("Los apellidos son: "+rs.getString(4));
                       System.out.println("El email es: "+rs.getString(5));
                       usuario1 = new Usuario();
                       usuario1.setUsuario(rs.getString(1));
                       usuario1.setPass(rs.getString(2));
                       usuario1.setNombre(rs.getString(3));
                       usuario1.setApellidos(rs.getString(4));
                       usuario1.setEmail(rs.getString(5));
                   }
         //for por el resultset y crear lista de plantaas
    }catch(Exception e){
    System.out.println ("Error en la consulta");
    }
        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario1;
    }
    
    public List<Planta> buscarPlantas (String nombrePlanta) {
    List<Planta> lPlantas = new ArrayList<Planta>();
    Connection conexion = conectar ();
    
    try {
        String select = "select * from flora.plantas where nombre_cientifico like '%" + nombrePlanta + "%' or nombre_comun like '%"+nombrePlanta+"%' ORDER BY nombre_cientifico LIMIT 15";
        System.out.println("select:"+select);
        PreparedStatement ps = conexion.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        System.out.println("conexion.Conexion.String()");
        
         while(rs.next()){
                       System.out.println("*****************************************");
                       System.out.println("El nombre comun es: "+rs.getString(1));
                       System.out.println("La descripcion es: "+rs.getString(2));
                       System.out.println("La localización es: "+rs.getString(3));
                       System.out.println("El color es: "+rs.getString(4));
                       System.out.println("El nombre cientifico es: "+rs.getString(5));
                       System.out.println("La imagen es "+rs.getString(6));

                       Planta planta1 = new Planta();
                       planta1.setNombre_comun(rs.getString(1));
                       planta1.setDescripcion(rs.getString(2));
                       planta1.setLocalizacion(rs.getString(3));
                       planta1.setColor(rs.getString(4));
                       
                       planta1.setNombre_cientifico(rs.getString(5));
                       planta1.setImagen(rs.getString(6));
                       lPlantas.add(planta1);
                                      
                   }
         //for por el resultset y crear lista de plantaas
    }catch(Exception e){
    System.out.println ("Error en la consulta" + e.getLocalizedMessage());
    }
        return lPlantas;
 
    }
    
}

