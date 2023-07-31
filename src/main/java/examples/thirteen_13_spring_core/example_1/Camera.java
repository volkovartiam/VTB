package examples.thirteen_13_spring_core.example_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("camera")
public class Camera {

    private CameraRoll cameraRoll;
    //private CameraRoll cameraRoll = new CameraRoll();

    Camera(){

    }

    Camera(CameraRoll cameraRoll){
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Autowired
    @Qualifier("cameraRoll")
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph(){
        System.out.println("Щелк");
        cameraRoll.processing();
    }


}
