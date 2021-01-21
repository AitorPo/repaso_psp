package com.svalero.isAlive;

import com.svalero.join.Hilo;

public class HiloAlive extends Thread{

    private Hilo hilo;

    public HiloAlive(Hilo hilo){
        this.hilo = hilo;
    }

    @Override
    public void run() {
        while (hilo.isAlive()){
            System.out.println("Soy el HiloAlive " + hilo.getNombre() + " y me ejecuto mientras el hilo "
                    + hilo.getNombre() + " siga su ejecución");
            try{
                Thread.sleep(300);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("HiloAlive " + hilo.getNombre() + " ha muerto");
    }
}
