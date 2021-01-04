package product_Sales_API;

public class Clothes extends Product implements Refundable {
	
	protected static int numberOfClothes = 0;

	public Clothes(String ProductID,  Double Price, String Brand,  Double Discount, String Size) {
		super(ProductID, Price, Brand, Discount, Size);
		
	}

	public Clothes() {
		
	}

	
	//Mentioning that product is refund able
	public String refundable() {
		return "Goods are Refundable";	
	}


	
}
