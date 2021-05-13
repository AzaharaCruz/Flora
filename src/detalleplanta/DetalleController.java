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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Azahara
 */
 
public class DetalleController implements Initializable {
    
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
        // TODO
    }    
    
}
