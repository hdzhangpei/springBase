package com.zhangpei.spring.base.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean(name = "testService1")
    public TestService getTestService1() {
        TestService testService = new TestService();
        return testService;
    }

    @Bean(name = "testService2")
    @ConditionalOnClass(TestService.class)
    public TestService getTestService2() {
        TestService testService = new TestService();
        return testService;
    }

    @Bean(name = "testService3")
    @ConditionalOnMissingClass({"com.zhangpei.spring.base.condition.TestService"})
    public TestService getTestService3() {
        TestService testService = new TestService();
        return testService;
    }

    @Bean(name = "testService4")
    @ConditionalOnExpression("${isCreate:true}")
    public TestService getTestService4() {
        TestService testService = new TestService();
        return testService;
    }

    @Bean(name = "testService5")
    @ConditionalOnExpression("${num}==1")
    public TestService getTestService5() {
        TestService testService = new TestService();
        return testService;
    }

    @Bean(name = "testService6")
    @ConditionalOnExpression("'${name}'.equals('zhangpei')")
    public TestService getTestService6() {
        TestService testService = new TestService();
        return testService;
    }
}
