package com.stackroute;

public class Product {
	
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", cost=" + cost + "]";
	}
	public Product()
	{
		
	}
	public Product(String pname, int cost) {
		super();
		this.pname = pname;
		this.cost = cost;
	}
	String pname;
	int cost;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public static String setStatus(int cost)
	{
		
		if (cost>5000)
			return "Costly";
		else
			return "Affordable";
	}
	
	public boolean view(int cost)
	{
		if (cost>100)
			return true;
		else
			return false;
	}

}


class FoodProduct extends Product
{

	public FoodProduct(String pname, int cost) {
		super(pname, cost);
		// TODO Auto-generated constructor stub
	}
	
	
}

class TechnicalProduct extends Product
{
	
}
