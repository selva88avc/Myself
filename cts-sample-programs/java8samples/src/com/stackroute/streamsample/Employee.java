package com.stackroute.streamsample;

import java.time.LocalDate;

public class Employee {
String name;
LocalDate dob;
LocalDate doj;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public LocalDate getDoj() {
	return doj;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", dob=" + dob + ", doj=" + doj + "]";
}
public void setDoj(LocalDate doj) {
	this.doj = doj;
}
public Employee(String name, LocalDate dob, LocalDate doj) {
	super();
	this.name = name;
	this.dob = dob;
	this.doj = doj;
}
public Employee()
{
	
}

}
