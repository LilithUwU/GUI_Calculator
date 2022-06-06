package com.company;

import javax.swing.*;
import java.awt.*;

public class HelpOperators extends JFrame {
    JLabel addL, subL, muL, divL, eqL, cL, sinL, cosL, tanL, sqrtL, logL;

    public HelpOperators() {
        setTitle("Help");

        setIconImage(new ImageIcon("icon.png").getImage());
        setLayout(new FlowLayout());
        //initialize
        {
            addL = new JLabel("'+' addition");
            subL = new JLabel("'-' subtraction");
            muL = new JLabel("'*' multiplication");
            divL = new JLabel("'/'  division   ");
            eqL = new JLabel("'=' equals");
            cL = new JLabel("'C' clear    ");
            sinL = new JLabel("'sin' sinus   ");
            cosL = new JLabel("'cos' cosinus");
            tanL = new JLabel("'tan' tangens");
            sqrtL = new JLabel("'\u221A'" + " square root");
            logL = new JLabel("'log' logarithm");
        }
        setlabelDesigh();
        //add to panel
        {
            add(addL);
            add(subL);
            add(muL);
            add(divL);
            add(eqL);
            add(cL);
            add(sinL);
            add(cosL);
            add(tanL);
            add(sqrtL);
            add(logL);
        }
        setSize(200, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setlabelDesigh() {
        addL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        subL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        muL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        divL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        eqL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        cL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        sinL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        cosL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        tanL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        sqrtL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
        logL.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 24));
    }

}
