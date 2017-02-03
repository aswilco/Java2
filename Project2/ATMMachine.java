import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Dialog;

public class ATMMachine extends JFrame {
	//ATMMachine Fields/Variables
	static JFrame frame;
	protected JPanel mainPanel;
	protected JPanel buttonPanelOne;
	protected JPanel buttonPanelTwo;
	protected JPanel radioPanel;
	protected JPanel inputPanel;
	protected static JRadioButton checking;
	protected static JRadioButton savings;
	protected JButton deposit;
	protected JButton withdrawal;
	protected JButton balance;
	protected JButton transferTo;
	protected static ButtonGroup checkSaving;
	protected String account;
	protected static JOptionPane popUp = new JOptionPane();
	protected JPanel balancePanel;
	protected JTextField balanceText;
	protected static JTextField input;
	protected int amount;
	private String message;



//define WIDTH and HEIGHT of ATM Machine win8dow
static final int WIDTH = 300;
static final int HEIGHT = 200;

//ATM Machine window builder
public ATMMachine() {
        super("ATM");
        setFrame(WIDTH, HEIGHT);
//Create and configure Withdraw Button
		withdrawal = new JButton( new AbstractAction("Withdraw") {
		//Congfigure Withdraw Action
			public void actionPerformed(ActionEvent e) {
				//Try statement required to catch InsufficientFunds checked exception
				try {
				Account.Withdraw();
				if (checking.isSelected()) {
				System.out.println(Account.checkingBalance);
				}
				else if (savings.isSelected()) {
				System.out.println(Account.savingsBalance);
				}
				else {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Please select the desired account");
				}
				}
				catch (InsufficientFunds evt) {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Insufficient funds in selected account");
				}
		}
		});
		withdrawal.setPreferredSize(new Dimension(100, 30));

		transferTo = new JButton( new AbstractAction("Transfer To") {
			public void actionPerformed(ActionEvent e) {
				try {
				Account.Transfer();
			}
				catch (InsufficientFunds evt) {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Insufficient funds in selected account");
				}
				System.out.println("Checking:" + Account.checkingBalance);
				System.out.println("Savings:" + Account.savingsBalance);
			}
		});
		transferTo.setPreferredSize(new Dimension(100, 30));

		deposit = new JButton( new AbstractAction("Deposit") {
			public void actionPerformed(ActionEvent e) {
				Account.Deposit();
				if (checking.isSelected()) {
					System.out.println(Account.checkingBalance);
				}
				else if (savings.isSelected()) {
					System.out.println(Account.savingsBalance);
			}
	}});
		deposit.setPreferredSize(new Dimension(100, 30));

		balance = new JButton( new AbstractAction("Balance") {
			public void actionPerformed(ActionEvent e) {
				Account.GetBalance();
				popUp = new JOptionPane();
				if (checking.isSelected()) {
					message = "Checking Balance: ";
				}
				else if (savings.isSelected()) {
					message = "Savings Balance: ";
				}
				popUp.showMessageDialog(frame, message + "$" + Double.toString(
				Account.accountBalance));
			}});
		balance.setPreferredSize(new Dimension(100, 30));

		input = new JTextField(10);

		checking = new JRadioButton("Checking");
		savings = new JRadioButton("Savings");

		checkSaving = new ButtonGroup();
		checkSaving.add(checking);
		checkSaving.add(savings);

		inputPanel = new JPanel();
		inputPanel.add(input);

		buttonPanelOne = new JPanel();
		buttonPanelOne.setLayout(new FlowLayout(1, 30, 10));
		buttonPanelOne.add(withdrawal);
		buttonPanelOne.add(transferTo);

		buttonPanelTwo = new JPanel();
		buttonPanelTwo.setLayout(new FlowLayout(1, 30, 10));
		buttonPanelTwo.add(deposit);
		buttonPanelTwo.add(balance);


		radioPanel = new JPanel();
		radioPanel.add(checking);
		radioPanel.add(savings);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, 3));
		mainPanel.add(buttonPanelOne);
		mainPanel.add(buttonPanelTwo);
		mainPanel.add(radioPanel);
		mainPanel.add(inputPanel);
		add(mainPanel);



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
//	try {

        ATMMachine atmMachine = new ATMMachine();
        atmMachine.display();
        atmMachine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//	}
//	catch (Exception e) {
//		popUp.showMessageDialog(frame, "Something unexpected happened!");
	}

}


