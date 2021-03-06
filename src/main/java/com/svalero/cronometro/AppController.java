package com.svalero.cronometro;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class AppController {

    public Label lblTiempo;
    public ProgressBar pbCronometro;
    public TextField tfTiempo;
    int segundos;
    private CronometroTask cronometroTask;

    @FXML
    public void iniciar(Event event){

        segundos = Integer.parseInt(tfTiempo.getText());
        cronometroTask = new CronometroTask(segundos);
        cronometroTask.stateProperty().addListener((observableValue, state, t1) -> {
            if (t1 == Worker.State.RUNNING){
                pbCronometro.progressProperty().unbind();
                pbCronometro.progressProperty().bind(cronometroTask.progressProperty());
            } else if (t1 == Worker.State.SUCCEEDED){
                lblTiempo.setText("FIN");
            }
        });
        cronometroTask.messageProperty().addListener((observableValue, s, t1) -> {
            lblTiempo.setText(t1);
        });
        new Thread(cronometroTask).start();
    }

    @FXML
    public void parar(Event event){
        if (cronometroTask.stateProperty().getValue() == Worker.State.RUNNING){
            cronometroTask.cancel();
            lblTiempo.setText("CANCELADA");
        }
    }
}
