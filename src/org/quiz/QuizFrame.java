package org.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuizFrame extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JPanel titlePanel;
    private JPanel questionPanel;
    private JButton endTest;
    private List<List<JRadioButton>> allQuestionsButtons = new ArrayList<>();

    //5 odp poprawna
    String[][] questions = {
            {"Jak nazywa się największa planeta w Układzie Słonecznym?",
                    "Mars", "Jowisz", "Saturn", "Ziemia", "Jowisz"},
            {"Kto napisał Romeo i Julię?",
                    "Charles Dickens", "Henryk Sienkiewicz", "Adam Mickiewicz", "William Shakespeare", "William Shakespeare"},
            {"Ile kontynentów jest na Ziemi?",
                    "5", "6", "7", "8", "7"},
            {"Który ocean jest największy?",
                    "Atlantycki", "Arktyczny", "Spokojny (Pacyfik)", "Indyjski", "Spokojny (Pacyfik)"},
            {"Kiedy Polska wstąpiła do Unii Europejskiej?",
                    "2001", "2004", "2007", "2010", "2004"},
            {"Jakie jest chemiczne oznaczenie wody?",
                    "H2", "O2", "H2O", "CO2", "H2O"}
    };

    public QuizFrame() {

        this.setTitle("Quiz");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        setTitlePanel();

        for (int i = 0; i < questions.length; i++) {
            addQuestion(i + 1, questions[i]);
        }

        endTest = new JButton("zakończ");
        endTest.addActionListener(this);
        contentPane.add(endTest);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.PINK);
        JLabel title = new JLabel("Quiz z wiedzy ogólnej",  SwingConstants.CENTER);
        titlePanel.add(title);
        contentPane.add(titlePanel);
    }

    private void addQuestion(int number, String[] question){
        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel("Pytanie " + number + ": " + question[0]);
        questionPanel.add(questionLabel);

        List<JRadioButton> buttons = new ArrayList<>();

        for(int i = 1; i <=4; i++){
            JRadioButton option = new JRadioButton(question[i]);
            buttons.add(option);
            questionPanel.add(option);
        }
        allQuestionsButtons.add(buttons);
        contentPane.add(questionPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == endTest){
            int score = 0;
            for(int i = 0; i < allQuestionsButtons.size(); i++){

                List<JRadioButton> options = allQuestionsButtons.get(i);
                String correctAnswer = questions[i][5];

                for(JRadioButton option : options){
                    if(option.isSelected() && option.getText().equals(correctAnswer)){
                        score++;
                    }
                }

            }
            JOptionPane.showMessageDialog(this, "Twój wynik: " + score + "/" + questions.length, "Wynik quizu", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
