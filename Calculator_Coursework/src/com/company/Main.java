package com.company;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        new Calculator();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
