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
public class Planta {

    private String nombre_comun;
    private String descripcion;
    private String localizacion;
    private String nombre_cientifico;
    private String color;
    private String imagen;

    
      public Planta(String nombre_comun, String descripcion, String localizacion, String nombre_cientifico, String color, String imagen) {
        this.nombre_comun = nombre_comun;
        this.descripcion = descripcion;
        this.localizacion = localizacion;
        this.nombre_cientifico = nombre_cientifico;
        this.color = color;
        this.imagen = imagen;
               
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
  

    Planta() {
    }

    public String getNombre_comun() {
        return nombre_comun;
    }

    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }
    


}
