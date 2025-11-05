package org.BMI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField inHeight = new JTextField();
    private JTextField inWeight = new JTextField();
    private JButton button;
    private JTextField resultBMI;

    public Calculator() {

        this.setTitle("Kalkulator BMI");
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        textFields();

        button = new JButton("oblicz");
        button.addActionListener(this);
        this.add(button);

        resultBMI = new JTextField();
        resultBMI.setEditable(false);
        resultBMI.setPreferredSize(new Dimension(350, 40));
        this.add(resultBMI);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void textFields(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("Wpisz wzrost:"));

        inHeight = new JTextField();
        inHeight.setPreferredSize(new Dimension(250,40));
        panel.add(inHeight);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Wpisz wagę:"));

        inWeight = new JTextField();
        inWeight.setPreferredSize(new Dimension(250,40));
        panel1.add(inWeight);

        this.add(panel);
        this.add(panel1);
    }

    private double calculateBMI(double height, double weight){
        return weight / ((height * height)/10000);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            try {
                double height = Double.parseDouble(inHeight.getText());
                double weight = Double.parseDouble(inWeight.getText());
                double bmi = calculateBMI(height, weight);
                inHeight.setText(" ");
                inWeight.setText(" ");
                String formatBMI = String.format("%.2f", bmi);
                resultBMI.setText("Twoje BMI: " + formatBMI);

            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Zostały podane złe dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
