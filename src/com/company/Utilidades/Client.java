package com.company.Utilidades;

import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread{

    Barber barber;
    BarberShop barberShop;
    int id;
    JTextArea console;
    JTextField led;

    public Client(Barber barber, BarberShop barberShop, int id, JTextArea console, JTextField led){
        this.barber = barber;
        this.barberShop = barberShop;
        this.id = id;
        this.console = console;
        this.led = led;
    }
    @Override
    public void run() {

        while (true) {

            try {


                if(this.barber.isAsSleep){

                    this.barber.wakeup();
                    this.led.setText("atendiendo al c no. " + id);
                    this.barber.cutHair();
                    this.led.setText("");
                    System.out.println("$cliente no. " + id +" ya fue atendido");
                    this.console.setText(console.getText().replace("creando al cliente no: " + id +";\n",""));
                    this.barber.sleep();
                    return;
                }


            }catch (InterruptedException e){
                System.err.println("se murio F");

            }

        }

    }




}
