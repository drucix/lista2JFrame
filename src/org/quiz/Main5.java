package org.quiz;

import org.backround.FrameSettings;

import javax.swing.*;

public class Main5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizFrame();
            }
        });
    }
}
