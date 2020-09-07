package com.example.and.designPatterns.singletonPattern;

/**
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，
 * 我们进行了两次if (instance== null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (instance== null)，直接return实例化对象。
 *
 * 优点：线程安全；延迟加载；效率较高。
 * @program: and
 * @description: 单例模式懒汉式双重校验锁[推荐用]
 * @author: and
 * @create: 2020-09-07 10:15
 **/
public class lazyLoading4 {

    private static lazyLoading4 instance = null;

    public static lazyLoading4 getInstance() {

        if (instance == null) {

            synchronized (lazyLoading4.class) {

                if (instance == null) {
                    return new lazyLoading4();
                }
            }
        }
        return instance;
    }

}
