package org.notes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesFrame extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JTextArea textArea;
    private JFileChooser chooser;
    private File currentFile;
    private JScrollPane scrollPane;

    NotesFrame(){

        this.setTitle("Notatnik");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        this.add(scrollPane, BorderLayout.CENTER);

        chooser = new JFileChooser();

        createMenuBar();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void createMenuBar(){

        menuBar = new JMenuBar();
        menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem newItem = new JMenuItem("Nowy");
        menu.add(newItem);
        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        JMenuItem saveItem = new JMenuItem("Zapisz");
        menu.add(saveItem);
        JMenuItem closeItem = new JMenuItem("Zamknij");
        menu.add(closeItem);

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        closeItem.addActionListener(this);

        newItem.setActionCommand("New");
        openItem.setActionCommand("Open");
        saveItem.setActionCommand("Save");
        closeItem.setActionCommand("Exit");

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    private void newFile(){
        textArea.setText("");
        currentFile = null; //czyszcze plik
    }

    private void openFile(){

        int returnVal = chooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            try {
                //wczytywanie pliku za pomocą Scannera
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

    private void saveFile(){
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

    private void exitFile() {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch (command){
            case "New":
                newFile();
                break;
            case "Open":
                openFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Exit":
                exitFile();
                break;
        }
    }
}
