package org.editor;

import org.backround.FrameSettings;

import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileEditor();
            }
        });
    }
}
