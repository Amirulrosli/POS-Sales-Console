package product_Sales_API;

import java.util.ArrayList;
import java.util.Date;

public class Supervisor {
	private ArrayList <Product> Inventory;
	public ArrayList <Integer> quantity;
	private String Username;
	private String Password;
	public int numberOfArray = 0;
	private java.util.Date date;
	

	public Supervisor(){
		Username = "Admin";
		Password = "Admin";
		date = new java.util.Date();
		Inventory = new ArrayList <Product>();
		quantity = new ArrayList<Integer>();

	}

	//Setter===================================================

	public void setUsername(String username) {
		this.Username = username;

	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	

	//Getter==================================================
	
	public String getUsername() {
		return Username;
	}
	
	public String getPassword() {
		return Password;
	}

	public Date getDate() {
		return date;
	}


	//Add and remove product=======================================
	public void addProduct(Product item) {
		if (item != null) {
			Inventory.add(item);
		}
	}
	
	public Product getProduct(int index) {
		if(!Inventory.isEmpty() && index >= 0 && index < Inventory.size()) {
			return Inventory.get(index);
		}
		return null;
	}

	public void removeProduct(Product item) {
		Inventory.remove(item);
	}











}
