package com.zhangpei.spring.base.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class TestCustomConfiguration implements Condition {

    @Bean(name = "testService10")
    public TestService getTestService10() {
        TestService testService = new TestService();
        return testService;
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println(conditionContext);
        System.out.println(annotatedTypeMetadata);
        return true;
    }
}
