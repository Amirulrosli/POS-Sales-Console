package product_Sales_API;

public class Shoes extends Product implements Refundable{
	
	protected static int numberOfShoes = 0;
	
	public Shoes(String ProductID,  Double Price, String Brand,  Double Discount, String Size) {
		super(ProductID, Price, Brand, Discount, Size);
		
		numberOfShoes++;
		numberOfProduct++;
	}

	public Shoes() {
	}
	
	//Mentioning that product are refund able
	public String refundable() {
		return "Goods are Refundable";
		
	}


	
}
