package org.espire.vendingmachine;

public enum Item {
	COKE("COKE", 100), CANDY("CANDY", 65), CHIPS("CHIPS", 50); 
	private String name; 
	private int price; 
	private Item(String name, int price){ 
		this.name = name; this.price = price; 
	} 
	public String getName(){ 
		return name; 
	} 
	public int getPrice(){ 
		return price; 
	} 	
}
