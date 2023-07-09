package examples.eight_8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx_1 {

	List<String> list = new ArrayList<>(Arrays.asList( "A", "AB", "B" ));
	Stream<String> stream = list.stream();
	
	public static void main(String[] args) {
		String[] array = {"Aaa", "Bbbb", "Cc", "Aa"};
		System.out.println( Arrays.stream(array) 
				.collect(Collectors.averagingInt( s -> s.length() ) ) ) ;
		
		System.out.println( Arrays.stream(array) 
				.filter(str -> str.startsWith( "A" ))
				.collect(Collectors.joining( ", " , "this words [" , "] starts with A." )));


		System.out.println("-----------------------------------------------");
		Stream<String> stream1 = Stream.of("A", "B", "C" );
		stream1.forEach( str -> System.out.print(str) ); 
		
		Stream<String> stream2 = Stream.of("A", "B", "C" );
		stream2.forEach( System.out::print );


		System.out.println("\n"+ "-----------------------------------------------");
		Stream<Integer> stream = Stream.of(1, 2, 3, 24, 24, 5, 6);
		stream.reduce( (i1, i2) -> i1 > i2 ? i1 : i2)
			  .ifPresent(System.out::println );

		Stream<String> stream3 = Stream.of("A","A","A","A", "B","B","B","B", "C", "C", "D" );
		stream3
			.distinct()	
			.forEach( System.out::print );

	}
	
}
