package com.example.and.designPatterns.factory;

import org.junit.Test;

import java.util.function.Function;

/**
 * 为了解决简单工厂模式的缺点，诞生了工厂方法模式（Factory method pattern）。
 * <p>
 * 定义：定义创建对象的接口，让实现这个接口的类来决定实例化哪个类，工厂方法让类的实例化推迟到了子类进行。
 * <p>
 * 优点：
 * <p>
 * 具体产品从客户端代码中抽离出来，解耦。
 * <p>
 * 加入新的类型时，只需添加新的工厂方法（无需修改旧的工厂方法代码），符合开闭原则。
 * <p>
 * 缺点：类的个数容易过多，增加复杂度。
 *
 * @program: and
 * @description: 工厂方法模式
 * @author: and
 * @create: 2020-09-07 14:57
 **/
public class methodFactory {
    /**
     * 新建Fruit抽象类，包含eat抽象方法：
     */
    abstract class Fruit {
        public abstract void eat();
    }

    /**
     * 新建FruitFactory抽象工厂，定义produceFruit抽象方法：
     */
    abstract class FruitFactory {
        public abstract Fruit produceFruit();
    }

    /**
     * 新建Fruit的实现类，Apple：
     */
    class Apple extends Fruit {

        @Override
        public void eat() {
            System.out.println("吃蘋果");
        }
    }

    /**
     * 新建Fruit的实现类，Orange：
     */
    class Orange extends Fruit {

        @Override
        public void eat() {
            System.out.println("吃橘子");
        }
    }

    /**
     * 新建FruitFactory的实现类AppleFruitFactory，用于生产具体类型的水果 —— 苹果：
     */
    class AppleFactory extends FruitFactory {

        @Override
        public Fruit produceFruit() {
            return new Apple();
        }
    }

    /**
     * 新建FruitFactory的实现类OrangeFactory，用于生产具体类型的水果 —— 橘子：
     */
    class OrangeFactory extends FruitFactory {

        @Override
        public Fruit produceFruit() {
            return new Orange();
        }
    }

    @Test
    public void test() {
        //蘋果
        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.produceFruit();
        fruit.eat();
        //橘子
        FruitFactory orangeFactory = new OrangeFactory();
        Fruit fruit1 = orangeFactory.produceFruit();
        fruit.eat();
    }


}
