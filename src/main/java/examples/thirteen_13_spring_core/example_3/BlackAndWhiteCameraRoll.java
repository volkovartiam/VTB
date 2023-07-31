package examples.thirteen_13_spring_core.example_3;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("1-чернобелый кадр");
    }
}
