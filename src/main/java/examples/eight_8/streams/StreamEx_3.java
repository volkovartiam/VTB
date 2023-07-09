package examples.eight_8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx_3 {

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
	}
	
	public static void main(String[] args) {
		
		/*Create array with words and using Stream API find most common*/
		Stream<String> stream = Stream.of("A","A","A","A","A", "B","B","B","B", "C", "C", "D" );
		Map<String, Long> map = stream.collect(Collectors.groupingBy(Function.identity() , Collectors.counting() ));
		System.out.println(map);
		
		long max = map.entrySet().stream()
			.max( Map.Entry.comparingByValue() )
			.map( Map.Entry::getValue )
			.orElse(0L);
		System.out.println(max);

		List list = map.entrySet().stream()
				.filter( e -> e.getValue().equals(max ) )
				.map(Map.Entry::getKey)
				.collect( Collectors.toList() );
		System.out.println(list);
		System.out.println("------------------------------------------------------------");

		/*Calculate average salary*/
		Person[] persons = { 	new Person( "Bob1" , 35 , 10000 ),
								new Person( "Bob2" , 44 , 20000 ),
								new Person( "Bob3" , 25 , 30000 ),
								new Person( "Bob4" , 42 , 40000 ),
								new Person( "Bob5" , 55 , 50000 ),
								new Person( "Bob6" , 19 , 60000 ),
								new Person( "Bob7" , 33 , 5000 ),
								new Person( "Bob8" , 37 , 1000 )     };
		Arrays.stream(persons)
			.map((Function<Person, Integer>) person -> person.salary)
			.mapToInt(n -> n)
			.average()
			.ifPresent(System.out::println);


		/* Pring the oldest preson*/
		System.out.println("------------------------------------------------------------");
		int nMostAgedPerson = 5;
		String st = Arrays.stream( persons )
			.sorted( (o1, o2) -> o2.age - o1.age )
			.map( (Function<Person, String>) person -> person.name )
			.limit( nMostAgedPerson )
			.collect( Collectors.joining(", ", "N most oldest persons: ", "." ) );
		System.out.println(st);
	}
}
