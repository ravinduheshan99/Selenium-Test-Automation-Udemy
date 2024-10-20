import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test01_stream {
	
	//Count the number of names starting with alphabet A in the list

	//@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		int count=0;
		
		for(int i=0; i<names.size(); i++) {
			String actual = names.get(i);
			
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println("Count of names starting with A : "+count);
	}
	
	//@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		//there is no life for intermediate operation if there is no terminal operation
		//terminal operation will execute only if inter operation (filter) returns true
		//we can create stream
		//how to use filter in stream API
		Long count1 = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Count of names starting with A : "+count1);
		
		//Alternative method
		/*
		Long count2=Stream.of("Abhijeet","Don","Alekhya","Adam","Ram").filter(s->{
			return s.startsWith("A");
		}).count();
		
		System.out.println("Count of names starting with A : "+count2);
		*/
		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
	}

	//@Test
	public void streamMap() {
			
		//print names which have the last letter as "a" with uppercase
		System.out.println("print names which have the last letter as \"a\" with uppercase : ");
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which have first letter as "A" with uppercase and sorted
		System.out.println("print names which have first letter as \"A\" with uppercase and sorted : ");
		List<String> names1 = Arrays.asList("Abhijeet","Don","Alekhya","Adam","Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging 2 different lists
		List<String> names2 = Arrays.asList("Man","Don","Women");
		System.out.println("Merging 2 different lists : ");
		Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		
		List<String> ls = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("First Element : "+ls.get(0));
		
		List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
		//print the unique numbers from this list
		System.out.println("unique numbers from this list");
		numbers.stream().distinct().forEach(s->System.out.println(s));
		//sort the array - 3rd index
		System.out.println("unique numbers from this list then sort the array and print 3rd element");
		List<Integer> li = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
