package com.estsoft.hellospring.config;

import com.estsoft.hellospring.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyConfigTest {
    // 우리가 테스트 용도로(@Test) 생성한 이 메서드는..
    @Test
    void configTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
        HelloController helloController = (HelloController) ac.getBean("helloController");
        HelloController helloController2 = (HelloController) ac.getBean("helloController");

        assertTrue(helloController == helloController2); // 이건 걍 같은지 체크?? 의도를 아직 모르겠음

        String[] beans = ac.getBeanDefinitionNames(); // 스캔의 범주에 잡힌 빈들을 알려주고
        for(String bean : beans) {
            System.out.println(bean);
        }
    }
}
