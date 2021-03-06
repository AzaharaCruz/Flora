/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta;

import conexion.Conexion;
import conexion.Planta;
import detalleplanta.DetalleController;
import flora.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private final static int TAMANIO_IMAGEN = 50;
    @FXML
    private TextField txtnombre;
    @FXML
    private Button btbuscar;

    
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
        alerta.setTitle("Informaci??n");
        alerta.setHeaderText(null);

        if (encuentroRegistro(txtnombre.getText())) {
            paneResultados.getChildren().remove(grid);
            paneResultados.setVisible(true);
            grid = new GridPane();
            grid.getColumnConstraints().add(new ColumnConstraints(150)); 
            grid.getColumnConstraints().add(new ColumnConstraints(200)); 
            grid.getColumnConstraints().add(new ColumnConstraints(100)); 
            grid.getColumnConstraints().add(new ColumnConstraints(100));       
            grid.getRowConstraints().add(new RowConstraints(100));

            String resultado = "Se han econtrado " + lPlantas.size() + " resutlados";

            //A??adir aqui las cabeceras
            Label nombreC = new Label("Nombre Com??n");
            grid.setRowIndex(nombreC, 0);
            grid.setColumnIndex(nombreC, 0);
            Label nombreCi = new Label("Nombre cient??fico");
            grid.setRowIndex(nombreCi, 0);
            grid.setColumnIndex(nombreCi, 1);

            Label imagenT = new Label("Imagen");
            grid.setRowIndex(imagenT, 0);
            grid.setColumnIndex(imagenT, 2);
            Label botonDetalle = new Label("");
            grid.setRowIndex(botonDetalle, 0);
            grid.setColumnIndex(botonDetalle, 3);
            grid.getChildren().addAll(nombreC, nombreCi, imagenT, botonDetalle);

            for (int i = 1, p = 0; p < lPlantas.size(); p++, i++) {
                Planta planta = lPlantas.get(p);

                resultado += planta.getNombre_cientifico();
                //Crear el grid
                Button button = new Button();

                Label nombreN = new Label(planta.getNombre_comun());
                grid.setRowIndex(nombreN, i);
                grid.setColumnIndex(nombreN, 0);

                Label nombreCN = new Label(planta.getNombre_cientifico());
                grid.setRowIndex(nombreCN, i);
                grid.setColumnIndex(nombreCN, 1);

                ImageView imagen = new ImageView(new Image("consulta/imagenes/" + planta.getImagen(), TAMANIO_IMAGEN, TAMANIO_IMAGEN, false, false));
                grid.setRowIndex(imagen, i);
                grid.setColumnIndex(imagen, 2);

                Button boton = new Button("Ver detalle");
                grid.setRowIndex(boton, i);
                grid.setColumnIndex(boton, 4);
                
                boton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        boton.setText("Clicked");
                        detallePlanta(planta.getNombre_comun(), planta.getNombre_cientifico(), planta.getDescripcion(), planta.getLocalizacion(), planta.getColor(), planta.getImagen());
                        
                    }
                });

                grid.getChildren().addAll(nombreN, nombreCN, imagen, boton);
            }
            paneResultados.getChildren().add(grid);
            alerta.setContentText(resultado);
            alerta.showAndWait();

        } else {
            alerta.setContentText("No hay registros con el nombre introducido.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void detallePlanta(String nombreComun, String nombreCientifico, String descripcion, String localizacion, String color, String imagen) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/detalleplanta/Detalle.fxml"));
            Parent root = loader.load();
            DetalleController controlador = loader.getController();
            controlador.setNombrecomun(nombreComun);
            controlador.setNombrecientifico(nombreCientifico);
            controlador.setDescripcion(descripcion);
            controlador.setLocalizacion(localizacion);
            controlador.setImagen(imagen);
            controlador.setColor(color);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Detalle de " + nombreCientifico);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean encuentroRegistro(String nombrePlanta) {
        Conexion conexion = new Conexion();
        lPlantas = conexion.buscarPlantas(nombrePlanta);
        if (lPlantas != null && lPlantas.size() > 0) {
            return true;
        }
        for (Planta planta : lPlantas) {
            System.out.println(planta.getNombre_cientifico());
            System.out.println(planta.getNombre_comun());
            System.out.println(planta.getLocalizacion());

        }
        return false;

    }

}
