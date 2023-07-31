package examples.thirteen_13_spring_core.example_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        /*
        Camera camera = new Camera();
        camera.setCameraRoll(new ClolorCameraRoll() );
        camera.setCameraRoll(new BlackAndWhiteCameraRoll());
        camera.doPhotograph();
         */

//        ApplicationContext context = new ClassPathXmlApplicationContext("config_three.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera", Camera.class );
        camera.doPhotograph();

    }
}
