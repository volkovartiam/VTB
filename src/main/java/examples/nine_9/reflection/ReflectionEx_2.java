package examples.nine_9.reflection;

import java.lang.reflect.Field;

public class ReflectionEx_2 {
	
	public static void main(String[] args) {
		
		System.out.println("Publics fields:");
		Class catClass = Cat.class;
		Field[] fields = catClass.getFields();
		for (Field field : fields) {
			System.out.println("��� ���� � ��� ���� " + field.getType().getName() + " � " + field.getName() );
			//System.out.println( field );
		}

		System.out.println();
		System.out.println("All fields:");
		Field[] privateFields = catClass.getDeclaredFields();
		for (Field field : privateFields) {
			//System.out.println("��� ���� � ��� ���� " + field.getType().getName() + " � " + field.getName() );
			System.out.println( field );
		}
		
		
		try {
			Cat cat = new Cat();
			Field fieldName = cat.getClass().getField( "name" );
			fieldName.set(cat, "������" );
			Field fieldAge = cat.getClass().getField( "age" );
			System.out.println(fieldAge.get(cat));
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
}
