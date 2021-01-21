package com.svalero.cuentaAtras;

import javafx.concurrent.Task;

public class CuentaAtrasTask extends Task<Integer> {
    private int segundos;

    public CuentaAtrasTask(int segundos){
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

        for (int i = segundos; i >= 0; i--){
            double progreso = (double) segundos / (double) i;

            Thread.sleep(1000);

            updateProgress(1, progreso);
            updateMessage("De un total de " + segundos + " quedan " + i);
        }

        updateProgress(0,0);
        updateMessage("Cuenta atrás finalizada");
        return null;
    }
}
