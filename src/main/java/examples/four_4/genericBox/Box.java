package examples.four_4.genericBox;

import java.util.ArrayList;

public class Box<T extends Fruit> {

	ArrayList<T> fruits = new ArrayList<T>();
	T obj;

	public void addFruit(T fruit) {
		fruits.add(fruit);
		obj = fruit;
	}
	
	public double getWeight() {
		double weight = 0;
		for (T t : fruits) {
			weight = weight + t.getWeight();
		}
		return weight;
	}
	
	public boolean compare(Box box) {
		if(box.getWeight() == this.getWeight()) {
			return true;
		}
		return false;
	}
	
	public void addFromBoxes(Box box) {
		if(box.obj.getClass().equals(this.obj.getClass())  ) {

			ArrayList<T> fruitsFromBoxes = box.fruits; 
			for (T t : fruitsFromBoxes) {
				fruits.add(t);
			}
			fruitsFromBoxes.removeAll(fruitsFromBoxes);
			
		} else {
			System.out.println("In boxes differnts fruits" );
		}
	}
}

