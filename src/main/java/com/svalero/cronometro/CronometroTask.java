package com.svalero.cronometro;

import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class CronometroTask extends Task<Void> {

    private int segundos;


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
    protected Void call() throws Exception {
        updateMessage("Creando cuenta...");

        for (int i = 0; i <= segundos; i ++){
            double progreso = (double) i / (double)segundos;
            Thread.sleep(1000);


            updateProgress(progreso,1);

            updateMessage(i + " del total de " + segundos + " segundos");

        }
        updateProgress(1,1);
        updateMessage("Cuenta finalizada");
        return null;
    }
}
