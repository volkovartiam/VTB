package examples.thirteen_13_spring_core.example_3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactoryPostProc implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // Получение имен BeanDefinition всех бинов, объявленных пользователем
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        System.out.println();
        System.out.println();
        // Перебор массива для получения доступа к каждому имени
        for(String name: beanDefinitionNames) {
            // Получение BeanDefinition по имени
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            // Вывод информации о BeanDefinition
            // System.out.println(beanDefinition.toString());

            String className = beanDefinition.getBeanClassName();

            try {
                Class<?> beanClass = Class.forName(className);

                /*Пытаемся получить объект аннотации и ее значение,
                 * если класс не содержит данную аннотацию, то метод вернет null
                 */

                UnproducableCameraRoll annotation =
                        (UnproducableCameraRoll) beanClass.getAnnotation(UnproducableCameraRoll.class);
                if(annotation != null){
                    Class usingCameraRollName = annotation.usingCameraRollClass();
                    beanDefinition.setBeanClassName( usingCameraRollName.getName() );
                }

            } catch ( ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println();
    }

}
