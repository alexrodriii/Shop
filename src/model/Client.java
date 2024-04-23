package model;
import main.Payable;

public class Client extends Person implements Payable{

	private int member_id;
	private double balance;
	
	final static int MEMBER_ID = 456;
	final static double BALANCE = 50.00;
	
	public Client (String name,int age) {
		
		super (name,0);
	 this.member_id = MEMBER_ID;
	 this.balance = BALANCE;

}
	
 
	public static int getMemberId() {
		return MEMBER_ID;
	}

	public static double getBalance() {
		return BALANCE;
	}

	public boolean pay (double amount) {
    	double nBalance = balance -  amount;
    	if (nBalance >= 0) {
		balance = nBalance;
		return true;
		
    	} else {
    		return false;
    	}
    }
  }