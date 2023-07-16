package examples.oopIntroduction_1;

public abstract class Animal {

    protected String name;
    protected void run(int distance){
        System.out.println(name + " can run " + distance + " m." );
    }
    protected void swim(int distance){
        System.out.println(name + " can swim " + distance + " m." );
    }

    Animal(String name){
        this.name = name;
    }

}
