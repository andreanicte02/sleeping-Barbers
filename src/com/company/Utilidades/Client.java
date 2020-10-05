package com.company.Utilidades;

import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread{

    Barber barber;
    BarberShop barberShop;

    public Client(Barber barber, BarberShop barberShop){
        this.barber = barber;
        this.barberShop = barberShop;
    }
    @Override
    public void run() {

        while (true) {

            try {


                if(this.barber.isAsSleep){
                    this.barber.wakeup();
                    this.barberShop.cutHair();
                    this.barber.sleep();
                    return;
                }


            }catch (InterruptedException e){
                System.err.println("se murio F");

            }

        }

    }




}
