/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalleplanta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Azahara
 */
 
public class DetalleController implements Initializable {
   
private final static int TAMANIO_IMAGEN = 200;
    
@FXML
private TextField txtnombrecomun;
@FXML
private TextField txtnombrecientifico;
@FXML
private TextField txtdescripcion;
@FXML
private TextField txtlocalizacion;
@FXML
private TextField txtcolor;
@FXML
private ImageView imgresultado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    
    }

    public void setNombrecomun(String nombrecomun){
    txtnombrecomun.setText(nombrecomun);
   
    }
    public void setNombrecientifico (String nombrecientifico){
    txtnombrecientifico.setText(nombrecientifico);
    }
    public void setDescripcion(String descricion) {
        txtdescripcion.setText(descricion);
    }
    public void setLocalizacion(String localizacion) {
        txtlocalizacion.setText(localizacion);
    }
    public void setColor(String color) {
        txtcolor.setText(color);
    }
     public void setImagen(String imagen) {
        imgresultado.setImage(new Image("consulta/imagenes/" + imagen, TAMANIO_IMAGEN, TAMANIO_IMAGEN, false, false));
    }


}
