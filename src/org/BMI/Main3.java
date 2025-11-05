package org.BMI;

import org.backround.FrameSettings;

import javax.swing.*;

public class Main3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}
