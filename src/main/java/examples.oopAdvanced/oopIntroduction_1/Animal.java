package examples.oopAdvanced.oopIntroduction_1;

public abstract class Animal {

    String name;
    public void run(int distance){
        System.out.println(name + " can run " + distance + " m." );
    }
    public void swim(int distance){
        System.out.println(name + " can swim " + distance + " m." );
    }

    Animal(String name){
        this.name = name;
    }

}
