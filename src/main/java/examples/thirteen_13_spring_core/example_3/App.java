package examples.thirteen_13_spring_core.example_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*
        Camera camera = context.getBean("camera", Camera.class);
        camera.breaking();
        camera.doPhotograph();
        */

        Camera cameraTwo = context.getBean("camera", Camera.class);
        cameraTwo.doPhotograph();
        /**/

    }
}
