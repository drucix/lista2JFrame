package org.shopping;

import org.backround.FrameSettings;

import javax.swing.*;

public class Main4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingList();
            }
        });
    }
}
