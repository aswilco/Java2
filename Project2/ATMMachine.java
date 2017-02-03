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
				}
				catch (InsufficientFunds evt) {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Insufficient funds in selected account");
				}
		}
		});
		//Set withdraw button action
		withdrawal.setPreferredSize(new Dimension(100, 30));

		//Create and configure transfer button
		transferTo = new JButton( new AbstractAction("Transfer To") {
			//Create and configure transfer button action
			public void actionPerformed(ActionEvent e) {
				try {
				Account.Transfer();
			}
				catch (InsufficientFunds evt) {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Insufficient funds in selected account");
				}
				ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
				"Checking Balance: " + Account.checkingBalance + "/n" +
				"Savings Balance: " + Account.savingsBalance);
			}
		});
		//Set size of transfer button
		transferTo.setPreferredSize(new Dimension(100, 30));

		//Create and configure deposit button
		deposit = new JButton( new AbstractAction("Deposit") {
			//create and configure deposit button action
			public void actionPerformed(ActionEvent e) {
				Account.Deposit();
				if (checking.isSelected()) {
					popUp.showMessageDialog(frame,
					"New checking account balance: " + Account.checkingBalance);
				else if (savings.isSelected()) {
					popUp.showMessageDialog(frame,
					"New savings account balance: " + Account.savingsbalance);
				}
			}
				else {
					ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Please select the desired account");
				}
	}});	
		//Set size of deposit button
		deposit.setPreferredSize(new Dimension(100, 30));
	
		//Create and configure balance button
		balance = new JButton( new AbstractAction("Balance") {
			//create and configure balance button action
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
		//Set size of balance button
		balance.setPreferredSize(new Dimension(100, 30));

		//Create input TectField
		input = new JTextField(10);
	
		//Create checking and savings radio buttons
		checking = new JRadioButton("Checking");
		savings = new JRadioButton("Savings");
	
		//Create buttonGroup and add checking and savings radioButton to make buttons alternate
		checkSaving = new ButtonGroup();
		checkSaving.add(checking);
		checkSaving.add(savings);
	
		//Create inputPanel and add inputTextField
		inputPanel = new JPanel();
		inputPanel.add(input);
	
		//Create buttonPanel for top buttons
		buttonPanelOne = new JPanel();
		buttonPanelOne.setLayout(new FlowLayout(1, 30, 10));
		buttonPanelOne.add(withdrawal);
		buttonPanelOne.add(transferTo);
	
		//Create buttonpanel for lower buttons
		buttonPanelTwo = new JPanel();
		buttonPanelTwo.setLayout(new FlowLayout(1, 30, 10));
		buttonPanelTwo.add(deposit);
		buttonPanelTwo.add(balance);

		//Create RadioPanel and add radio buttons to panel
		radioPanel = new JPanel();
		radioPanel.add(checking);
		radioPanel.add(savings);
		//Create mainPanel and add all underlying panels
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, 3));
		mainPanel.add(buttonPanelOne);
		mainPanel.add(buttonPanelTwo);
		mainPanel.add(radioPanel);
		mainPanel.add(inputPanel);
		//Make mainPanel visible
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


