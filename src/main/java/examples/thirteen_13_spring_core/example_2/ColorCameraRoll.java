package examples.thirteen_13_spring_core.example_2;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
public class ColorCameraRoll implements CameraRoll {

    @Override
    public void processing() {
        System.out.println("1 - цветной кадр");
    }
}
