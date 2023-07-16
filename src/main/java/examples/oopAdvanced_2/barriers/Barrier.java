package examples.oopAdvanced_2.barriers;


import examples.oopAdvanced_2.subjects.Subject;

public interface Barrier {
    boolean contest(Subject subject);
    boolean isPassed();

}
