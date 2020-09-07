package com.example.and.designPatterns.singletonPattern;

/**
 * 其实这种写法是线程不安全的，当一个线程还没有实例化Singleton时
 * 另一个线程执行到if(instance==null)这个判断语句时就会进入if语句，虽然加了锁，
 * 但是等到第一个线程执行完instance=new Singleton()跳出这个锁时，
 * 另一个进入if语句的线程同样会实例化另外一个Singleton对象。
 *
 * @program: and
 * @description: 单例模式懒汉式加锁[线程不安全，不可用]
 * @author: and
 * @create: 2020-09-07 10:11
 **/
public class lazyLoading3 {
    private static lazyLoading3 instance = null;

    public static lazyLoading3 getInstance() {

        if (instance == null) {
            synchronized (lazyLoading3.class) {

                return new lazyLoading3();
            }
        }

        return instance;
    }
}
