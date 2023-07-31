package examples.thirteen_13_spring_core.example_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("camera")
@Scope("prototype")
public class CameraImpl implements Camera{

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Override
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public void doPhotograph() {
        if(isBroken() ){
            System.out.println("Фотоаппарат сломан");
            return;
        } else {
            System.out.println("Сделана фотография!");
            cameraRoll.processing();
        }
    }

    @Override
    public void breaking() {
       this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    @PostConstruct
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию");
    }


}
