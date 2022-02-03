package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    //create an array that will store number buttons
    JButton[] numberButtons = new JButton[10];
    //Create an array to store function buttons
    JButton[] functionsButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, divideButton,
            decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double number1 = 0, number2 = 0, result=0;
    char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //To display the numbers typed in and results of calculations
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //function buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("delete");
        clearButton = new JButton("clear");
        negativeButton = new JButton("(-)");

        //add function buttons to array list of function buttons
        functionsButtons[0] = addButton;
        functionsButtons[1] = subtractButton;
        functionsButtons[2] = multiplyButton;
        functionsButtons[3] = divideButton;
        functionsButtons[4] = decimalButton;
        functionsButtons[5] = equalsButton;
        functionsButtons[6] = deleteButton;
        functionsButtons[7] = clearButton;
        functionsButtons[8] = negativeButton;

        for (JButton functionsButton : functionsButtons) {
            functionsButton.addActionListener(this);
            functionsButton.setFont(myFont);
            functionsButton.setFocusable(false);
        }

        for (int i=0;i<numberButtons.length;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negativeButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);

        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);

        frame.add(textField);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<numberButtons.length;i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource()==subtractButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource()==multiplyButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource()==divideButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource()==equalsButton) {
            number2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = number1 + number2;
                case '-' -> result = number1 - number2;
                case '*' -> result = number1 * number2;
                case '/' -> result = number1 / number2;
            }
            textField.setText(String.valueOf(result));
            number1=result;
        }
        if (e.getSource()==clearButton) {
            textField.setText("");
        }

        if (e.getSource()==deleteButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource()==negativeButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
