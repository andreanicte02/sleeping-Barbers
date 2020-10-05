package com.company.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BarberShop extends Thread {

    Barber barber = new Barber(this);


    @Override
    public void run() {
        barber.start();
        while (true){


            try {

                int n = (int) (Math.random() * (2000 - 1000)) + 1000;
                Thread.sleep(n);
                System.out.println("se creo un nuevo cliente");
                Client client = new Client(barber, this);
                client.start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }


    }

    public synchronized void cutHair() throws InterruptedException {


        int n = (int) (Math.random() * (3000 - 500)) + 500;
        System.out.println("....cortando el pelo");
        Thread.sleep(n);


    }



}