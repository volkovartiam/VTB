package examples.oopAdvanced_2;

import examples.oopAdvanced_2.subjects.Man;
import examples.oopAdvanced_2.subjects.Robot;
import examples.oopAdvanced_2.subjects.Subject;

import java.util.ArrayList;

public class OOPAdvanced_Ex2 {

    public static void main(String[] args) {

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Robot());

        for(Subject subject : subjects){
            subject.jump(2);
            subject.jump(3);
            subject.jump(2);
            subject.jump(8);
            subject.jump(2);
            subject.jump(3);
        }

        System.out.println("--------------------------------------------------");

        for(Subject subject : subjects){
            subject.run(100);
            subject.run(300);
            subject.run(200);
            subject.run(100);
            subject.run(500);
            subject.run(700);
        }

        Man.printNumbersOfInstance();
    }
}