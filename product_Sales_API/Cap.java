package product_Sales_API;

public class Cap extends Product{
	
	protected static int numberOfCap = 0;

	public Cap(String ProductID, Double Price, String Brand,  Double Discount, String Size) {
		super(ProductID, Price, Brand, Discount, Size);
		numberOfCap++;
		numberOfProduct++;
	}

	public Cap() {
	}
	

}
