package com.company.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

public class Barber  extends Thread{

    boolean isAsSleep = true;
    JButton icon;
    BarberShop barberShop;
    JButton iconClient;



    public Barber(BarberShop barberShop, JButton icon){
        this.barberShop = barberShop;
        this.icon = icon;

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

        icon.setBackground(Color.blue);
        System.out.println("se durmi");
        isAsSleep =true;
        wait();


    }

    public synchronized void wakeup(){
        System.out.println("se despeto");
        isAsSleep = false;
        notify();
    }

    public void cutHair(JButton iconClient) throws InterruptedException {


        icon.setBackground(Color.green);
        iconClient.setBackground(Color.green);
        int n = (int) (Math.random() * (8000 - 5000)) + 5000;
        System.out.println("....cortando el pelo");
        Thread.sleep(n);


    }




}
