package product_Sales_API;

import java.util.ArrayList;

public abstract class Product {
	private String ProductID;
	private Double Price;
	private String Brand;
	private Double Discount;
	private String Size;

	private ArrayList <String> BrandArray;
	private ArrayList <Double> PriceArray;
	private ArrayList <String> ProductIDArray;
	private ArrayList <Double> DiscountArray;
	private ArrayList <String> SizeArray;
	private ArrayList <Integer> Quantity;


	public static int numberOfProduct = 0;



	public Product(String ProductID,Double Price, String Brand,Double Discount,String Size) {
		this.ProductID = ProductID;
		this.Price = Price;
		this.Brand = Brand;
		this.Discount = Discount;
		this.Size = Size;
		numberOfProduct++;

		BrandArray = new ArrayList <String>();
		PriceArray = new ArrayList <Double>();
		ProductIDArray = new ArrayList <String>();
		DiscountArray = new ArrayList <Double>();
		SizeArray = new ArrayList <String>();

	}

	public Product() {
		BrandArray = new ArrayList <String>();
		PriceArray = new ArrayList <Double>();
		ProductIDArray = new ArrayList <String>();
		DiscountArray = new ArrayList <Double>();
		SizeArray = new ArrayList <String>();
		Quantity = new ArrayList <Integer>();
	}

	
	//Adding method to array======================================================================================================================


	public void addProductID(String productID) {


		if (productID.length()>7) {
			productID = productID.substring(0,6);
		}

		if (productID != null) {
			ProductIDArray.add(productID);
		}
	}

	public void addPrice(double price) {

		if (price != -1.0) {
			PriceArray.add(price);
		}

	}

	public void addBrand(String brand) {

		if (brand != null) {
			BrandArray.add(brand);

		}
	}

	public void addDiscount(double discount) {

		if (discount != -1.0) {
			DiscountArray.add(discount);
		}
	}

	public void addSize(String size) {

		if (size != null) {
			SizeArray.add(size);
		}
	}

	public void addQuantity(int quantity) {

		if (quantity != 0) {
			this.Quantity.add(quantity);

		}
	}
	
	public void addQuantity(int index,int quantity) {

		if (quantity != 0) {
			this.Quantity.add(index,quantity);

		}
	}

	//Getter========================================================================================================================================

	
	public int getindex(String ProductID) {

		//To get index of array from ProductID (String)
		
		for (int i =0; i< ProductIDArray.size();i++) {
			if (ProductIDArray.get(i).equalsIgnoreCase(ProductID)) {
				return i;
			}
		}
		return -1;

	}

	public String getProductID(int index) {

		if(!ProductIDArray.isEmpty() && index >= 0 && index < ProductIDArray.size()) {
			return ProductIDArray.get(index);
		}
		
		return "Product are not Available";
		
	}


	public Double getPrice(int index) {

		if(!PriceArray.isEmpty() && index >= 0 && index < PriceArray.size()) {
			return PriceArray.get(index);
		}
		return -1.0;
	}

	public String getBrand(int index) {

		if(!BrandArray.isEmpty() && index >= 0 && index < BrandArray.size()) {
			return BrandArray.get(index);
		}
		return null;
	}

	public Double getDiscount(int index) {

		if(!DiscountArray.isEmpty() && index >= 0 && index < DiscountArray.size()) {
			return DiscountArray.get(index);
		}
		return -1.0;
	}

	public String getSize(int index) {

		if(!SizeArray.isEmpty() && index >= 0 && index < SizeArray.size()) {
			return SizeArray.get(index);
		}
		return null;
	}


	public Double getAmount(int index) {

		if(!DiscountArray.isEmpty()&&index >= 0 && index < DiscountArray.size()) {
			return PriceArray.get(index)-((DiscountArray.get(index)/100)*PriceArray.get(index));
		}
		return null;
	}
	

	public int getQuantity(int index) {

		if(!Quantity.isEmpty() && index >= 0 && index < Quantity.size()) {
			return Quantity.get(index);
		}
		return -1;

	}
	
	public int getArraySize() {

		return ProductIDArray.size();

	}
	
	
	public String getMenu(int index) {
		
		// Showing Menu of Summarization of Product, this includes the price, ID,Size,Discount and Quantity
		
		if (!ProductIDArray.isEmpty()) {
			return ProductIDArray.get(index) + "\t"+BrandArray.get(index)+"\t"+PriceArray.get(index)+"\t"+DiscountArray.get(index)+"\t\t "+SizeArray.get(index)+"\t"+Quantity.get(index);
		}
		
		return null;
	}
	
	
	public String getSearchID (int index) {
		
		// Showing search able Product, this includes the price, ID,Size and Discount.
		
		if (!getProductID(index).isEmpty()) {
			return "\nProductID \tPrice \tBrand \tDiscount \tSize \n---------------------------------------------------------------"+"\n"+getProductID(index)+"\t\t$"+getPrice(index)+"\t"+getBrand(index)+"\t"+getDiscount(index)+"\t\t"+
					getSize(index);
		}
		
		
		return null;

	}
	
	//REMOVE METHOD-----------------------------------------------------------------------



	public void removeProductID(int index) {

		if(!ProductIDArray.isEmpty() && index >= 0 && index < ProductIDArray.size()) {
			ProductIDArray.remove(index);
		}

	}


	public void removePrice(int index) {

		if(!PriceArray.isEmpty() && index >= 0 && index < PriceArray.size()) {
			PriceArray.remove(index);
		}
	}

	public void removeBrand(int index) {

		if(!BrandArray.isEmpty() && index >= 0 && index < BrandArray.size()) {
			BrandArray.remove(index);
		}

	}

	public void removeDiscount(int index) {

		if(!DiscountArray.isEmpty() && index >= 0 && index < DiscountArray.size()) {
			DiscountArray.remove(index);
		}

	}

	public void removeSize(int index) {

		if(!SizeArray.isEmpty() && index >= 0 && index < SizeArray.size()) {
			SizeArray.remove(index);
		}

	}
	
	public void removeQuantity(int index) {

		if(!Quantity.isEmpty() && index >= 0 && index < Quantity.size()) {
			Quantity.remove(index);
		}

	}
	
	

}
