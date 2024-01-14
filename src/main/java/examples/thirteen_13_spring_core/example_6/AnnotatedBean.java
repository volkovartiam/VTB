package examples.thirteen_13_spring_core.example_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnnotatedBean {
    @Autowired
    SimpleBean simpleBean;

    public void example() {
        System.out.println("Annoted bean");
        simpleBean.doSomething();
    }
}
