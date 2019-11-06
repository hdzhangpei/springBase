package com.zhangpei.spring.base.condition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Objects;

@SpringBootTest
public class ConditionTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService1")
     */
    @Test
    public void test1() {
        TestService testService = (TestService) applicationContext.getBean("testService1");
        testService.print();
        Assert.isTrue(Objects.nonNull(testService));
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService2")
     *                       @ConditionalOnClass(TestService.class)  当TestService.class存在时创建.
     */
    @Test
    public void test2() {
        TestService testService = (TestService) applicationContext.getBean("testService2");
        testService.print();
        Assert.isTrue(Objects.nonNull(testService));
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService3")
     *                       @ConditionalOnMissingClass({"com.zhangpei.spring.base.condition.TestService"})  当{"com.zhangpei.spring.base.condition.TestService"}路径下的类不存在时创建.
     * 该条件类存在,所以不创建.
     */
    @Test
    public void test3() {
        try {
            TestService testService = (TestService) applicationContext.getBean("testService3");
        } catch (NoSuchBeanDefinitionException e) {
            Assert.isTrue(true);
        }
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService4")
     *                       @ConditionalOnExpression("${isCreate:true}")
     */
    @Test
    public void test4() {
        TestService testService = (TestService) applicationContext.getBean("testService4");
        System.out.println(testService);
        Assert.isTrue(Objects.nonNull(testService));
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService5")
     *                       @ConditionalOnExpression("${isCreate}==1")
     */
    @Test
    public void test5() {
        TestService testService = (TestService) applicationContext.getBean("testService5");
        System.out.println(testService);
        Assert.isTrue(Objects.nonNull(testService));
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 当getTestService      @Bean(name = "testService6")
     *                       @ConditionalOnExpression("'${name}'.equals('zhangpei')")
     */
    @Test
    public void test6() {
        TestService testService = (TestService) applicationContext.getBean("testService6");
        System.out.println(testService);
        Assert.isTrue(Objects.nonNull(testService));
    }

    /**
     * 当TestConfiguration   @Configuration
     *
     * 实现类 implements Condition 满足条件创建当前类下的Bean
     * 可配合其他@Condition*  使用
     */
    @Test
    public void test10() {
        TestService testService = (TestService) applicationContext.getBean("testService10");
        System.out.println(testService);
        Assert.isTrue(Objects.nonNull(testService));
    }
}
