package examples.oopAdvanced_2.barriers;

import examples.oopAdvanced_2.subjects.Subject;

public class Wall implements Barrier {

    public static int numbers = 0;
    private int height;
    public boolean isPassed;

    public Wall(int height) {
        numbers++;
        this.height = height;
    }

    @Override
    public boolean contest(Subject subject) {
        isPassed = subject.jump(height);
        if(isPassed){
            System.out.println( subject.toString() + " jump this!!!");
        } else {
            System.out.println( subject.toString() + " cannot jump.");
        }
        return isPassed;
    }

    @Override
    public boolean isPassed() {
        return isPassed;
    }

    public static void printNumbersOfInstance() {
        String className = "Wall";
        System.out.println("Numbers of " + className + " " + numbers);
    }

}
