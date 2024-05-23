package com.stackroute.streamsample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAccess {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//nio
		Path path=Paths.get("D:\\01-CTS-PDP\\samples\\data.csv");
		BufferedReader breader=Files.newBufferedReader(path);
		
			Stream<String> filecontent=breader.lines();
			
			Predicate<String> predicate= (line)->line.contains("username");
			
			filecontent.filter(predicate.negate()).filter( line-> line.contains("india"))
						.collect(Collectors.toList()).forEach(System.out::println);
		

	}

}
