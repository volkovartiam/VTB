package examples.thirteen_13_spring_core.example_6;

public class ShapesClassNameGenerator implements ClassNameGenerator {
    public String generateClassName() {
        String[] names = {"Square", "Circle", "Ellipse", "Triangle"};
        return names[(int) (Math.random() * 4)];
    }
}
