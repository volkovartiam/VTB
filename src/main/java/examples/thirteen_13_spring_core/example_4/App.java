package examples.thirteen_13_spring_core.example_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("thirteen_spring_core/new_config_one.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloMan man = context.getBean("man", HelloMan.class );
        man.helloSay();

    }
}
