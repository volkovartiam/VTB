package examples.four_4.generic;

public class GenericDemoApp {

	public static void main(String[] args) {
		GenericTest<String> genStr = new GenericTest<>("Hello");
		genStr.showType();
		System.out.println( "genStr.getObj() " + genStr.getObj() );
		
		GenericTest<Integer> genInt = new GenericTest<>(140);
		genInt.showType();
		System.out.println( "genInt.getObj() " + genInt.getObj() );

		int valueFromGenInt = genInt.getObj();
		String valueFromGenString = genStr.getObj();
		//genInt.setObj("JAVA");
		//genInt = genStr;
	}
}
