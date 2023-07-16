package examples.oopAdvanced_2;

import examples.oopAdvanced_2.subjects.Man;
import examples.oopAdvanced_2.subjects.Subject;

import java.util.ArrayList;

public class OOPAdvanced_Ex1 {

    public static void main(String[] args) {

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Man());

        for(Subject subject : subjects){
            subject.jump(2);
            subject.jump(1);
            subject.jump(3);
            subject.jump(1);
            subject.jump(3);
            subject.jump(2);
        }

        System.out.println("--------------------------------------------------");

        for(Subject subject : subjects){
            subject.run(10);
            subject.run(80);
            subject.run(20);
            subject.run(10);
            subject.run(50);
            subject.run(10);
        }

        Man.printNumbersOfInstance();
    }
}