package examples.nine_9.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnsEx_1 {

	@MarkingAnnotation
	public void markedMethod() {
		System.out.println( "Java" );
	}
	
	public static void main(String[] args) {
		Method[] methods = AnnsEx_1.class.getDeclaredMethods();
		for (Method o : methods) {
			if(o.getAnnotation(MarkingAnnotation.class) != null ) {
				System.out.println( o );
				for(Annotation annotation : o.getAnnotations()){
					System.out.println(annotation.annotationType() );
				}
			}
		}
	}

}
