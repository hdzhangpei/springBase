package com.zhangpei.spring.base;

import com.zhangpei.spring.base.bean.UseInitializingBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * 测试InitializingBean
 * 实现InitializingBean接口,可以在spring容器托管bean时,进行初始化.
 */
@SpringBootTest
class UseInitializingBeanTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        UseInitializingBean useInitializingBean = (UseInitializingBean) applicationContext.getBean("useInitializingBean");
        useInitializingBean.print();
    }

}
