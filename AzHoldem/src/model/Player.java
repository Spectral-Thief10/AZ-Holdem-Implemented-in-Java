//Cameron Rodgers

package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Player {
	int num;
	double balance;

	public Player(int num) {
		balance = 100.00;
		this.num = num;
	}

	public String getBalance() {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		String str = format.format(balance);
		return str;
	}

	public int getNum() {
		return num;
	}

	public String playerID() {
		return "Player " + num;
	}

	public String toString() {
		String str = "Player " + num + ": " + getBalance() + " " + " - ";
		return str;
	}

	public void subtractBalance() {
		balance -= 2;
	}

	public void addBalance() {
		balance += 2;
	}

	public void addSpecificBalance(double totalBalance) {
		balance += totalBalance;
	}
}
