package examples.thirteen_13_spring_core.example_6;

import examples.thirteen_13_spring_core.example_6.codeCreater.CodeCreator;
import examples.thirteen_13_spring_core.example_6.codeCreater.JavaCodeCreator;
import examples.thirteen_13_spring_core.example_6.generator.AnimalsClassNameGenerator;
import examples.thirteen_13_spring_core.example_6.generator.ClassNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@ComponentScan("examples.thirteen_13_spring_core.example_6")
public class AppConfig {
    /*
    <bean id="javaCodeCreator" class="com.geekbrains.spring.current.JavaCodeCreator">
        <property name="classNameGenerator">
            <ref bean="animalsClassNameGenerator" />
        </property>
    </bean>

    <bean id="simpleBean" class="com.geekbrains.spring.current.SimpleBean"/>
     */

    @Bean
    public CodeCreator javaCodeCreator() {
        JavaCodeCreator codeCreator = new JavaCodeCreator();
        codeCreator.setClassNameGenerator(animalsClassNameGenerator());
        return codeCreator;
    }

    @Bean
    public ClassNameGenerator animalsClassNameGenerator() {
        ClassNameGenerator classNameGenerator = new AnimalsClassNameGenerator();
        return classNameGenerator;
    }

    @Bean
    public SimpleBean simpleBean() {
        SimpleBean simpleBean = new SimpleBean();
        return simpleBean;
    }
}
