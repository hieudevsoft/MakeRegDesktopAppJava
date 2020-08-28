package com.appmakecolorrgb.hieu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class App extends JFrame implements ChangeListener {
    private JLabel red, green, blue, preview;
    private JPanel color;
    private Container container;
    private JSlider jsRed, jsGreen, jsBlue;
    private JTextField tfRed, tfGreen, tfBlue;

    App() throws UnsupportedLookAndFeelException {
        initComponents();
        controlSlider();
    }

    private void initComponents() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Make Color RGB");
        this.setIconImage(new ImageIcon(getClass().getResource("art.png")).getImage());
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

        Font font = new Font("Time News Roman", Font.BOLD, 14);
        color = new JPanel();
        color.setBackground(Color.BLACK);
        color.setBounds(500, 60, 150, 150);
        container.add(color);

        preview = new JLabel("Color Preview");
        preview.setFont(font);
        preview.setBounds(525, 220, 150, 20);
        container.add(preview);

        red = new JLabel("Red: ");
        red.setFont(font);
        red.setBounds(30, 80, 50, 20);
        container.add(red);
        jsRed = new JSlider(0, 255, 0);
        jsRed.setBounds(90, 82, 280, 20);
        jsRed.setBackground(Color.white);
        jsRed.setFont(font);
        container.add(jsRed);
        tfRed = new JTextField("0");
        tfRed.setFont(font);
        tfRed.setBounds(400, 70, 50, 50);
        tfRed.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfRed);

        green = new JLabel("Green: ");
        green.setFont(font);
        green.setBounds(30, 150, 60, 20);
        container.add(green);
        jsGreen = new JSlider(0, 255, 0);
        jsGreen.setBounds(90, 152, 280, 20);
        jsGreen.setBackground(Color.white);
        jsGreen.setFont(font);
        container.add(jsGreen);
        tfGreen = new JTextField("0");
        tfGreen.setFont(font);
        tfGreen.setBounds(400, 135, 50, 50);
        tfGreen.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfGreen);

        blue = new JLabel("Blue: ");
        blue.setFont(font);
        blue.setBounds(30, 220, 60, 20);
        container.add(blue);
        jsBlue = new JSlider(0, 255, 0);
        jsBlue.setBounds(90, 222, 280, 20);
        jsBlue.setBackground(Color.white);
        jsBlue.setFont(font);
        container.add(jsBlue);
        tfBlue = new JTextField("0");
        tfBlue.setFont(font);
        tfBlue.setBounds(400, 200, 50, 50);
        tfBlue.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfBlue);
    }

    public void run() {
        this.setVisible(true);
    }

    private void controlSlider() {
        jsBlue.addChangeListener(this);
        jsGreen.addChangeListener(this);
        jsRed.addChangeListener(this);
        tfBlue.setEditable(false);
        tfRed.setEditable(false);
        tfGreen.setEditable(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int red = jsRed.getValue();
        int green = jsGreen.getValue();
        int blue = jsBlue.getValue();
        tfGreen.setText(String.valueOf(green));
        tfRed.setText(String.valueOf(red));
        tfBlue.setText(String.valueOf(blue));
        Color viewColor = new Color(red, green, blue);
        color.setBackground(viewColor);
        preview.setForeground(viewColor);
    }
}
