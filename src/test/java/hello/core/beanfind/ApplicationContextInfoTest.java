package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beenDefinitionNames = ac.getBeanDefinitionNames();
        for (String beenDefinitionName : beenDefinitionNames) {
            Object been = ac.getBean(beenDefinitionName);
            System.out.println("name = "+ beenDefinitionName + " object = "+ been);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beenDefinitionNames = ac.getBeanDefinitionNames();
        for (String beenDefinitionName : beenDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beenDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object been = ac.getBean(beenDefinitionName);
                System.out.println("name = "+ beenDefinitionName + " object = "+ been);
            }
        }
    }

}
