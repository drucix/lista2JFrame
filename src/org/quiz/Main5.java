package org.quiz;

import org.backround.FrameSettings;

import javax.swing.*;

public class Main5 {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new QuizFrame();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
