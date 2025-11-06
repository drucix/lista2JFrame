package org.shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingList extends JFrame implements ActionListener {

    private JButton add;
    private JPanel adding;
    private JPanel shoppingList;
    private JTextField addP;
    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JList<String> list;

    public ShoppingList() {

        this.setTitle("Shopping List");
        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        addProduct();
        addList();
        removeProduct();

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void addList(){
        shoppingList =  new JPanel();
        shoppingList.add(new JLabel("Lista zakupów:"));
        this.add(shoppingList);

        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list); //pasek do scrolowania posiadający liste
        scrollPane.setPreferredSize(new Dimension(350, 300));
        this.add(scrollPane);
    }
    private void addProduct() {
        adding = new JPanel();
        adding.add(new JLabel("Nazwa produktu:"));
        this.add(adding);

        addP = new JTextField();
        addP.setPreferredSize(new Dimension(200, 30));
        adding.add(addP);

        add = new JButton("dodaj");
        add.addActionListener(this);
        adding.add(add);
    }

    private void removeProduct(){
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    int index = list.locationToIndex(e.getPoint());
                    int input = JOptionPane.showConfirmDialog(list, "Czy chcesz usunąć ten produkt?");
                    if(input == 0){
                        listModel.removeElementAt(index);
                    }

                }
            }
        };
        list.addMouseListener(mouseListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            listModel.addElement(addP.getText());
            addP.setText("");
        }
    }
}
