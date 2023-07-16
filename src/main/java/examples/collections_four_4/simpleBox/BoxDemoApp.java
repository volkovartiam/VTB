package examples.collections_four_4.simpleBox;

public class BoxDemoApp {

	public static void main(String[] args) {
		SimpleBox intBox1 = new SimpleBox(20);
		SimpleBox intBox2 = new SimpleBox(30);

		if(intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {
			int sum = (Integer) intBox1.getObj()  +  (Integer) intBox2.getObj() ;
			System.out.println( "sum = " + sum );
		} else {
			System.out.println("Different type of containers");
		}

		/*
		RunTime Exception
		intBox1.setObj("Java");
		int secondSum = (Integer) intBox1.getObj()  +  (Integer) intBox2.getObj();
		 */

	}

}
