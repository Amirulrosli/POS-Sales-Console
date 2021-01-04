package product_Sales_API;

public class Stockings extends Product {
	
	protected static int numberOfStockings = 0;

	public Stockings(String ProductID,  Double Price, String Brand,  Double Discount, String Size) {
		super(ProductID, Price, Brand, Discount, Size);
		numberOfProduct++;
		numberOfStockings++;
	}

	public Stockings() {
		
	}



}
