package com.svalero.carrera;

import javafx.concurrent.Worker;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {


    public ProgressBar pbCoche1, pbCoche2, pbCoche3;
    public Label lblCoche1, lblCoche2, lblCoche3, lblNombre1, lblNombre2, lblNombre3, lblDistancia, lblGanador;
    public TextField tfCoche1, tfCoche2, tfCoche3;
    public Button btnCorrer;

    private CocheTask coche1, coche2, coche3;
    private final int distanciaCircuito = 50;



    @FXML
    public void iniciarCarrera(Event event){
        int tfCoche1Value = Integer.parseInt(tfCoche1.getText());
        int tfCoche2Value = Integer.parseInt(tfCoche2.getText());
        int tfCoche3Value = Integer.parseInt(tfCoche3.getText());

        // Coche1
        coche1 = new CocheTask(tfCoche1Value, distanciaCircuito, "Seat");
        lblNombre1.setText(coche1.getNombre());
        coche1.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.RUNNING){
                pbCoche1.progressProperty().unbind();
                pbCoche1.progressProperty().bind(coche1.progressProperty());
            } else if (newState == Worker.State.SUCCEEDED){
                lblGanador.setText("Ha ganado " + coche1.getNombre());
                coche2.cancel();
                coche3.cancel();
            }
        });
        coche1.messageProperty().addListener((observableValue, oldState, newState) -> {
            lblCoche1.setText(newState);
        });

        // Coche2
        coche2 = new CocheTask(tfCoche2Value, distanciaCircuito, "Ford");
        lblNombre2.setText(coche2.getNombre());
        coche2.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.RUNNING){
                pbCoche2.progressProperty().unbind();
                pbCoche2.progressProperty().bind(coche2.progressProperty());
            } else if (newState == Worker.State.SUCCEEDED){
                lblGanador.setText("Ha ganado " + coche2.getNombre());
                coche1.cancel();
                coche3.cancel();
                lblGanador.setText("");

            }
        });
        coche2.messageProperty().addListener((observableValue, oldState, newState) -> {
            lblCoche2.setText(newState);
        });

        // Coche3
        coche3 = new CocheTask(tfCoche3Value, distanciaCircuito, "Ferrari");
        lblNombre3.setText(coche3.getNombre());
        coche3.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState == Worker.State.RUNNING){
                pbCoche3.progressProperty().unbind();
                pbCoche3.progressProperty().bind(coche3.progressProperty());
            } else if (newState == Worker.State.SUCCEEDED){
                lblGanador.setText("Ha ganado " + coche3.getNombre());
                coche1.cancel();
                coche2.cancel();
            }
        });
        coche3.messageProperty().addListener((observableValue, oldState, newState) -> {
            lblCoche3.setText(newState);
        });
        lblGanador.setText("");
        lblCoche1.setText("");
        lblCoche2.setText("");
        lblCoche3.setText("");
        new Thread(coche1).start();
        new Thread(coche2).start();
        new Thread(coche3).start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDistancia.setText(String.valueOf(distanciaCircuito));
    }
}
