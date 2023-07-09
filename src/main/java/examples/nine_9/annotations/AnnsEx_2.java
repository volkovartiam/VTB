package examples.nine_9.annotations;

import java.lang.reflect.Method;

public class AnnsEx_2 {

	@AdvancedAnnotation(value = 20.0f )
	public void advAnnotatedMethod() {
		System.out.println( "..." );
	}
	
	public static void main(String[] args) {
		try {
			Method m = AnnsEx_2.class.getMethod( "advAnnotatedMethod" , null );
			AdvancedAnnotation annotation =  m.getAnnotation(AdvancedAnnotation.class);
			System.out.println( "value: " + annotation.value());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
