package examples.thirteen_13_spring_core.example_3;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UnproducableCameraRoll {
    Class usingCameraRollClass();
}
