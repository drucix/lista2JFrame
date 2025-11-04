package org.backround;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FrameSettings extends JFrame implements ActionListener {

    private JButton button;
    private JTextField text;
    private String color;
    private JPanel panel;
    private final Map<String, Color> colorMap;

    FrameSettings() {

        this.setTitle("Zamiana koloru panelu.");

        colorMap = new HashMap<>();
        initializeColorMap();

        this.setSize(400, 400);
        this.setLayout(new FlowLayout()); //ustawia komponenty jeden za drugim zamiast zastępować

        panel = new JPanel();
        panel.add(new JLabel("Wpisz kolor:"));

        text = new JTextField();
        text.setPreferredSize(new Dimension(250,40));

        button = new JButton("zmień kolor");
        button.addActionListener(this);

        this.add(panel);
        panel.add(text);
        panel.add(button);

        this.pack(); //dopasowuje automatycznie rozmiar
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initializeColorMap() {
        colorMap.put("czerwony", Color.RED);
        colorMap.put("pomarańczowy", Color.ORANGE);
        colorMap.put("żółty", Color.YELLOW);
        colorMap.put("zielony", Color.GREEN);
        colorMap.put("niebieski", Color.BLUE);
        colorMap.put("różowy", Color.PINK);
        colorMap.put("biały", Color.WHITE);
        colorMap.put("szary", Color.GRAY);
        colorMap.put("czarny", Color.BLACK);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            color = text.getText().trim().toLowerCase();

            if(colorMap.containsKey(color)){
                Color newColor = colorMap.get(color);
                panel.setBackground(newColor);
            } else {
                JOptionPane.showMessageDialog(this, "Nie znaleziono tego koloru.");
            }
        }
    }
}
