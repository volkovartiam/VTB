package examples.eight_8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx_3_AnotherSolution {

	static class Person {
		enum Position {
			ENGINEER, DIRECTOR, MANAGER;
		}

		public String name;
		public int age;
		public int salary;
		public Position position;
		
		public Person (String name, int age, int salary) {
			this.name = name;
			this.age = age;
			this.salary = salary;
			//this .position = position;
		}
	
		public int getSalary() {
			return this.salary;
		}
		
		public String getName() {
			return this.name;
		}
		
	}
	
	
	public static void main(String[] args) {

		/*Create array with words and using Stream API find most common*/
		Stream<String> stream = Stream.of( "B", "B", "B","B","B", "A","A","A","A", "C", "C", "D" );
		System.out.println(
				stream.collect(Collectors.groupingBy(Function.identity() , Collectors.counting() ))
					  .entrySet().stream()
					  .max(Comparator.comparingLong( e -> e.getValue() ) )
					  .get().getKey()  );
		System.out.println("------------------------------------------------------------");


		/*Calculate average salary*/
		Person[] persons = { 	new Person( "Bob1" , 35 , 10000 ),
								new Person( "Bob2" , 44 , 20000 ),
								new Person( "Bob3" , 25 , 30000 ),
								new Person( "Bob4" , 42 , 40000 ),
								new Person( "Bob5" , 55 , 50000 ),
								new Person( "Bob6" , 19 , 50000 ),
								new Person( "Bob7" , 33 , 5000 ),
								new Person( "Bob8" , 37 , 1000 )     };
		Arrays.stream(persons)
			.mapToInt( Person::getSalary )
			.average()
			.ifPresent(System.out::println);
		System.out.println("------------------------------------------------------------");


		/* Pring the oldest preson*/
		int nMostAgedPerson = 5;
		String st = Arrays.stream( persons )
			.sorted( (o1, o2) -> o2.age - o1.age )
			.limit( nMostAgedPerson )	
			.map( Person::getName )
			.collect( Collectors.joining(", ", "N most oldest persons: ", "." ) );
		System.out.println(st);
		
	}
}
