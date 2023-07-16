package examples.nine_9.reflection;
import java.lang.reflect.Modifier;

public class ReflectionEx_1 {

	public static void main(String[] args) {
	
		Class s = String.class;
	
		System.out.println("������ ��� ������ " + s.getName() );
		System.out.println("������� ��� ������ " + s.getSimpleName() );
		System.out.println("toString ��� ������ " + s.toString() );

		
		Class strClass = String.class;
		int modifiers = strClass.getModifiers();
		if (Modifier.isPublic(modifiers)) {
		System.out.println(strClass.getSimpleName() + " - public" );
		}
		if (Modifier.isAbstract(modifiers)) {
		System.out.println(strClass.getSimpleName() + " - abstract" );
		}
		if (Modifier.isFinal(modifiers)) {
		System.out.println(strClass.getSimpleName() + " - final" );
		}
		
		/*
		isPublic(), isPrivate(), isAbstract(), isFinal(), isNative(), isInterface(),
		isSynchronized(), isVolatile(), isStrict(), isTransient(), isProtected(), isStatic().
		*/
		System.out.println("----------------------------------------------------");
		Class cl = String.class;
		do  {
			cl = cl.getSuperclass();
			System.out.println(cl);
		} while (cl != null) ;


		System.out.println("----------------------------------------------------");
		for (Class c : String.class.getInterfaces() ) {
			System.out.println(c);
		}
		
		
	}
	
}
