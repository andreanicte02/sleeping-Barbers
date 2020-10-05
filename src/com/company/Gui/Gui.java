package com.company.Gui;

import com.company.Utilidades.BarberShop;
import com.company.Utilidades.Client;
import com.company.Utilidades.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui extends JFrame {
    private JButton button1;
    private JButton button2;
    private JPanel root;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton agregarButton;
    private JButton ocupadoButton;
    BarberShop barberSop;
    Image imageBarber;
    Image imageClient;

    public Gui() throws IOException {

        this.add(root);
        this.setSize(800,600);

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

        this.barberSop = new BarberShop(button1);
        barberSop.start();

        this.ocupadoButton.setEnabled(false);
        this.ocupadoButton.setBackground(Color.white);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("creando al cliente no: " + Utils.n);
                textArea1.setText(textArea1.getText() + "creando al cliente no: " + Utils.n +";\n");
                Client client = new Client( barberSop, Utils.n, textArea1, textField1, button2,ocupadoButton);
                Utils.n++;
                client.start();
            }
        });
    }
}
