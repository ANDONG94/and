package com.example.and.designPatterns.factory;

import org.junit.Test;

/**
 * 简单工厂模式严格意义上来说，并不属于设计模式中的一种，不过这里还是简单记录下。
 * <p>
 * 定义：由一个工厂对象决定创建出哪一种类型实例。客户端只需传入工厂类的参数，无心关心创建过程。
 * <p>
 * 优点：具体产品从客户端代码中抽离出来，解耦。
 * <p>
 * 缺点：工厂类职责过重，增加新的类型时，得修改工程类得代码，违背开闭原则。
 *
 * @program: and
 * @description: 简单工厂模式
 * @author: and
 * @create: 2020-09-07 14:45
 **/
public class simpleFactory {

    //新建Fruit抽象类，包含eat抽象方法：
    abstract class fruit {

        public abstract void eat();

    }

    //其实现类Apple：
    class Apple extends fruit {

        @Override
        public void eat() {
            System.out.println("吃苹果");
        }
    }

    //其实现类Orange：
    class Orange extends fruit {

        @Override
        public void eat() {
            System.out.println("吃橘子");
        }
    }

    //新建创建Fruit的工厂类
    class FruitFactory {
        public fruit produce(String name) {

            if ("Apple".equals(name)) {

                return new Apple();
            } else {
                return new Orange();
            }

        }
    }

    @Test
    public void test() {

        FruitFactory fruitFactory = new FruitFactory();
        fruit apple = fruitFactory.produce("Apple");
        apple.eat();
    }
}
