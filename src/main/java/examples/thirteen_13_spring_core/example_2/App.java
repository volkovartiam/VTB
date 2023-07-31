package examples.thirteen_13_spring_core.example_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("thirteen_spring_core/config_three.xml");
        Camera camera = context.getBean("camera", Camera.class );
        camera.doPhotograph();
    }
}
