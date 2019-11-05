package com.zhangpei.spring.base.condition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ConditionTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService")
     */
    @Test
    public void test1() {
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.print();
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService")
     */
    @Test
    public void test2() {
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.print();
    }
}
