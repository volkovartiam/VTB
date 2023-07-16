package examples.oopAdvanced.oopIntroduction_1;

public class OOPIntroduction_Ex1  {

    public static void main(String[] args) {

        Animal catBarsic = new Cat("Barsik");
        catBarsic.run(200);
        catBarsic.swim(200);

        Animal catBegemot = new Cat("Begemot");
        catBegemot.run(220);
        catBegemot.swim(200);

        Animal dog = new Dog("Sharic");
        dog.run(1000);
        dog.swim(20);


        Cat.printNumbersOfInstance();
        Dog.printNumbersOfInstance();
    }
}