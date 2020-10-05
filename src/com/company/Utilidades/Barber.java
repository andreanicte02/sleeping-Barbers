package com.company.Utilidades;

import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Barber  extends Thread{

    boolean isAsSleep = true;
    BarberShop barberShop;


    public Barber(BarberShop barberShop){
        this.barberShop = barberShop;

    }

    @Override
    public void run() {

        while (true){

            try {

                if(!isAsSleep){
                    sleep();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void sleep() throws InterruptedException {

        System.out.println("se durmi");
        isAsSleep =true;
        wait();


    }

    public synchronized void wakeup(){
        System.out.println("se despeto");
        isAsSleep = false;
        notify();
    }



}
