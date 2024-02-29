package com.estsoft.hellospring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.estsoft") // 스캔할 패키지를 명시
public class MyConfiguration {
    // 이 코드는 지금 옵셔널하게 스캔의 범위를 정한다 ?? 아무튼..
    // 여기 나온... 컴포넌트 스캔 애노테이션 덕분에
    // @RestController 애노테이션을 걸어둔 컨트롤러를 비롯한 무수한 녀석들이 스캔의 대상이 되고

}
