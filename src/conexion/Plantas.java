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
public class Plantas {

    private String nombre_comun;
    private String descripcion;
    private String localizacion;
    private String nombre_cientifico;

    public Plantas(String nombre_comun, String descripcion, String localizacion, String nombre_cientifico) {
        this.nombre_comun = nombre_comun;
        this.descripcion = descripcion;
        this.localizacion = localizacion;
        this.nombre_cientifico = nombre_cientifico;
    }

    Plantas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
