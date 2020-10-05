package com.company.Utilidades;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BarberShop extends Thread {

    public Barber getBarber() {
        return barber;
    }

    private Barber barber;
    List listClient = new ArrayList();
    JButton iconBarber;


    public BarberShop(JButton iconBarber){


        this.iconBarber = iconBarber;
        this.barber = new Barber(this, iconBarber);

    }


    @Override
    public void run() {
        barber.start();
        while (true);


    }



    public void  startC(Client client){


    }



}