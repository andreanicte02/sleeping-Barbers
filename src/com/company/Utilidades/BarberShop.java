package com.company.Utilidades;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BarberShop extends Thread {

    Barber barber;
    List listClient = new ArrayList();
    JTextArea console;
    JTextField led;
    JButton iconBarber;
    JButton iconClient;

    public BarberShop(JTextArea console, JTextField led, JButton iconBarber, JButton iconClient){
        this.console = console;
        this.led = led;
        this.iconBarber = iconBarber;
        this.iconClient = iconClient;
        this.barber = new Barber(this, iconBarber);

    }


    @Override
    public void run() {
        barber.start();
        while (true){


            try {

                int n = (int) (Math.random() * (3000 - 2000)) + 2000;
                Thread.sleep(n);
                System.out.println("creando al cliente no: " + Utils.n);
                console.setText(console.getText() + "creando al cliente no: " + Utils.n +";\n");
                Client client = new Client(barber, this, Utils.n, console, led,iconClient);
                Utils.n++;
                client.start();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }


    }



    public void  startC(Client client){


    }



}