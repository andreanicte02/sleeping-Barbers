package com.company.Utilidades;

import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Barber  extends Thread{

    boolean isAsSleep = true;
    JButton icon;
    BarberShop barberShop;



    public Barber(BarberShop barberShop, JButton icon){
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

    public synchronized void cutHair() throws InterruptedException {


        int n = (int) (Math.random() * (8000 - 5000)) + 5000;
        System.out.println("....cortando el pelo");
        Thread.sleep(n);


    }



}
