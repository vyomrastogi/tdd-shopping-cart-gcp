package com.vr;

public enum Item {

	WALLET("Wallet",10.0),
	BABRA_ELITE("Babra Elite",15.0),
	PERFUME("Perfume",8.0),
	SHOES("Shoes",20.0),
	LAPTOP("Laptop",110.99);
	
	private String name;
	private double price;
	
	private Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
