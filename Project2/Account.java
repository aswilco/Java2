
public class Account extends ATMMachine {
	protected static double savingsBalance;
	protected static double checkingBalance;
	protected static double accountBalance;
	private static int transactions = 0;
	private static double transactionFee = 1.50;

	//Withdraw Method
	public static void Withdraw() throws InsufficientFunds {
			//Try to ParseInt from input to verify numerical value
			try {
				Integer.parseInt(ATMMachine.input.getText());
				//check if input is values of 20
				if (Integer.parseInt(ATMMachine.input.getText()) % 20 == 0) {
					double amount = Integer.parseInt(ATMMachine.input.getText());
					++transactions;
					if (transactions > 4) {
						amount = amount + transactionFee;
					}
					//check if checking is selected and perform math on checkingBalance
					if (ATMMachine.checking.isSelected()) {
						checkingBalance = checkingBalance - amount;
						//if not enough money throw insufficientFundsException
						if (checkingBalance < 0) {
							checkingBalance = checkingBalance + amount;
							--transactions;
							throw new InsufficientFunds();
						}
					ATMMachine.popUp.showMessageDialog(frame,
					"New checking account balance: $" + String.format( "%.2f", checkingBalance));
					}
					//check if savings is selected and perform math on savingsBalance
					else if (ATMMachine.savings.isSelected()) {
						savingsBalance = savingsBalance - amount;
						//if not enough money throw insufficientfunds exception
						if(savingsBalance < 0) {
							savingsBalance = savingsBalance + amount;
							--transactions;
							throw new InsufficientFunds();
						}
					ATMMachine.popUp.showMessageDialog(frame,
					"New savings account balance: $" + String.format("%.2f", savingsBalance));
					}
					else {
						ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
						"Please select the desired account");

			 		}
				}
				//if input is not value of 20 give messageprompt
			 	else {
					 ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Amount must be in values of $20");
				}
			}
			//catch parseInt exception and display input error
			catch (NumberFormatException e) {
			ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
			"Please input a number in values of $20");
			}

	}

	//Deposit method for deposit button
	public static void Deposit() {
		//try to parse Int
		try {
			Integer.parseInt(ATMMachine.input.getText());
			double amount = Integer.parseInt(ATMMachine.input.getText());

			if (ATMMachine.checking.isSelected()) {
				checkingBalance = checkingBalance + amount;
				popUp.showMessageDialog(frame,
					"New checking account balance: $" + String.format("%.2f", checkingBalance));
			}
			else if (ATMMachine.savings.isSelected()) {
				savingsBalance = savingsBalance + amount;
				popUp.showMessageDialog(frame,
					"New savings account balance: $" + String.format("%.2f", savingsBalance));
			}
			else {
				ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
					"Please select the desired account");
				}
		}
		//catch nfe for parse Int and display error
		catch (NumberFormatException e) {
			ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
			"Please enter a number");
		}
	}

	public static void Transfer() {
		try {
			Integer.parseInt(ATMMachine.input.getText());
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
			ATMMachine.popUp.showMessageDialog(ATMMachine.frame,
				"Checking Balance: $" + String.format("%.2f", Account.checkingBalance) + "\n "+
				"Savings Balance: $" + String.format("%.2f", Account.savingsBalance));
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


