package org.espire.vendingmachine;

public class VendingExample {
	// add coins
		public int drop(String coins, int total)
		{
		
			if(coins.equals("NICKLE")){
				total = total + Coin.NICKLE.getDenom();
			}else if(coins.equals("DIME")){
				total = total + Coin.DIME.getDenom();
			}else if(coins.equals("QUARTER")){
				total = total + Coin.QUARTER.getDenom();
			}else if(coins.equals("DOLLAR")){
				total = total + Coin.DOLLAR.getDenom();
			}else{
				System.out.println("Wrong Input Coin");
			}
		
			return total;
		}

		
		//select items
		public int choose(String sample, int total)
		{
			if(sample.equals("COKE")){
				System.out.println("You have selected "+Item.COKE.getName());
				if(total>=Item.COKE.getPrice()){
					total = total - Item.COKE.getPrice();
					System.out.println("Thank you for your purchase!! ");
					System.out.println("Your balance is "+total);
				}else{
					System.out.println("Insert more coins ");
					return 2;
				}
				
			}else if(sample.equals("CANDY")){
				System.out.println("You have selected "+Item.CANDY.getName());
				if(total>=Item.CANDY.getPrice()){
					total = total - Item.CANDY.getPrice();
					System.out.println("Thank you for your purchase!! ");
					System.out.println("Your balance is "+total);
				}else{
					System.out.println("Insert more coins ");
					return 2;
				}
			}else if(sample.equals("CHIPS")){
				System.out.println("You have selected "+Item.CHIPS.getName());
				if(total>=Item.CHIPS.getPrice()){
					total = total - Item.CHIPS.getPrice();
					System.out.println("Thank you for your purchase!! ");
					System.out.println("Your balance is "+total);
				}else{
					System.out.println("Insert more coins ");
					return 2;
				}
			}else if(sample.equals("RETURN")){
				System.out.println("Your balance is "+total+" and is returned.");
				return 1;
			}else if(sample.equals("CANCEL")){
				return -1;
			}else{
				System.out.println("Wrong choice: Your balance is "+total);
				return 1;
			}
		
			return total;
		}
	}

