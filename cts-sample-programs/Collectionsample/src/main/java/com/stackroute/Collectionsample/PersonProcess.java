package com.stackroute.Collectionsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PersonProcess {

	public static void main(String[] args) {
 
		ArrayList<Person> personlist=new ArrayList<Person>();
		
		
		
		
		LinkedList<Person> personlink=new LinkedList<Person>();
		
		
		personlist.add(new Person(10,"Lakshmi",23));
		personlist.add(new Person(20,"Usha",33));
		
		
		ListIterator<Person> iterate=personlist.listIterator();
		
		
	   while(iterate.hasNext())
	   {
		   Person person=iterate.next();
		   if(person.getAge()<25)
			   iterate.remove();
	   }
	   
	   
		
		Collections.sort(personlist);
		
		
		personlist.removeIf( person -> person.getAge()<=24);
		
		
		personlink.addFirst(new Person(30,"Harish",31));
		
	   //json objects sorted and displayed
		
		Map<String, String> jsonobj=new TreeMap<>();
		
		
		jsonobj.put("app1", "{\"name\":\"cts\",\"location\":\"agra\"}");
		jsonobj.put("chn1", "{\"name\":\"niit\",\"location\":\"chennai\"}");
		jsonobj.put("blore", "{\"name\":\"cts\",\"location\":\"blore\"}");
		
		jsonobj.forEach( (k,v) -> System.out.println( "key " + k + "value " + v ));
		
		
		
		Set<Person> mydata =new LinkedHashSet<Person>();
		mydata.add(new Person(10,"Lakshmi",13));
		mydata.add(new Person(20,"mary",93));
		mydata.add(new Person(50,"Roopa",63));

		
		 
		System.out.println(mydata);
		
		
	}

}
