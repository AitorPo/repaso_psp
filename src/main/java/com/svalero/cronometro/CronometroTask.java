package com.svalero.cronometro;

import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class CronometroTask extends Task<Integer> {

    private int segundos;
    public Label lblTiempo;
    public ProgressBar pbCronometro;
    public TextField tfTiempo;

    public CronometroTask(int segundos){
        this.segundos = segundos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    protected Integer call() throws Exception {

        for (int i = 0; i < segundos; i ++){
            double progreso = (double)i / (double)segundos;
            Thread.sleep(1000);
            progreso += segundos;

            updateProgress(progreso,1);

        }
        updateProgress(1,1);
        updateMessage("Carrera finalizada");
        return null;
    }
}
