package com.svalero.cuentaAtras;

import javafx.concurrent.Worker;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class AppController {

    public Label lblTiempo;
    public ProgressBar pbCronometro;
    public TextField tfTiempo;
    int segundos;
    private CuentaAtrasTask cuentaAtrasTask;

    @FXML
    public void iniciar(Event event){
        segundos = Integer.parseInt(tfTiempo.getText());
        cuentaAtrasTask = new CuentaAtrasTask(segundos);
        cuentaAtrasTask.stateProperty().addListener((observableValue, state, t1) -> {
            if (t1 == Worker.State.RUNNING){
                pbCronometro.progressProperty().unbind();
                pbCronometro.progressProperty().bind(cuentaAtrasTask.progressProperty());
            } else if (t1 == Worker.State.SUCCEEDED){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("MENSAJE INFORMATIVO");
                alert.setContentText("CUENTA ATRÁS FINALIZADA");
                alert.show();
            }
        });
        cuentaAtrasTask.messageProperty().addListener((observableValue, s, t1) ->
                lblTiempo.setText(t1));
        new Thread(cuentaAtrasTask).start();
    }

    @FXML
    public void parar(Event event){
        if (cuentaAtrasTask.stateProperty().getValue() == Worker.State.RUNNING){
            cuentaAtrasTask.cancel();
            lblTiempo.setText("CANCELADA");
        }
    }
}
