/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta;

import conexion.Conexion;
import conexion.Planta;
import flora.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azahara
 */
public class ConsultaController implements Initializable {

    private final static int TAMANIO_IMAGEN = 25;
    @FXML
    private TextField txtnombre;
    @FXML
    private Button btbuscar;
//    @FXML
//    private Label nombre;
//    @FXML
//    private Label nombrec;
//    @FXML
//    private Label color;
//    @FXML
//    private Label localizacion;
//    @FXML
//    private ImageView img;
    
    @FXML
    private GridPane grid;
    
    @FXML 
    private Pane paneResultados;
   private List<Planta> lPlantas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/flora/FXMLDocument.fxml"));
            Parent root = loader.load();
            FXMLDocumentController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Buscador de Flora");
            stage.show();
            
            Stage mystage = (Stage) this.btbuscar.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btbuscar(ActionEvent event) {

        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);

        String Usuario;
        String pass;

        if (encuentroRegistro( txtnombre.getText())) {
            paneResultados.getChildren().remove(grid);
            paneResultados.setVisible(true);
            grid =new GridPane();
            grid.getColumnConstraints().add(new ColumnConstraints(150)); // column 0 is 100 wide
            grid.getColumnConstraints().add(new ColumnConstraints(200)); // column 1 is 200 wide
            grid.getColumnConstraints().add(new ColumnConstraints(2000)); // column 2 is 100 wide
            grid.getColumnConstraints().add(new ColumnConstraints(200)); // column 3 is 200 wide       
            grid.getColumnConstraints().add(new ColumnConstraints(200)); // column 4 is 200 wide
            grid.getRowConstraints().add(new RowConstraints (100));
                    
            //alerta.setContentText("Sesión iniciada correctamente");
//                    try {
            
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/consulta/Consulta.fxml"));
//         
//            Parent root = loader.load();
//            ConsultaController controlador = loader.getController();
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setTitle("Buscador de Flora");
//            stage.show();a
            String resultado = "Se han econtrado " + lPlantas.size() + " resutlados";
            
            //Añadir aqui las cabeceras
            Label nombreLabel = new Label("Nombre Común");
            grid.setRowIndex(nombreLabel, 0);
            grid.setColumnIndex(nombreLabel, 0);
            Label nombreLabel2 = new Label("Nombre científico");
            grid.setRowIndex(nombreLabel2, 0);
            grid.setColumnIndex(nombreLabel2, 1);
            Label nombreLabel3 = new Label("Descripción");
            grid.setRowIndex(nombreLabel3, 0);
            grid.setColumnIndex(nombreLabel3, 2);
            Label nombreLabel4 = new Label("Imagen");
            grid.setRowIndex(nombreLabel4, 0);
            grid.setColumnIndex(nombreLabel4, 3);
            Label nombreLabel5 = new Label("Localización");
            grid.setRowIndex(nombreLabel5, 0);
            grid.setColumnIndex(nombreLabel5, 4);
            grid.getChildren().addAll(nombreLabel, nombreLabel2, nombreLabel3, nombreLabel4, nombreLabel5);

            
            for(int i = 1, p = 0; p<lPlantas.size(); p++, i++){
                Planta planta = lPlantas.get(p);
                
                resultado +=planta.getNombre_cientifico();
//                img.setImage(new Image("consulta/imagenes/"+planta.getImagen(), TAMANIO_IMAGEN, TAMANIO_IMAGEN, false, false));
//                nombre.setText(planta.getNombre_comun());
//                nombrec.setText(planta.getNombre_cientifico());
//                color.setText(planta.getColor());
//                localizacion.setText(planta.getLocalizacion());
                
                //Crear el grid
                 Button button = new Button();
                 
                 Label nombreN = new Label(planta.getNombre_comun());
                grid.setRowIndex(nombreN, i);
                grid.setColumnIndex(nombreN, 0);
                
                Label nombreCN = new Label(planta.getNombre_cientifico());
                grid.setRowIndex(nombreCN, i);
                grid.setColumnIndex(nombreCN, 1);
                
                Label colorN = new Label(planta.getDescripcion());
                grid.setRowIndex(colorN, i);
                grid.setColumnIndex(colorN, 2);
                
                 ImageView imagen = new ImageView(new Image("consulta/imagenes/"+planta.getImagen(), TAMANIO_IMAGEN, TAMANIO_IMAGEN, false, false));
                grid.setRowIndex(imagen, i);
                grid.setColumnIndex(imagen, 3);
                
                Label lozalizacionN = new Label(planta.getLocalizacion());
                grid.setRowIndex(lozalizacionN, i);
                grid.setColumnIndex(lozalizacionN, 4);
                
                grid.getChildren().addAll(nombreN, nombreCN, colorN, imagen, lozalizacionN);
            }
            paneResultados.getChildren().add(grid);
            alerta.setContentText(resultado);
            alerta.showAndWait();
            //stage.setOnCloseRequest(e -> controlador.closeWindows());
            //Stage mystage = (Stage) this.btsesion.getScene().getWindow();
            //mystage.close();

//        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        } else {
            alerta.setContentText("No hay registros con el nombre introducido.");
            alerta.showAndWait();
        }
    }
     private boolean encuentroRegistro(String nombrePlanta){
        Conexion conexion = new Conexion();
        lPlantas = conexion.buscarPlantas(nombrePlanta);
        if(lPlantas != null && lPlantas.size() > 0) return true;
        for(Planta planta: lPlantas){
            System.out.println(planta.getNombre_cientifico());
            System.out.println(planta.getNombre_comun());
            System.out.println(planta.getLocalizacion());
      
        }
        return false;
    
    }
    
}
