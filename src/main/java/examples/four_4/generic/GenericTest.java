package examples.four_4.generic;

public class GenericTest<T>  {

	private T obj;

	public GenericTest(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public void showType() {
		System.out.println("Type T = " + obj.getClass().getName() );
	}
	
}
