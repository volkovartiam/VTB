package examples.thirteen_13_spring_core.example_3;

public interface Camera {

    CameraRoll getCameraRoll();
    void setCameraRoll(CameraRoll cameraRoll);

    void doPhotograph();

    void breaking();

    boolean isBroken();

    void ready();
}
