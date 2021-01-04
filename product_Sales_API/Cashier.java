package product_Sales_API;

import java.util.ArrayList;

public class Cashier {
	private String name;
	private double Cash;
	private double Commision;
	private ArrayList <Refundable> RefundableItems;
	private int numberOfCashier;

	public Cashier(){
		Cash = 0;
	}

	//setter==========================================================

	public void setName(String name) {
		this.name = name;
	}

	public void setCash(double cash) {
		Cash = cash;
	}

	public void setCommision(double commision) {
		Commision = commision;
	}
	
	public void setNumberOfCashier(int numberOfCashier) {
		this.numberOfCashier = numberOfCashier;
	}


	//getter==========================================================

	public String getName() {
		return name;
	}

	public double getCash() {
		return Cash;
	}

	public double getCommision() {
		return Commision/100;
	}
	
	public int getNumberOfCashier() {
		return numberOfCashier;
	}

	
	//adding item to refund able item----------------------------------
	
	public void addRefundableItem(Refundable item) {
		if (item != null) {
			RefundableItems.add(item);
		}
	}
	
	//Removing item to refund able item----------------------------------

	public void removeRefundableItem(Refundable item) {
		RefundableItems.remove(item);
	}
	

	



}
