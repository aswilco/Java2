import java.math.*;

public class Account extends ATMMachine {
	public static double checkingAccount;
	public static double savingsBalance;
	public static double savingsAccount;
	public static double checkingBalance;
	public static double accountBalance;
	public static double currentCheckingBalance;
	public static double currentSavingsBalance;
	private static int transactions = 0;
	private static double transactionFee = 1.50;

public static void Withdraw() throws InsufficientFunds {
			try {
			Integer.parseInt(ATMMachine.input.getText());
	if (Integer.parseInt(ATMMachine.input.getText()) % 20 == 0) {
	double amount = Integer.parseInt(ATMMachine.input.getText());
		++transactions;
	if (transactions > 4) {
		amount = amount + transactionFee;
	}
	if (ATMMachine.checking.isSelected()) {
	checkingBalance = checkingBalance - amount;
		if (checkingBalance < 0) {
			checkingBalance = checkingBalance + amount;
			--transactions;
			throw new InsufficientFunds();
		}
}
	else if (ATMMachine.savings.isSelected()) {
			savingsBalance = savingsBalance - amount;
			if(savingsBalance < 0) {
				savingsBalance = savingsBalance + amount;
				--transactions;
				throw new InsufficientFunds();
			}
}

}
	else {ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
		"Amount must be in values of $20");
}
	}
catch (NumberFormatException e) {
		ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
		"Please input a number in values of $20");
	}

}

	public static void Deposit() {
		try {
			Integer.parseInt(ATMMachine.input.getText());
			double amount = Integer.parseInt(ATMMachine.input.getText());

			if (ATMMachine.checking.isSelected()) {
				checkingBalance = checkingBalance + amount;
			} else if (ATMMachine.savings.isSelected()) {
				savingsBalance = savingsBalance + amount;
			}
		} catch (NumberFormatException e) {
			ATMMachine.popUp.showMessageDialog(ATMMachine.frame, "Input value must be numeric");
		}
	}

public static void Transfer() {
	try {Integer.parseInt(ATMMachine.input.getText());
	float amount = Integer.parseInt(ATMMachine.input.getText());
		if (ATMMachine.checking.isSelected()) {
		checkingBalance = checkingBalance + amount;
		savingsBalance = savingsBalance - amount;
		if (savingsBalance < 0) {
		savingsBalance = savingsBalance + amount;
		checkingBalance = checkingBalance - amount;
		throw new InsufficientFunds();
		}
	}
	else if (ATMMachine.savings.isSelected()) {
		savingsBalance= savingsBalance + amount;
		checkingBalance = checkingBalance - amount;
		if (checkingBalance < 0) {
			checkingBalance = checkingBalance + amount;
			savingsBalance = savingsBalance - amount;
			throw new InsufficientFunds();
		}
	}
}

catch (NumberFormatException e) {
		ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
	"Input value must be numeric");
}
}

	public static double GetBalance() {
		if (ATMMachine.checking.isSelected()) {
			accountBalance = checkingBalance;
		} else if (ATMMachine.savings.isSelected()) {
			accountBalance = savingsBalance;
		}
		return accountBalance;
	}

}


