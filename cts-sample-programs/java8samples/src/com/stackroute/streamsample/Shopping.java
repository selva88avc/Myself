package com.stackroute.streamsample;

public class Shopping {

	  String userName;
	  String city;
	  String product;
	  int price;
	  boolean isPaid;
	  int deliverydays;
	  
	  public int getDeliverydays() {
		return deliverydays;
	}
	public void setDeliverydays(int deliverydays) {
		this.deliverydays = deliverydays;
	}
	public Shopping()
	  {
		  
	  }
	public Shopping(String userName, String city, String product, int price, boolean isPaid, int deliverydays) {
		super();
		this.userName = userName;
		this.city = city;
		this.product = product;
		this.price = price;
		this.isPaid = isPaid;
		this.deliverydays = deliverydays;
	}
	@Override
	public String toString() {
		return "Shopping [userName=" + userName + ", city=" + city + ", product=" + product + ", price=" + price
				+ ", isPaid=" + isPaid + "]" + " delay " + deliverydays ;
	}
	public Shopping(String userName, String city, String product, int price, boolean isPaid) {
		super();
		this.userName = userName;
		this.city = city;
		this.product = product;
		this.price = price;
		this.isPaid = isPaid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	  
}
