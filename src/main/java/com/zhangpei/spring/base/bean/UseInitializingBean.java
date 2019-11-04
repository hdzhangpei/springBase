package com.zhangpei.spring.base.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class UseInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化Bean,执行方法");
    }


    public void print() {
        System.out.println("执行方法");
    }
}
