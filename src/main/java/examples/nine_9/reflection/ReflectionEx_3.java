package examples.nine_9.reflection;

public class ReflectionEx_3 {

	public static void main(String[] args) {
		
		/*
		Class stringClass = "java".getClass();
		System.out.println(stringClass);
		*/
	
		Class integerClass = Integer.class;
		System.out.println(integerClass);
		
		Class stringClass = String.class;
		System.out.println(stringClass);

		Class intClass = int.class;
		System.out.println(intClass);

		Class charArrayClass = char[][].class;
		System.out.println(charArrayClass);
		
		Class voidClass = void.class;
		System.out.println(voidClass);
	}
	
	
}
