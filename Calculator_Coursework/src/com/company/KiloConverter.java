package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiloConverter extends JFrame {
    JPanel panel;
    JLabel messageLabel;
    JTextField kiloTextField;
    JButton calcButton;

    public KiloConverter() {
        setTitle("Kilometer Converter");
        setSize(310, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }

    private void buildPanel() {
        messageLabel = new JLabel("Enter a distance " + "in kilometers");
        kiloTextField = new JTextField(10);
        calcButton = new JButton("Calculate");
        setIconImage(new ImageIcon("icon.png").getImage());
        calcButton.addActionListener(new CalcButtonListener());
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final double CONVERSION = 0.6214;
            String input;
            double miles;

            input = kiloTextField.getText();
            miles = Double.parseDouble(input) * CONVERSION;

            JOptionPane.showMessageDialog(null, input +
                    " kilometers is " + miles + " miles.");
        }

    }


}