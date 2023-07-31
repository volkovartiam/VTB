package examples.thirteen_13_spring_core.example_3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhotocameraTestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Camera ){
            System.out.println("Делаем пробное фото");

            ( (Camera) bean).doPhotograph();
            System.out.println("Отлично работает");
        }

        return bean;
    }
}
