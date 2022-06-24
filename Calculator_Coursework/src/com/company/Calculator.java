package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    Scientific sciObj;
    JMenu menu;
    JMenu help;
    JMenuBar menuBar;

    JMenuItem standardCal,
            scientificCal,
            converter,
            helpOperators;
    JTextField textField;
    String num1,
            num2,
            operator;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
            bAddition, bSubtraction, bDivision, bMultiplication,
            bPoint, bEquals, bDelete;
    JPanel windowContent;
    JPanel numP;
    JPanel opP;
    JPanel equalPanel;
    GridLayout gridOperators;
    GridLayout gridNumbers;

    public Calculator() {
        num1 = operator = num2 = "";
        menu = new JMenu("Menu");
        help = new JMenu("Help");
        helpOperators = new JMenuItem("Help opeartors");
        scientificCal = new JMenuItem("Scientific");
        standardCal = new JMenuItem("Standard");
        converter = new JMenuItem("KiloConverter");
        menu.add(scientificCal);
        menu.add(standardCal);
        menu.add(converter);
        help.add(helpOperators);
        menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(help);
        setJMenuBar(menuBar);

        textField = new JTextField(18);
        textField.setPreferredSize(new Dimension(180, 40));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("SansSerif", Font.BOLD, 15));
        textField.setEditable(false);

        windowContent = new JPanel();

        numP = new JPanel();
        opP = new JPanel();
        equalPanel = new JPanel();
        //initialize
        {
            b0 = new JButton("0");
            b1 = new JButton("1");
            b2 = new JButton("2");
            b3 = new JButton("3");
            b4 = new JButton("4");
            b5 = new JButton("5");
            b6 = new JButton("6");
            b7 = new JButton("7");
            b8 = new JButton("8");
            b9 = new JButton("9");

            bEquals = new JButton("=");
            bAddition = new JButton("+");
            bSubtraction = new JButton("-");
            bDivision = new JButton("/");
            bMultiplication = new JButton("*");
            bDelete = new JButton("C");
            bPoint = new JButton(".");
        }
        gridNumbers = new GridLayout(4, 3, 6, 6);
        gridOperators = new GridLayout(4, 1, 6, 6);

//add icons to panels
        {
            numP.add(b1);
            numP.add(b2);
            numP.add(b3);
            numP.add(b4);
            numP.add(b5);
            numP.add(b6);
            numP.add(b7);
            numP.add(b8);
            numP.add(b9);
            numP.add(bPoint);
            numP.add(b0);
            numP.add(bDelete);

            opP.add(bAddition);
            opP.add(bSubtraction);
            opP.add(bMultiplication);
            opP.add(bDivision);
            equalPanel.add(bEquals);
        }

        //action listener adding
        {

            b0.addActionListener(this);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b7.addActionListener(this);
            b8.addActionListener(this);
            b9.addActionListener(this);

            bEquals.addActionListener(this);
            bAddition.addActionListener(this);
            bSubtraction.addActionListener(this);
            bDivision.addActionListener(this);
            bMultiplication.addActionListener(this);
            bDelete.addActionListener(this);
            bPoint.addActionListener(this);

            scientificCal.addActionListener(this);
            standardCal.addActionListener(this);
            converter.addActionListener(this);
            helpOperators.addActionListener(this);
        }

//add to pane
        numP.setLayout(gridNumbers);
        opP.setLayout(gridOperators);
        windowContent.setLayout(new BorderLayout());
        windowContent.add("North", textField);
        windowContent.add("Center", numP);
        windowContent.add("East", opP);
        windowContent.add("South", equalPanel);

        setButtonDesign();
        setContentPane(windowContent);
        pack();
        setTitle("Calculator");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("icon.png").getImage());
        setVisible(true);
    }

    private void setButtonDesign() {
        b0.setBackground(Color.lightGray);
        b1.setBackground(Color.lightGray);
        b2.setBackground(Color.lightGray);
        b3.setBackground(Color.lightGray);
        b4.setBackground(Color.lightGray);
        b5.setBackground(Color.lightGray);
        b6.setBackground(Color.lightGray);
        b7.setBackground(Color.lightGray);
        b8.setBackground(Color.lightGray);
        b9.setBackground(Color.lightGray);
        bAddition.setBackground(Color.lightGray);
        bSubtraction.setBackground(Color.lightGray);
        bDivision.setBackground(Color.lightGray);
        bMultiplication.setBackground(Color.lightGray);
        bPoint.setBackground(Color.lightGray);
        bEquals.setBackground(Color.lightGray);
        bDelete.setBackground(Color.lightGray);
        bEquals.setPreferredSize(new Dimension(250, 40));
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


