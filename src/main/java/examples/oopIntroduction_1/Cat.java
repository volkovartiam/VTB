package examples.oopIntroduction_1;

public class Cat extends Animal{

    public static int numbersOfCats;
    final int runDistance = 200;

    public Cat(String name){
        super(name);
        numbersOfCats++;
    }

    @Override
    public void run(int distance) {
        if(distance <= runDistance){
            super.run(distance);
        } else {
            System.out.println(name + " is Cat and he can run only " + runDistance + " m." +
                    "Not all distance " + distance + "m.");
        }

    }

    @Override
    public void swim(int distance) {
        System.out.println(this.name + " is Cat and he cannnot swim.");
    }

    public static void printNumbersOfInstance() {
        System.out.println("Numbers of Cats " + numbersOfCats);
    }
}
