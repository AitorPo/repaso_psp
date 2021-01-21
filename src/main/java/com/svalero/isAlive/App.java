package com.svalero.isAlive;

import com.svalero.join.Hilo;

public class App {
    public static void main (String[] args){
        Hilo hilo = new Hilo("1");
        HiloAlive hiloAlive = new HiloAlive(hilo);

        hilo.start();
        hiloAlive.start();


    }
}
