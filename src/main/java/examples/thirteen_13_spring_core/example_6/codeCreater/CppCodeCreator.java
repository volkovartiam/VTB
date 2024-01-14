package examples.thirteen_13_spring_core.example_6.codeCreater;

import examples.thirteen_13_spring_core.example_6.generator.ClassNameGenerator;

public class CppCodeCreator implements CodeCreator {
    ClassNameGenerator classNameGenerator;

    public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }

    public String getClassExample() {
        return "public class " + classNameGenerator.generateClassName() + " {\n\n}";
    }

    public CppCodeCreator(ClassNameGenerator classNameGenerator) {
        this.classNameGenerator = classNameGenerator;
    }
}
