package examples.thirteen_13_spring_core.example_4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("man")
public class HelloManOnceSay implements HelloMan{

    @Value("Artem")
    private String name;

    public HelloManOnceSay() {
    }

    public HelloManOnceSay(String name) {
        this.name = name;
    }

    @Override
    public void helloSay() {
        System.out.println("Hello " + this.name );
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
