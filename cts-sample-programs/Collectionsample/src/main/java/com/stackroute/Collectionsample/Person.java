package com.stackroute.Collectionsample;

public class Person implements Comparable{
	
 Object o;
	String name;
	int age;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person()
	{
	 
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public Person(int id,String name, int age) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Object o) {
	       Person person2=(Person) o;
	       if(this.age<person2.age)
	    	   	return -1;
	       else if (this.age>person2.age)
	    	   return 1;
	       else
	    	   return 0;
	}
	
	public int hashCode()
	{
		return  id;
		
	}
	
	public boolean equals(Object o2)
	{ 
		  Person p2=(Person) o2;
		  if (this.getId()==p2.getId())
			  return true;
		  else
			  return false;
		
	}

}
