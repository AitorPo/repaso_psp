package com.svalero.join;

public class App {

    public static void main(String[]args){
        Hilo hilo = new Hilo("1");
        Hilo hilo2= new Hilo("2");
        Hilo hilo3 = new Hilo("3");
        Hilo hilo4 = new Hilo("4");

        hilo.start();
        try{
            hilo.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        hilo2.start();
        try{
            hilo2.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        hilo3.start();
        try{
            hilo3.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        hilo4.start();
        try{
            hilo4.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("Aplicación finalizada");
    }
}
