package com.example.and.designPatterns.singletonPattern;

import java.util.Date;

/**
 *
 * 优点：从它的实现中我们可以看到，这种方式的实现比较简单，在类加载的时候就完成了实例化，避免了线程的同步问题。
 *
 * 缺点：由于在类加载的时候就实例化了，所以没有达到Lazy Loading(懒加载)的效果，也就是说可能我没有用到这个实例，但是它
 *
 * 也会加载，会造成内存的浪费(但是这个浪费可以忽略，所以这种方式也是推荐使用的)。
 *
 * @program: and
 * @description: 单例模式的饿汉式[可用]
 * @author: and
 * @create: 2020-09-07 09:46
 *
 **/
public class industrious {


    private static industrious instance = new industrious();

    private industrious() {
    }

    public static industrious getInstance() {
        return instance;
    }

    public void ad(){
        System.out.println("1");
    }
    public Date date(){

        return new Date();
    }
}
