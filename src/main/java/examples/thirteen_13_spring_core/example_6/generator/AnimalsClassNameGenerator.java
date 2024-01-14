package examples.thirteen_13_spring_core.example_6.generator;

public class AnimalsClassNameGenerator implements ClassNameGenerator {
    public String generateClassName() {
        String[] names = {"Cat", "Dog", "Horse", "Bull"};
        return names[(int) (Math.random() * 4)];
    }
}
