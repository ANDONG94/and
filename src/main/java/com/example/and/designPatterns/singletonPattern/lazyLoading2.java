package com.example.and.designPatterns.singletonPattern;

/**
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。
 * 方法进行同步效率太低要改进。
 * @program: and
 * @description: 懒汉式线程安全的[线程安全，效率低不推荐使用]
 * @author: and
 * @create: 2020-09-07 10:02
 **/
public class lazyLoading2 {
    private static lazyLoading2 instance=null;

    private lazyLoading2() {};

    public static synchronized lazyLoading2 getInstance(){

        if(instance==null){
            instance=new lazyLoading2();
        }
        return instance;
    }

}
