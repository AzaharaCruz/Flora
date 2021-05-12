/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author Azahara
 */
public class Usuario {
    private String usuario;
    private String pass;
    private String nombre;
    private String apellidos;
    private String email;

    public Usuario(String usuario, String pass, String nombre, String apellidos, String email) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    public Usuario(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
