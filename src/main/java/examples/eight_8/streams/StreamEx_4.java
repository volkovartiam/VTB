package examples.eight_8.streams;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx_4 {

	public static void main (String[] args) {
		
		String[] array = { "Aaa" , "Bbbbbb" , "Ccc" };
		System.out.println(Arrays.stream(array)
						.collect(Collectors.averagingInt(s -> s.length())));
		Stream<Integer> stream = Stream.of( 1 , 2 , 3 , 24 , 5 , 6 );
				stream.reduce((i1, i2) -> i1 > i2 ? i1 : i2)
				.ifPresent(System.out::println);

		System.out.println("----------------------------------------------------");
		Stream.of( 1 , 2 , 3 , 4 , 5 , 6 ).
			filter(n -> n % 2 == 0 ).forEach(System.out::print);	
		System.out.println();

		Stream<Integer> stream2 = Stream.of( 1 , 2 , 3 , 4 , 5 , 6 );
		stream2.filter( 
				new Predicate<Integer>() {
					@Override
					public boolean test( Integer integer ) {
						return integer % 3 == 0;
					}
				} 
				)
				.forEach(System.out::print);

		System.out.println();
		System.out.println("----------------------------------------------------");
		Stream.of( "dd2" , "aa2" , "bb1" , "bb3" , "cc4" )
			.filter(s -> {
						  System.out.println( "Filter " + s);
						  return true ;
						})
			.forEach(s -> System.out.println( "Result: " + s));


		System.out.println();
		System.out.println("----------------------------------------------------");
		Stream<String> stream3 = Stream.of( "a1" , "b2" , "a3" , "c4" , "d5" )
				.filter(s -> s.startsWith( "d" ));
		System.out.println( stream3.anyMatch(s -> s.equals("d5") ) );

		Stream<String> stream4 = Stream.of( "a1" , "b2" , "a3" , "c4" , "d5" );
		System.out.println( stream4.noneMatch(s -> s.length()==2 ) );
	}
}
