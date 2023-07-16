package examples.oopAdvanced_2.barriers;

import examples.oopAdvanced_2.subjects.Subject;

public class Road implements Barrier {

    public static int numbers = 0;
    private int distance;
    boolean isPassed;

    public Road(int distance) {
        numbers++;
        this.distance = distance;
    }

    @Override
    public boolean contest(Subject subject) {
        isPassed = subject.run(distance);
        if(isPassed){
            System.out.println( subject.toString() + " run this!!!");
        } else {
            System.out.println( subject.toString() + " cannot run.");
        }
        return isPassed;
    }

    @Override
    public boolean isPassed() {
        return isPassed;
    }

    public static void printNumbersOfInstance() {
        String className = "Road";
        System.out.println("Numbers of " + className + " " + numbers);
    }

    @Override
    public String toString() {
        return "Road";
    }
}
