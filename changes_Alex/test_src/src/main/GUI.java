package main;

import javax.swing.*;

public class GUI {

    private JPanel contentPane;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TITEL");
        frame.setContentPane(new GUI().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
