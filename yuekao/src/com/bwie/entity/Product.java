package com.bwie.entity;

public class Product {
	
	
	  private   int  id;
	  private   String  productname;
	  private   int  price;
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname
				+ ", price=" + price + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
