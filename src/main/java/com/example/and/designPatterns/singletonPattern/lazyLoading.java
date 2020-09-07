package com.example.and.designPatterns.singletonPattern;

/**
 *
 *
 * @program: and
 * @description: 单例模式的懒汉式[线程不安全，不可用]
 * @author: and
 * @create: 2020-09-07 09:56
 **/
public class lazyLoading {

    private static lazyLoading instance=null;

    private lazyLoading() {};

    public static lazyLoading getInstance(){

        if(instance==null){
            instance=new lazyLoading();
        }
        return instance;
    }
}
