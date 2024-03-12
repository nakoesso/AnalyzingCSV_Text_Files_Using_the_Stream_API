package com.akoele;

import com.akoele.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVFileAnalysis {

	public static void main(String[] args) {

		
		Path path = Path.of("files/data.csv");
		 try(Stream<String> lines = Files.lines(path)) {

				lines.filter(s -> (!s.startsWith("#")))
						 .flatMap(CSVFileAnalysis::lineToPerson)
						 .forEach(System.out::println);
		 }catch (IOException e){
			 e.printStackTrace();
		 }
		
	}



	private static Stream<Person> lineToPerson(String line) {
		try {
			String[] elements = line.split(";");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];
			
			Person per = new Person(name, age, city);
			return Stream.of(per);
		} catch (Exception e) {
			
		}
		return Stream.empty();
	}
}






