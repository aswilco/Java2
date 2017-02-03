

import javax.swing.*;
import java.awt.*;

public class ATMMachine extends JFrame {

//define WIDTH and HEIGHT of ATM Machine window
static final int WIDTH = 600;
static final int HEIGHT = 400;

//ATM Machine window builder
public ATMMachine() {
        super("ATM Machine");
        setFrame(WIDTH, HEIGHT);
        setLayout (new GridLayout());
        add (new JButton("Checking"));
        add (new JButton("Savings"));
        add (new JButton("Deposit"));
        add (new JButton("Withdrawl"));

}

//ATM Machine setter
private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

//ATM Machine set visible
public void display() {
        setVisible(true);
}


public static void main(String[] args) {

        ATMMachine atmMachine = new ATMMachine();
        atmMachine.display();
}

}
