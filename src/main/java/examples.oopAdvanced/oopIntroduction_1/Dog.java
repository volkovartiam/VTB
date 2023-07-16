package examples.oopAdvanced.oopIntroduction_1;

public class Dog extends Animal {

    public static int numbersOfInstance;
    int runDistance = 500;
    int swimDistance = 10;

    public Dog(String name){
        super(name);
        numbersOfInstance++;
    }

    @Override
    public void run(int distance) {
        if(distance <= runDistance){
            super.run(distance);
        } else {
            System.out.println(name + " is Dog and he can run only " + runDistance + " m." +
                    "Not all distance " + distance + "m.");
        }

    }

    @Override
    public void swim(int distance) {
        if(distance <= swimDistance){
            super.run(distance);
        } else {
            System.out.println(name + " is Dog and he can swim only " + swimDistance + " m." +
                    "Not all distance " + distance + "m.");
        }
    }

    public static void printNumbersOfInstance() {
        System.out.println("Numbers of Dogs " + numbersOfInstance);
    }
}
