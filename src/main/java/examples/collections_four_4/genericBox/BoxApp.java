package examples.collections_four_4.genericBox;

public class BoxApp {

	public static void main(String[] args) {
		
		Box<Apple> box = new Box(); 
		box.addFruit(new Apple());
		box.addFruit(new Apple());
		System.out.println("Weight of box = " + box.getWeight());

		Box<Orange> box1 = new Box(); 
		box1.addFruit(new Orange());
		box1.addFruit(new Orange());
		System.out.println("Weight of box1 = " + box1.getWeight());

		System.out.println("Boxes has equals weights = " + box.compare(box1));
		System.out.println("-----------------------------------------------------");

		Box<Apple> box2 = new Box(); 
		box2.addFruit(new Apple());
		box2.addFruit(new Apple());
		box2.addFruit(new Apple());
		box.addFromBoxes(box2);
		System.out.println("Weight of box = " + box.getWeight());
		System.out.println("Size of box2 = " + box2.fruits.size() );
		System.out.println("-----------------------------------------------------");
		
		box1.addFromBoxes(box);
		System.out.println("Weight of box1 = " + box1.getWeight());
		
	}
}
