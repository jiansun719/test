package com.sun.domain;

public class Goods {

	private int id;
	private String name;
	private double price;
	
	public Goods(){}
	
	public Goods(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		
		return "[id:"+this.id+",name:"+this.name+",price:"+this.price+"]";
	}
	
}
