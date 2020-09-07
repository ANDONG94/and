package com.example.and.designPatterns.singletonPattern;

import org.junit.Test;

import java.util.Date;

/**
 * @program: and
 * @description: 单例模式调用测试
 * @author: and
 * @create: 2020-09-07 09:52
 **/
public class singletonPatternTest {

    @Test
    public void singletonPatternTest() {

        //单例模式勤加载
        industrious instance = industrious.getInstance();
        instance.ad();
        System.out.println(instance.date());
        //单例模式勤加载2
        industrious2 instance1 = industrious2.getInstance();
        //单列模式懒加载线程不安全
        lazyLoading instance2 = lazyLoading.getInstance();
        //单列模式懒加载线程安全但效率低 加锁
        lazyLoading2 instance3 = lazyLoading2.getInstance();
        //单列模式懒加载线程线程不安全 加锁
        lazyLoading3 instance4 = lazyLoading3.getInstance();
        //单例模式懒汉式双重校验锁
        lazyLoading4 instance5 = lazyLoading4.getInstance();
        //单例模式内部类
        innerClass instance6 = innerClass.getInstance();
        //单例模式枚举
        Date method = singletonEnum.instance.method();
        System.out.println(method);
    }


}
