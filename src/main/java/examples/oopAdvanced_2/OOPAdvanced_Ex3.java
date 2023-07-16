package examples.oopAdvanced_2;

import examples.oopAdvanced_2.barriers.Barrier;
import examples.oopAdvanced_2.barriers.Road;
import examples.oopAdvanced_2.barriers.Wall;
import examples.oopAdvanced_2.subjects.Man;
import examples.oopAdvanced_2.subjects.Robot;
import examples.oopAdvanced_2.subjects.Subject;

import java.util.ArrayList;

public class OOPAdvanced_Ex3 {

    static ArrayList<Barrier> barriers;

    public static void main(String[] args) {

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Man());
        subjects.add(new Robot());

        for(Subject subject : subjects){
            init();
            for (Barrier barrier : barriers) {
                if(!barrier.contest(subject) ) {
                    break;
                }
            }
            showInfo(barriers, subject);
        }
    }

    private static void init(){
        barriers = new ArrayList<>();
        barriers.add(new Wall(1));
        barriers.add(new Wall(2));
        barriers.add(new Wall(2));
        barriers.add(new Wall(2));

        barriers.add(new Road(50));
        barriers.add(new Road(50));
        barriers.add(new Road(50));
    }

    private static void showInfo(ArrayList<Barrier> barriers, Subject subject) {
        System.out.println("For " + subject.toString() + " info ---------------------------------");
        int totalWalls = 0;
        int passedWalls = 0;
        int totalRoads = 0;
        int passedRoads = 0;
        for (Barrier barrier : barriers) {
            if(barrier instanceof Wall){
                totalWalls++;
                if(barrier.isPassed()) {
                    passedWalls++;
                }
            } else if(barrier instanceof Road){
                totalRoads++;
                if(barrier.isPassed()) {
                    passedRoads++;
                }
            }
        }
        System.out.println("Passed walls = " + passedWalls + ". Totals walls " + totalWalls);
        System.out.println("Passed roads = " + passedRoads + ". Totals roads " + totalRoads);
        System.out.println("------------------------------------------------");
    }
}