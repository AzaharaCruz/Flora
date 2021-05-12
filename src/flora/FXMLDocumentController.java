/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flora;

import conexion.Conexion;
import conexion.Usuario;
import consulta.ConsultaController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Azahara
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtusuario;
    @FXML
    private TextField txtcontrasenia;
    @FXML
    private Button btsesion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btsesion(ActionEvent event) {

        
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);

        String Usuario;
        String pass;

        if (esLoginCorrecto(txtusuario.getText(), txtcontrasenia.getText())) {

            //alerta.setContentText("Sesión iniciada correctamente");
                    try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/consulta/Consulta.fxml"));
         
            Parent root = loader.load();
            ConsultaController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Buscador de Flora");
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage mystage = (Stage) this.btsesion.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        } else {
            alerta.setContentText("Usuario o contraseña incorrectos");
            alerta.showAndWait();
        }
    }
    
    private boolean esLoginCorrecto(String usuario, String pass){
        Conexion conexion = new Conexion();
        Usuario usuarioRespuesta = conexion.login(usuario, pass);
        if(usuarioRespuesta != null) return true;
        return false;
    }
}

  

