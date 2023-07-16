package examples.oopAdvanced.oopIntroduction_1;

public class OOPIntroduction_Ex2 {

    public static void main(String[] args) {

        Animal[] animals = new Animal[5];
        animals[0] = new Cat("Barsik");
        animals[1] = new Cat("Begemot");
        animals[2] = new Dog("Sharic");
        animals[3] = new Dog("Bobic");
        animals[4] = new Cat("Barsik");

        for (int i =0; i < animals.length; i++){
            System.out.println( i + "-----------------");
            animals[i].run(500);
            animals[i].swim(500);
        }

        System.out.println("-------------------------------------------------------");

        Cat.printNumbersOfInstance();
        Dog.printNumbersOfInstance();
    }
}