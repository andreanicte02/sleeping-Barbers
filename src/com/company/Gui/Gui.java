package com.company.Gui;

import com.company.Utilidades.BarberShop;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.IOException;

public class Gui extends JFrame {
    private JButton button1;
    private JButton button2;
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    BarberShop lcd;
    Image imageBarber;
    Image imageClient;

    public Gui() throws IOException {

        this.add(root);
        this.setSize(500,600);

        this.imageBarber = ImageIO.read(getClass().getResource("/com/company/Gui/imgbarber.png"));
        this.button1.setIcon(new ImageIcon(imageBarber));

        this.imageClient = ImageIO.read(getClass().getResource("/com/company/Gui/imgclient.png"));
        this.button2.setIcon(new ImageIcon(imageClient));

        this.button1.setText("");
        this.button1.setEnabled(false);
        this.button1.setBackground(Color.blue);

        this.button2.setText("");
        this.button2.setEnabled(false);
        this.button2.setBackground(Color.white);

        this.textField1.setEditable(false);

        this.lcd = new BarberShop(textArea1, textField1, button1,button2);
        lcd.start();

    }
}
