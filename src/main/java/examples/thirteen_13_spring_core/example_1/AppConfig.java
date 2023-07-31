package examples.thirteen_13_spring_core.example_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("examples.thirteen_13_spring_core.example_1")
public class AppConfig {


    @Bean(name = "cameraRoll")
    public CameraRoll getCameraRoll(){
        return new ColorCameraRoll();
    }
    /**/

    @Bean(name = "camera")
    public Camera getCamera(CameraRoll cameraRoll){
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
     /**/

}
