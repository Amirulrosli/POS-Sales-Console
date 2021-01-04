/*TABLE OF CONTENT
 **************************************************************************************
 
1) INVENTORY MANAGEMENT PROCESS (TEST APPLICATION)....................(Line 58)      *
	2) LOGIN PROCESS..................................................(Line 79)      *
	3) OPTION.........................................................(Line 170)     *
	4) PLAIN FILE (WRITER)............................................(Line 190)     *
	5) READ PLAINTEXT.................................................(Line 233)     *
	6) ADDING STOCKS..................................................(Line 273)     *
	7) REMOVING STOCKS................................................(Line 505)     *
	8) SEARCHING STOCKS...............................................(Line 658)     *
9) PRODUCT SALES SYSTEM (CASHIER TEST APP)............................(Line 706)     *
	10) FILEWRITER(CASHIER)...........................................(Line 728)     *
	11) SUMMARY (CONSOLE).............................................(Line 831)     *
	12) PROCESSING INVOICE............................................(Line 840)     *
	13) SUMMARY (PLAIN TEXT)..........................................(Line 848)     *
 
 
 **************************************************************************************
 */

package product_Sales_API;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class test {

	public static void main(String[] args) throws IOException {


		Scanner input = new Scanner (System.in);
		File myFile = new File ("Added(Refer Only).text");

		//OBJECT DECLARATION--------------------------------------------------------------------------------------------------

		Supervisor User1 = new Supervisor ();
		Clothes cloth = new Clothes ();
		Shoes shoes = new Shoes();
		Cap caps = new Cap();
		Stockings socks = new Stockings();
		String exit = "";
		int numberOfCashier = 0;

		while(true) {

			System.out.println("---------------------------------------------------------------------------------");

			System.out.print("\nEnter (C) to Enter POS System / (S) to Enter Inventory Management: ");
			String selection = input.next();



			//===========================================1) INVENTORY MANAGEMENT PROCESS (TEST APPLICATION)============================================================================

			if (selection.equalsIgnoreCase("S")) {

				System.out.println("\n\t\t\tINVENTORY MANAGEMENT SYSTEM");
				System.out.println("====================================================================================");
				System.out.print("Do you want to Overwrite the System? (Y/N): ");
				String Overwrite = input.next();

				boolean append = true;
				if (Overwrite.equalsIgnoreCase("Y")) {
					append = false;
				}

				FileWriter fileWriter = new FileWriter(myFile,append);
				PrintWriter write = new PrintWriter (fileWriter);

				System.out.print("Do you want to change the default configuration? (Y/N): ");
				String input3 = input.next();


				//===============================================2) LOGIN PROCESS==============================================================================================

				int attempts=0;

				if (input3.equalsIgnoreCase("Y")) {

					System.out.println("\n====================================================================================");
					System.out.println("===============================WELCOME!!============================================");
					System.out.println("====================================================================================");

					System.out.println("\n\t*****************NEW USER REGISTRATION*******************");

					System.out.print("\nSet Your Username: ");
					String userInput = input.next();

					System.out.print("Set Your Password: ");
					String userInput1 = input.next();

					User1.setUsername(userInput);
					User1.setPassword(userInput1);

					System.out.println("\n=====================================================================================");
					System.out.println("LOGIN");
					System.out.println("=====================================================================================");

					do {

						System.out.print("\nENTER USERNAME: ");
						String userInput2 = input.next();
						System.out.print("ENTER PASSWORD: ");
						String userInput3 = input.next();


						if(userInput2.equalsIgnoreCase(User1.getUsername())) {
							if (userInput3.equalsIgnoreCase(User1.getPassword())) {
								System.out.println("\n########Login Success######## ");
								attempts = 4;
							}
							else {
								System.out.println("\n Incorrect Password! "); 
								attempts++;
							}
						}
						else {
							System.out.println("\n Incorrect Username!! ");
							attempts++;
						}

					}while (attempts<3);

				} else if (input3.equalsIgnoreCase("N")){
					System.out.println("\n====================================================================================");
					System.out.println("================================WELCOME!!===========================================");
					System.out.println("====================================================================================");


					System.out.println("\n-------------------LOGIN--------------------");


					do {
						System.out.print("\nEnter Default Username: ");
						String userInput = input.next();
						System.out.print("Enter Default Password: ");
						String userInput1 = input.next();

						if(userInput.equalsIgnoreCase(User1.getUsername())) {
							if (userInput1.equalsIgnoreCase(User1.getPassword())) {
								System.out.println("\n########Login Success#######");
								attempts=4;
							}
							else {
								System.out.println("\n Incorrect Password! ");
								attempts++;
							}
						}
						else {
							System.out.println("\n Incorrect Username!! ");
							attempts++;
						}
					} while (attempts<3);

				}
				else {
					attempts=0;
				}

				if (attempts==3 || attempts==0) {
					System.out.println("\nAuthorized User Only!!");
				}
				else {

					//=========================================3) OPTION=================================================================================

					while (true) {

						System.out.println("\n"+User1.getDate());
						System.out.println("\n1. Adding Stocks");
						System.out.println("2. Removing Stocks");
						System.out.println("3. Searching Stocks Details");


						System.out.print("\nDo you want to Continue(Y) or Exit(N): ");
						String optionValue = input.next();

						if (!optionValue.equalsIgnoreCase("Y") && !optionValue.equalsIgnoreCase("N")) {
							System.out.println("");
							System.out.println("\n**********Input Mismatch!!**********");
							System.out.println(" ");
						}


						//=========================================4) PLAIN FILE (WRITER)======================================================================


						else if (optionValue.equalsIgnoreCase("N")) {
							File File = new File ("UPDATED STOCK.text");
							FileWriter fileWriter1 = new FileWriter(File,append);
							PrintWriter write1 = new PrintWriter (fileWriter1);

							System.out.println("\n********Creating Your File********");
							System.out.println("File Exist: "+File.exists());
							System.out.println("Absolute Path: "+File.getAbsolutePath());
							System.out.println("File name: "+File.getName());

							write1.println("\nUpdate Stock (By SuperVisor)");
							write1.println(User1.getDate());
							write1.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
							write1.println("--------------------------------------------------------------------------------");

							for (int x = 0 ;x<cloth.getArraySize();x++) {
								write1.println((x+1)+". "+"Clothes Stock");
								write1.println(cloth.getMenu(x));
								write1.println(" ");
							}
							for (int x = 0 ;x<shoes.getArraySize();x++) {
								write1.println((x+1)+". "+"Shoes Stock");
								write1.println(shoes.getMenu(x));	
								write1.println(" ");
							}

							for (int x = 0 ;x<caps.getArraySize();x++) {
								write1.println((x+1)+". "+"Caps Stock");
								write1.println(caps.getMenu(x));
								write1.println(" ");
							}

							for (int x = 0 ;x<socks.getArraySize();x++) {
								write1.println((x+1)+". "+"Stockings Stock");
								write1.println(socks.getMenu(x));
								write1.println(" ");
							}

							write1.close();

							//================================5) READ PLAINTEXT======================================================================================

							System.out.print("\n(Y)to View Your File Content / (N) to Exit: ");
							String inputString = input.next();

							if (inputString.matches("N") && inputString.matches("n")) {
								break;
							}

							try {
								Scanner readFile = new Scanner(File);
								while(readFile.hasNextLine()) {
									System.out.println(readFile.nextLine());		
								}

								readFile.close();

							} catch (FileNotFoundException e) {
								//e.printStackTrace();
								System.out.println("No File Found");
							}

							catch (Exception e) {
								//e.printStackTrace();
								System.out.println("Problem Error 404");
							}



							System.out.println("\nThank You, Come Again!");
							break;

						}

						else {
							System.out.print("\nENTER THE RELEVANT NUMBER: ");
							int UserInput = input.nextInt();

							switch (UserInput) {

							//---------------------------------------------------6) ADDING STOCKS-------------------------------------------------------------------

							case 1 :

								System.out.println("\n--------------------ADDING STOCK--------------------");
								System.out.println("1. Clothes \t2. Shoes \n3. Cap     \t4. Stockings");
								System.out.print("\nENTER THE SELECTED NUMBER: ");
								int addingInput = input.nextInt();

								switch(addingInput) {

								case 1: 

									String input1;
									int counter = 0;

									do {
										System.out.println("====================================================");
										System.out.println("\n--------------------CLOTHES STOCK-------------------");

										System.out.print("\nEnter ProductID: ");
										String productId = input.next();

										System.out.print("Enter the Price: $");
										double Price = input.nextDouble();

										System.out.print("Enter the Product Brand: ");
										String brand = input.next();

										System.out.print("Enter the Discount (%): ");
										Double discount = input.nextDouble();

										System.out.print("Enter the Clothes Size: ");
										String Size = input.next();

										System.out.print("Enter the Quantity of the stock Available: ");
										int quantity = input.nextInt();

										cloth.addQuantity(quantity);
										cloth.addProductID(productId);
										cloth.addPrice(Price);
										cloth.addBrand(brand);
										cloth.addDiscount(discount);
										cloth.addSize(Size);
										System.out.println(" ");
										counter++;

										System.out.println("Continue (Y) / Exit(N) ");
										input1 = input.next();

									} while(input1.equalsIgnoreCase("Y"));

									System.out.println("\n(Added Stock (Clothes))");
									System.out.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
									System.out.println("--------------------------------------------------------------------------------");

									write.println("\n(Added Stock (Clothes))");
									write.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
									write.println("--------------------------------------------------------------------------------");

									for (int i=0; i < counter;i++) {

										write.println(""+cloth.getProductID(i)+" \t"+cloth.getBrand(i)+" \t"+cloth.getPrice(i)+" \t"+cloth.getDiscount(i)+" \t\t"+cloth.getSize(i)+"\t"+cloth.getQuantity(i));
										System.out.println(""+cloth.getProductID(i)+" \t"+cloth.getBrand(i)+" \t"+cloth.getPrice(i)+" \t"+cloth.getDiscount(i)+" \t\t"+cloth.getSize(i)+"\t"+cloth.getQuantity(i));
									}

									break;



								case 2:

									String input2;
									int counter1 = 0;


									do {
										System.out.println("====================================================");
										System.out.println("\n--------------------SHOES STOCK-------------------");

										System.out.print("\nEnter ProductID: ");
										String productId1 = input.next();

										System.out.print("Enter the Price: $");
										double Price1 = input.nextDouble();

										System.out.print("Enter the Product Brand: ");
										String brand1 = input.next();

										System.out.print("Enter the Discount (%): ");
										Double discount1 = input.nextDouble();

										System.out.print("Enter the Shoes Size: ");
										String Size1 = input.next();

										System.out.print("Enter the Quantity of the stock Available: ");
										int quantity1 = input.nextInt();

										shoes.addQuantity(quantity1);
										shoes.addProductID(productId1);
										shoes.addPrice(Price1);
										shoes.addBrand(brand1);
										shoes.addDiscount(discount1);
										shoes.addSize(Size1);
										System.out.println(" ");
										counter1++;

										System.out.println("Continue (Y) / Exit(N) ");
										input2 = input.next();


									} while(input2.equalsIgnoreCase("Y"));

									System.out.println("\n(Added Stock (Shoes))");
									System.out.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
									System.out.println("--------------------------------------------------------------------------------");

									for (int i=0; i < counter1;i++) {

										write.println(""+shoes.getProductID(i)+" \t"+shoes.getBrand(i)+" \t"+shoes.getPrice(i)+" \t"+shoes.getDiscount(i)+" \t\t"+shoes.getSize(i)+"\t"+shoes.getQuantity(i));
										System.out.println(""+shoes.getProductID(i)+" \t"+shoes.getBrand(i)+" \t"+shoes.getPrice(i)+" \t"+shoes.getDiscount(i)+" \t\t"+shoes.getSize(i)+"\t"+shoes.getQuantity(i));
									}

									break;

								case 3:

									String inputcap;
									int counter2 = 0;

									do {
										System.out.println("====================================================");
										System.out.println("\n--------------------CAP STOCK-------------------");

										System.out.print("\nEnter ProductID: ");
										String productId2 = input.next();

										System.out.print("Enter the Price: $");
										double Price2 = input.nextDouble();

										System.out.print("Enter the Product Brand: ");
										String brand2 = input.next();

										System.out.print("Enter the Discount (%): ");
										Double discount2 = input.nextDouble();

										System.out.print("Enter the Caps Size: ");
										String Size2 = input.next();

										System.out.print("Enter the Quantity of the stock Available: ");
										int quantity2 = input.nextInt();

										caps.addQuantity(quantity2);
										caps.addProductID(productId2);
										caps.addPrice(Price2);
										caps.addBrand(brand2);
										caps.addDiscount(discount2);
										caps.addSize(Size2);
										System.out.println(" ");
										counter2++;

										System.out.println("Continue (Y) / Exit(N) ");
										inputcap = input.next();
									} while(inputcap.equalsIgnoreCase("Y"));

									System.out.println("\n(Added Stock (Caps)");
									System.out.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
									System.out.println("--------------------------------------------------------------------------------");

									for (int i=0; i < counter2;i++) {

										write.println(""+caps.getProductID(i)+" \t"+caps.getBrand(i)+" \t"+caps.getPrice(i)+" \t"+caps.getDiscount(i)+" \t\t"+caps.getSize(i)+"\t"+caps.getQuantity(i));
										System.out.println(""+caps.getProductID(i)+" \t"+caps.getBrand(i)+" \t"+caps.getPrice(i)+" \t"+caps.getDiscount(i)+" \t\t"+caps.getSize(i)+"\t"+caps.getQuantity(i));
									}
									break;




								case 4:

									String input4;
									int counter3 = 0;

									do {
										System.out.println("====================================================");
										System.out.println("\n--------------------STOCKINGS STOCK-------------------");

										System.out.print("\nEnter ProductID: ");
										String productId3 = input.next();

										System.out.print("Enter the Price: $");
										double Price3 = input.nextDouble();

										System.out.print("Enter the Product Brand: ");
										String brand3 = input.next();

										System.out.print("Enter the Discount (%): ");
										Double discount3 = input.nextDouble();

										System.out.print("Enter the Socks Size: ");
										String Size3 = input.next();

										System.out.print("Enter the Quantity of the stock Available: ");
										int quantity3 = input.nextInt();


										socks.addQuantity(quantity3);
										socks.addProductID(productId3);
										socks.addPrice(Price3);
										socks.addBrand(brand3);
										socks.addDiscount(discount3);
										socks.addSize(Size3);
										System.out.println(" ");
										counter3++;

										System.out.println("Continue (Y) / Exit(N) ");
										input4 = input.next();
									} while (input4.equalsIgnoreCase("Y"));

									System.out.println("\n(Added Stock (Socks)");
									System.out.println("\nID \tBrand \tPrice \tDiscount \tSize \tQuantity");
									System.out.println("--------------------------------------------------------------------------------");

									for (int i=0; i < counter3;i++) {

										write.println(""+socks.getProductID(i)+" \t"+socks.getBrand(i)+" \t"+socks.getPrice(i)+" \t"+socks.getDiscount(i)+" \t\t"+socks.getSize(i)+"\t"+socks.getQuantity(i));
										System.out.println(""+socks.getProductID(i)+" \t"+socks.getBrand(i)+" \t"+socks.getPrice(i)+" \t"+socks.getDiscount(i)+" \t\t"+socks.getSize(i)+"\t"+socks.getQuantity(i));
									}
								} break;


								//---------------------------------------------------7)REMOVING STOCKS-------------------------------------------------------------------

							case 2 : 
								System.out.println("\n--------------------REMOVING STOCK--------------------");
								System.out.println("1. Clothes \t2. Shoes \n3. Cap     \t4. Stockings");
								System.out.print("\nENTER THE SELECTED NUMBER: ");
								int addingInput1 = input.nextInt();

								switch (addingInput1) {

								case 1: 

									String loop;
									do {
										System.out.println("--------------------------------REMOVING CLOTHES STOCK--------------------------------");
										System.out.println("\nWarning!!, Removing Stock will completely remove your data (Depends on ID)");
										System.out.print("\nDo you still want to continue? (Y/N): ");
										String Decision = input.next();
										if (Decision.equalsIgnoreCase("N")) {
											break;
										}
										System.out.print("\nEnter Product ID: ");
										String ID = input.next();

										System.out.println("\nProduct ID: "+cloth.getProductID(cloth.getindex(ID))+"\tPrice: "+cloth.getPrice(cloth.getindex(ID))+"\tBrand: "+cloth.getBrand(cloth.getindex(ID))+"\tDiscount "+cloth.getDiscount(cloth.getindex(ID))+"\tSize: "+
												cloth.getSize(cloth.getindex(ID)));

										System.out.print("\nRemoving Stock Confirm? (Y/N): ");
										String confirm =input.next();
										if (confirm.equalsIgnoreCase("N")) {
											break;
										}

										cloth.removeProductID(cloth.getindex(ID));
										cloth.removePrice(cloth.getindex(ID));
										cloth.removeBrand(cloth.getindex(ID));
										cloth.removeDiscount(cloth.getindex(ID));
										cloth.removeSize(cloth.getindex(ID));
										cloth.removeQuantity(cloth.getindex(ID));

										System.out.println("\n********** Removing Stock Completed **********");
										System.out.print("\nDo You Want To Quit (Y/N)?: ");
										loop = input.next();
									} while (loop.equalsIgnoreCase("N")); break;


								case 2: 
									String loop1;
									do {
										System.out.println("--------------------------------REMOVING SHOES STOCK--------------------------------");
										System.out.println("\nWarning!!, Removing Stock will completely remove your data (Depends on ID)");
										System.out.print("\nDo you still want to continue? (Y/N): ");
										String Decision = input.next();
										if (Decision.equalsIgnoreCase("N")) {
											break;
										}
										System.out.print("\nEnter Product ID: ");
										String ID = input.next();

										System.out.println("\nProduct ID: "+shoes.getProductID(shoes.getindex(ID))+"\tPrice: "+shoes.getPrice(shoes.getindex(ID))+"\tBrand: "+shoes.getBrand(shoes.getindex(ID))+"\tDiscount: "+shoes.getDiscount(shoes.getindex(ID))+"\tSize: "+
												shoes.getSize(shoes.getindex(ID)));

										System.out.print("\nRemoving Stock Confirm? (Y/N): ");
										String confirm =input.next();
										if (confirm.equalsIgnoreCase("N")) {
											break;
										}

										shoes.removeProductID(shoes.getindex(ID));
										shoes.removePrice(shoes.getindex(ID));
										shoes.removeBrand(shoes.getindex(ID));
										shoes.removeDiscount(shoes.getindex(ID));
										shoes.removeSize(shoes.getindex(ID));
										shoes.removeQuantity(shoes.getindex(ID));

										System.out.println("\n********** Removing Stock Completed **********");
										System.out.print("\nDo You Want To Quit (Y/N)?: ");
										loop1 = input.next();
									} while (loop1.equalsIgnoreCase("N")); break;

								case 3:
									String loop2;
									do {
										System.out.println("--------------------------------REMOVING CAP STOCK--------------------------------");
										System.out.println("\nWarning!!, Removing Stock will completely remove your data (Depends on ID)");
										System.out.print("\nDo you still want to continue? (Y/N): ");
										String Decision = input.next();
										if (Decision.equalsIgnoreCase("N")) {
											break;
										}
										System.out.print("\nEnter Product ID: ");
										String ID = input.next();

										System.out.println("\nProduct ID: "+caps.getProductID(caps.getindex(ID))+"\tPrice: "+caps.getPrice(caps.getindex(ID))+"\tBrand: "+caps.getBrand(caps.getindex(ID))+"\tDiscount: "+caps.getDiscount(caps.getindex(ID))+"\tSize: "+
												caps.getSize(caps.getindex(ID)));

										System.out.print("\nRemoving Stock Confirm? (Y/N): ");
										String confirm =input.next();
										if (confirm.equalsIgnoreCase("N")) {
											break;
										}

										caps.removeProductID(caps.getindex(ID));
										caps.removePrice(caps.getindex(ID));
										caps.removeBrand(caps.getindex(ID));
										caps.removeDiscount(caps.getindex(ID));
										caps.removeSize(caps.getindex(ID));
										caps.removeQuantity(caps.getindex(ID));

										System.out.println("\n********** Removing Stock Completed **********");
										System.out.print("\nDo You Want To Quit (Y/N)?: ");
										loop2 = input.next();
									} while (loop2.equalsIgnoreCase("N")); break;

								case 4:
									String loop3;
									do {
										System.out.println("--------------------------------REMOVING STOCKINGS STOCK--------------------------------");
										System.out.println("\nWarning!!, Removing Stock will completely remove your data (Depends on ID)");
										System.out.print("\nDo you still want to continue? (Y/N): ");
										String Decision = input.next();
										if (Decision.equalsIgnoreCase("N")) {
											break;
										}
										System.out.print("\nEnter Product ID: ");
										String ID = input.next();

										System.out.println("\nProduct ID: "+socks.getProductID(socks.getindex(ID))+"\tPrice: "+socks.getPrice(socks.getindex(ID))+"\tBrand: "+socks.getBrand(socks.getindex(ID))+"\t Discount: "+socks.getDiscount(socks.getindex(ID))+"\tSize: "+
												socks.getSize(socks.getindex(ID)));

										System.out.print("\nRemoving Stock Confirm? (Y/N): ");
										String confirm =input.next();
										if (confirm.equalsIgnoreCase("N")) {
											break;
										}

										socks.removeProductID(socks.getindex(ID));
										socks.removePrice(socks.getindex(ID));
										socks.removeBrand(socks.getindex(ID));
										socks.removeDiscount(socks.getindex(ID));
										socks.removeSize(socks.getindex(ID));
										socks.removeQuantity(socks.getindex(ID));

										System.out.println("\n********** Removing Stock Completed **********");
										System.out.print("\nDo You Want To Quit (Y/N)?: ");
										loop3 = input.next();
									} while (loop3.equalsIgnoreCase("N")); break;
								}

								break;



								//---------------------------------------------------8)SEARCHING STOCKS-------------------------------------------------------------------

							case 3 : 

								String input5;

								do {
									System.out.println("\n-------------------------------SEARCHING STOCK--------------------------------");
									System.out.print("Please Enter The Product ID: ");
									String ID = input.next();

									if (cloth.getSearchID(cloth.getindex(ID)) != null){
										System.out.println(cloth.getSearchID(cloth.getindex(ID)));
									}

									else if (shoes.getSearchID(shoes.getindex(ID)) != null){
										System.out.println(shoes.getSearchID(shoes.getindex(ID)));
									}

									else if (caps.getSearchID(caps.getindex(ID)) != null){
										System.out.println(caps.getSearchID(caps.getindex(ID)));
									}
									else if (socks.getSearchID(socks.getindex(ID)) != null){
										System.out.println(socks.getSearchID(socks.getindex(ID)));
									}

									else {
										System.out.println("\n Product Not Found");
										break;
									}

									System.out.print("\nDo you want to continue(Y) / Exit (N): ");
									input5 = input.next();

								} while(input5.equalsIgnoreCase("Y"));break;

							}

						}

					}
					write.close();
				}


			}


			//=====================================9) PRODUCT SALES SYSTEM (CASHIER TEST APP)===========================================================================================


			else if (selection.equalsIgnoreCase("C")){

				File Invoice = new File("Invoice (Cashier).text");

				FileWriter fileWriter = new FileWriter(Invoice,false);
				PrintWriter write2 = new PrintWriter (fileWriter);


				System.out.println("\n\nProduct Sales System");
				System.out.println("-----------------------------------------------------");
				System.out.print("Please Enter Your Name: ");
				String UserInput = input.next();


				Cashier cashier = new Cashier();
				cashier.setName(UserInput);
				numberOfCashier += 1;
				cashier.setNumberOfCashier(numberOfCashier);

				//====================================10) FileWriter(CASHIER)==========================================================================================================

				write2.println("\nINVOICE \n------------------------------------------------");
				write2.println("\n"+User1.getDate());
				write2.println("Cashier: "+cashier.getName());
				write2.println("\nProductID \tPrice \tBrand \tDiscount \tSize \tQuantity\n---------------------------------------------------------------");

				//=========================================================================================================================================================


				System.out.println("\n\tWelcome Back!, "+cashier.getName());
				System.out.println("     *****************************");

				double price = 0;
				int totalQuantity = 0;

				String Decision;
				do {

					System.out.print("\nPlease Enter the Product ID: ");
					String ID = input.next();

					System.out.print("Quantity: ");
					int productQuantity = input.nextInt();
					totalQuantity += productQuantity;


					if (ID.matches(cloth.getProductID(cloth.getindex(ID)))) {

						//text=================================================================================

						write2.println("\n"+cloth.getProductID(cloth.getindex(ID))+"\t\t$"+cloth.getPrice(cloth.getindex(ID))
						+"\t"+cloth.getBrand(cloth.getindex(ID))+"\t"+cloth.getDiscount(cloth.getindex(ID))+"\t\t"+cloth.getSize(cloth.getindex(ID))+"\t"+productQuantity);

						//Console=================================================================================
						System.out.println(cloth.getSearchID(cloth.getindex(ID)));
						price += cloth.getAmount(cloth.getindex(ID))*productQuantity;
						System.out.println("\n"+cloth.refundable());

						cloth.addQuantity(cloth.getindex(ID),cloth.getQuantity(cloth.getindex(ID))-productQuantity);



					}
					else if (ID.matches(shoes.getProductID(shoes.getindex(ID)))){

						//text===================================================================================

						write2.println("\n"+shoes.getProductID(shoes.getindex(ID))+"\t\t$"+shoes.getPrice(shoes.getindex(ID))
						+"\t"+shoes.getBrand(shoes.getindex(ID))+"\t"+shoes.getDiscount(shoes.getindex(ID))+"\t\t"+shoes.getSize(shoes.getindex(ID))+"\t"+productQuantity);


						//Console=================================================================================

						System.out.println(shoes.getSearchID(shoes.getindex(ID)));
						price += shoes.getAmount(shoes.getindex(ID))*productQuantity;
						System.out.println("\n"+shoes.refundable());

						shoes.addQuantity(shoes.getindex(ID),shoes.getQuantity(shoes.getindex(ID))-productQuantity);

					}

					else if (ID.matches(caps.getProductID(caps.getindex(ID)))){

						//text===================================================================================

						write2.println("\n"+caps.getProductID(caps.getindex(ID))+"\t\t$"+caps.getPrice(caps.getindex(ID))
						+"\t"+shoes.getBrand(caps.getindex(ID))+"\t"+caps.getDiscount(caps.getindex(ID))+"\t\t"+caps.getSize(caps.getindex(ID))+"\t"+productQuantity);

						//Console=================================================================================

						System.out.println(caps.getSearchID(caps.getindex(ID)));
						price += caps.getAmount(caps.getindex(ID))*productQuantity;

						caps.addQuantity(caps.getindex(ID),caps.getQuantity(caps.getindex(ID))-productQuantity);
					}

					else if (ID.matches(socks.getProductID(socks.getindex(ID)))){

						//text===================================================================================

						write2.println("\n"+socks.getProductID(socks.getindex(ID))+"\t\t$"+socks.getPrice(socks.getindex(ID))
						+"\t"+socks.getBrand(socks.getindex(ID))+"\t"+socks.getDiscount(socks.getindex(ID))+"\t\t"+socks.getSize(socks.getindex(ID))+"\t"+productQuantity);

						//Console=================================================================================

						System.out.println(socks.getSearchID(socks.getindex(ID)));
						price += socks.getAmount(socks.getindex(ID))*productQuantity;

						socks.addQuantity(socks.getindex(ID),socks.getQuantity(socks.getindex(ID))-productQuantity);

					}

					else {
						System.out.println("Product Not Found");
					}

					System.out.print("\nContinue(Y) / Exit(X): ");
					Decision = input.next();

				} while (Decision.equalsIgnoreCase("Y"));


				//=========================================11) SUMMARY (CONSOLE)======================================================================

				System.out.printf("\nTotal Price: $%.2f%n",price);
				System.out.print("Enter Cash: $");
				double cash = input.nextDouble();
				cashier.setCash(cash);
				System.out.print("Balance: $");
				System.out.printf("%.2f%n",cash - price);

				//==========================================12) PROCESSING INVOICE===================================================================

				System.out.println("Commision: "+cashier.getNumberOfCashier()+". "+cashier.getName());
				System.out.println("\n## Processing Invoice ##");
				System.out.println("\nFile Exist: "+Invoice.exists());
				System.out.println("Absolute Path: "+Invoice.getAbsolutePath());
				System.out.println("File name: "+Invoice.getName());

				//=========================================13) SUMMARY (PLAIN TEXT)======================================================================

				write2.println("---------------------------------------------------------------");
				write2.println("\nTotal Quantity: x "+totalQuantity);
				write2.printf("Total Price   : $%.2f%n",price);
				write2.println("Cash          : $"+cashier.getCash());
				write2.printf("\nBalance       : $%.2f%n",cashier.getCash()-price );
				write2.println("Commision     : "+cashier.getNumberOfCashier()+". "+cashier.getName());

				write2.close();


			}

		}

	}
}

