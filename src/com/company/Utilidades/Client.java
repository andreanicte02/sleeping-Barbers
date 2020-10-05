package com.company.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends Thread{

    Barber barber;
    BarberShop barberShop;
    int id;
    JTextArea console;
    JTextField led;
    JButton icon;
    JButton iconBusy;

    public Client(Barber barber, BarberShop barberShop, int id, JTextArea console, JTextField led, JButton icon, JButton iconBusy){
        this.barber = barber;
        this.barberShop = barberShop;
        this.id = id;
        this.console = console;
        this.led = led;
        this.icon = icon;
        this.iconBusy = iconBusy;

    }
    @Override
    public void run() {

        while (true) {

            try {


                if(!this.barber.isAsSleep){
                    System.out.println("ocupado");
                    iconBusy.setBackground(Color.red);
                    continue;
                }

                iconBusy.setBackground(Color.white);
                if(this.barber.isAsSleep){

                    this.barber.wakeup();
                    this.led.setText("atendiendo al c no. " + id);
                    this.barber.cutHair(icon);
                    this.led.setText("");
                    System.out.println("$cliente no. " + id +" ya fue atendido");
                    this.console.setText(console.getText().replace("creando al cliente no: " + id +";\n",""));
                    this.icon.setBackground(Color.white);
                    this.barber.sleep();
                    break;
                }


            }catch (InterruptedException e){
                System.err.println("se murio F");

            }

        }

    }




}
