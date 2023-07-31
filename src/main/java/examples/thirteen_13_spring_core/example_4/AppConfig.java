package examples.thirteen_13_spring_core.example_4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("examples.thirteen_13_spring_core.example_4")
public class AppConfig {

    /*
    @Bean(name = "man")
    public HelloMan helloManOnceSay(@Value("Volkov Artem") String name) {
        HelloManOnceSay man = new HelloManOnceSay(name);
        return man;
    }
     */

    /*
    @Bean(name = "man")
    public HelloMan helloManOnceSay(@Value("Volkov Artem") String name) {
        HelloManOnceSay man = new HelloManOnceSay();
        man.setName(name);
        return man;
    }

     */


}
