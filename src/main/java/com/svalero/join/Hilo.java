package com.svalero.join;

public class Hilo extends Thread{

    private String nombre;

    public Hilo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++){
            System.out.println("Ejecuntado el hilo " + nombre);

            try{
                Thread.sleep(300);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Hilo " + nombre + " terminado");
    }
}
