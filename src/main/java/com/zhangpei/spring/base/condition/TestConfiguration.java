package com.zhangpei.spring.base.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class TestConfiguration {

    @Bean(name = "testService")
    @ConditionalOnMissingClass(value = "TestService.class")
    public TestService getTestService() {
        TestService testService = new TestService();
        return testService;
    }
}
