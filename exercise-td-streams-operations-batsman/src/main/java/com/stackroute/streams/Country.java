package com.stackroute.streams;

public class Country {
    String countryCode;
    String name;
    
    public Country() {
	}
    
	public Country(String countryCode, String name) {
		super();
		this.countryCode = countryCode;
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
