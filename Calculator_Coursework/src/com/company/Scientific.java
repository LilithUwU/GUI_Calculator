package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scientific extends Calculator implements ActionListener {
    JButton pow, sqrt, sin, cos, tan, log;
    JPanel sciP;
    GridLayout gridScOp;
    JPanel allOp;

    public Scientific() {
        super();
        sciP = new JPanel();
        pow = new JButton("x^y");
        sqrt = new JButton("\u221A");
        sin = new JButton("sin");
        cos = new JButton("cos");
        tan = new JButton("tan");
        log = new JButton("log");
        gridScOp = new GridLayout(6, 1, 6, 6);

        allOp = new JPanel();
        sciP.add(pow);
        sciP.add(sqrt);
        sciP.add(sin);
        sciP.add(cos);
        sciP.add(tan);
        sciP.add(log);

        pow.addActionListener(this);
        sqrt.addActionListener(this);
        sin.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        log.addActionListener(this);


        sciP.setLayout(gridScOp);

        allOp.add("West", opP);
        allOp.add("East", sciP);
        windowContent.add("East", allOp);
        setButtonDesign();
        setContentPane(windowContent);
        pack();
        setTitle("Scientific Calculator");
        setSize(400, 350);
    }

    private void setButtonDesign() {
        pow.setBackground(Color.lightGray);
        sqrt.setBackground(Color.lightGray);
        sin.setBackground(Color.lightGray);
        cos.setBackground(Color.lightGray);
        tan.setBackground(Color.lightGray);
        log.setBackground(Color.lightGray);
        bEquals.setPreferredSize(new Dimension(380, 40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!operator.equals(""))
                num2 = num2 + s;
            else
                num1 = num1 + s;
            // set the value of text
            textField.setText(num1 + operator + num2);
        } else if (s.charAt(0) == 'C') {
            // clear the one letter
            num1 = operator = num2 = "";
            // set the value of text
            textField.setText(num1 + operator + num2);
        } else if (s.charAt(0) == '=') {
            double answer = switch (operator) {
                case "+" -> (Double.parseDouble(num1) + Double.parseDouble(num2));
                case "-" -> (Double.parseDouble(num1) - Double.parseDouble(num2));
                case "/" -> (Double.parseDouble(num1) / Double.parseDouble(num2));
                case "x^y" -> Math.pow((Double.parseDouble(num1)), Double.parseDouble(num2));
                case "\u221A" -> Math.sqrt((Double.parseDouble(num1)));
                case "sin" -> Math.sin(Double.parseDouble(num1));
                case "cos" -> Math.cos(Double.parseDouble(num1));
                case "tan" -> Math.tan(Double.parseDouble(num1));
                case "log" -> Math.log(Double.parseDouble(num1));
                default -> (Double.parseDouble(num1) * Double.parseDouble(num2));
            };
            // set the value of text
            textField.setText(num1 + operator + num2 + "=" + answer);
            // convert it to string
            num1 = Double.toString(answer);
            operator = num2 = "";
        } else {
            // if there was no operand
            if (operator.equals("") || num2.equals(""))
                operator = s;
                // else evaluate
            else {
                double te = switch (operator) {
                    case "+" -> (Double.parseDouble(num1) + Double.parseDouble(num2));
                    case "-" -> (Double.parseDouble(num1) - Double.parseDouble(num2));
                    case "/" -> (Double.parseDouble(num1) / Double.parseDouble(num2));
                    case "x^y" -> Math.pow((Double.parseDouble(num1)), Double.parseDouble(num2));
                    case "\u221A" -> Math.sqrt((Double.parseDouble(num1)));
                    case "sin" -> Math.sin(Double.parseDouble(num1));
                    case "cos" -> Math.cos(Double.parseDouble(num1));
                    case "tan" -> Math.tan(Double.parseDouble(num1));
                    case "log" -> Math.log(Double.parseDouble(num1));
                    default -> (Double.parseDouble(num1) * Double.parseDouble(num2));
                };
                // store the value in 1st
                // convert it to string
                num1 = Double.toString(te);
                // place the operator
                operator = s;
                // make the operand blank
                num2 = "";
            }
            // set the value of text
            textField.setText(num1 + operator + num2);
        }
        if (s.toString().equals("Scientific"))
            new Scientific();
        if (s.toString().equals("KiloConverter"))  //not ready yet
            new KiloConverter();
        if (s.toString().equals("Standard"))
            new Calculator();
        if (s.toString().equals("Help opeartors"))
            new HelpOperators();
    }


}
