package com.svalero;

import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CocheTask extends Task<Integer> {

    private int velocidad;
    private int distanciaCircuito;
    private int distanciaRecorrida;
    private String nombre;
    private ProgressBar pbCoche;
    private Label lblCoche;




    public CocheTask(int velocidad, int distanciaCircuito, int distanciaRecorrida,
                     Label lblCoche, ProgressBar pbCoche){
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
        this.distanciaRecorrida = 0;
        this.lblCoche = lblCoche;
        this.pbCoche = pbCoche;




    }

    public CocheTask(int velocidad, int distanciaCircuito, String nombre){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distanciaCircuito = distanciaCircuito;
        this.distanciaRecorrida = 0;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDistanciaCircuito() {
        return distanciaCircuito;
    }

    public void setDistanciaCircuito(int distanciaCircuito) {
        this.distanciaCircuito = distanciaCircuito;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    protected Integer call() throws Exception {
        while (distanciaRecorrida < distanciaCircuito){
            double progreso = (double)distanciaRecorrida / distanciaCircuito;

            Thread.sleep(1000);
            distanciaRecorrida += velocidad;

            //updateProgress(progreso,1);

            if (distanciaRecorrida > distanciaCircuito){
                distanciaRecorrida = distanciaCircuito;

            }
            updateProgress(progreso,1);

        }
        updateProgress(1,1);
        updateMessage("Carrera finalizada");


        return null;
    }
}
