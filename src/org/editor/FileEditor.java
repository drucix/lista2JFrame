package org.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; // Added for saving
import java.io.IOException; // Added for saving
import java.util.Scanner;

public class FileEditor extends JFrame implements ActionListener {

    private JButton saveButton;
    private JButton loadButton;
    private JTextArea textArea;
    private JFileChooser chooser;
    private File currentFile;
    private JScrollPane scrollPane;

    public FileEditor() {

        this.setTitle("Edytor");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        saveButton = new JButton("zapisz");
        saveButton.setActionCommand("Save");
        saveButton.addActionListener(this);

        loadButton = new JButton("wczytaj");
        loadButton.setActionCommand("Load");
        loadButton.addActionListener(this);

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        chooser = new JFileChooser();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void openFile() {
        int returnVal = chooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(currentFile);
                StringBuilder text = new StringBuilder();
                while (scanner.hasNextLine()) {
                    text.append(scanner.nextLine()).append("\n");
                }

                scanner.close();
                textArea.setText(text.toString());

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Błąd podczas otwierania pliku.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        int returnVal = chooser.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File fileToSave = chooser.getSelectedFile();
            try {

                FileWriter writer = new FileWriter(fileToSave);
                writer.write(textArea.getText());
                writer.close();

                currentFile = fileToSave; //aktualizuje plik
                JOptionPane.showMessageDialog(this, "Plik zapisano pomyślnie.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Błąd podczas zapisywania pliku.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Save")) {
            saveFile();
        } else if (command.equals("Load")) {
            openFile();
        }
    }
}