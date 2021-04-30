package com.company;


import java.awt.Event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.DocFlavor;
import javax.swing.*;

public class Quiz implements ActionListener {


    String [] questions = {
            "Who is the last prophet that Allah SWT sent?",
            "Which year did Prophet Muhammad received prophethood?",
            "Where was Prophet Muhammad born?",
            "What book did the Angel Jibrael gave to Prophet Muhammad"
    };

    String [][] options = {
            {"Prophet Muhammad", "Prophet Ibrahim", "Prophet Isa (Jesus)", "Prophet Moses"},
            {"610", "570", "630", "660"},
            {"Medina", "Petra", "Mecca", "Jerusalem"},
            {"The Torah", "The Bible", "Pslams", "Quran"}
    };

    char[] answers = {
            'A',
            'A',
            'C',
            'D'
    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;//Count down

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel labelA = new JLabel();
    JLabel labelB = new JLabel();
    JLabel labelC = new JLabel();
    JLabel labelD = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel seconds_Left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            seconds--;
            seconds_Left.setText(String.valueOf(seconds));
            if (seconds <= 0){
                displayAnswer();

            }

        }
    });


    public Quiz(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50,50, 50));
        frame.setLayout(null);
        frame.setResizable(false);


        textField.setBounds(0,0,650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 225, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);


        textArea.setBounds(0,50,650, 75);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 225, 0));
        textArea.setFont(new Font("Ink Free", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);



        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        labelA.setBounds(125, 100, 500, 100);
        labelA.setBackground(new Color(50,50,50));
        labelA.setForeground(new Color(25, 255, 0));
        labelA.setFont(new Font("MV Boli", Font.BOLD, 35));

        labelB.setBounds(125, 200, 500, 100);
        labelB.setBackground(new Color(50,50,50));
        labelB.setForeground(new Color(25, 255, 0));
        labelB.setFont(new Font("MV Boli", Font.BOLD, 35));

        labelC.setBounds(125, 300, 500, 100);
        labelC.setBackground(new Color(50,50,50));
        labelC.setForeground(new Color(25,255,0));
        labelC.setFont(new Font("MV Boli", Font.BOLD, 35));

        labelD.setBounds(125, 400, 500, 100);
        labelD.setBackground(new Color(50,50,50));
        labelD.setForeground(new Color(25,255,0));
        labelD.setFont(new Font("MV Boli", Font.BOLD, 35));

        seconds_Left.setBounds(535, 510, 100, 100);
        seconds_Left.setBackground(new Color(25,25, 25));
        seconds_Left.setForeground(new Color(255, 0, 0));
        seconds_Left.setFont(new Font("Ink Free", Font.BOLD, 35));
        seconds_Left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_Left.setOpaque(true);
        seconds_Left.setHorizontalAlignment(JTextField.CENTER);
        seconds_Left.setText(String.valueOf(seconds));

        timeLabel.setBounds(535, 475, 100, 25);
        timeLabel.setBackground(new Color(50,50,50));
        timeLabel.setForeground(new Color(255, 0,0));
        timeLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setText("timer >:D");


        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);


        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25 ));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(textField);
        frame.add(textArea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(labelA);
        frame.add(labelB);
        frame.add(labelC);
        frame.add(labelD);
        frame.add(seconds_Left);
        frame.add(timeLabel);
        //frame.add(number_right);
        //frame.add(percentage);

        frame.setVisible(true);

        nextQuestion();


    }

    public void nextQuestion(){

        if (index >= total_questions){
            finalResults();
        }else {
            textField.setText("Question "+(index+1));
            textArea.setText(questions[index]);
            labelA.setText(options[index][0]);
            labelB.setText(options[index][1]);
            labelC.setText(options[index][2]);
            labelD.setText(options[index][3]);
            timer.start();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB){
            answer = 'B';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC){
            answer = 'C';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD){
            answer = 'D';
            if (answer == answers[index]){
                correct_guesses++;
            }
        }
        displayAnswer();
    }

    public void displayAnswer(){

        timer.stop();


        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A'){
            labelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B'){
            labelB.setForeground(new Color(255, 0 , 0));
        }
        if (answers[index] != 'C'){
            labelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D'){
            labelD.setForeground(new Color(255, 0, 0));
        }

        Timer timer_pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelA.setForeground(new Color(25 ,255, 0));
                labelB.setForeground(new Color(25, 255, 0));
                labelC.setForeground(new Color(25, 255, 0));
                labelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_Left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        timer_pause.setRepeats(false);
        timer_pause.start();


    }

    public void finalResults(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses / (double) total_questions) * 100);


        textField.setText("RESULTS!");
        textArea.setText("");
        labelA.setText("");
        labelB.setText("");
        labelC.setText("");
        labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(number_right);
        frame.add(percentage);
    }

}
