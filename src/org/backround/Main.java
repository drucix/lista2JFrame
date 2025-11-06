package org.backround;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FrameSettings();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
