package com.example.and.designPatterns.factory;

import org.junit.Test;

/**
 * 抽象工厂模式（Abstract factory pattern）提供了一系列相关或者相互依赖的对象的接口，关键字是“一系列”。
 * <p>
 * 优点：
 * <p>
 * 具体产品从客户端代码中抽离出来，解耦。
 * <p>
 * 将一个系列的产品族统一到一起创建。
 * <p>
 * 缺点：拓展新的功能困难，需要修改抽象工厂的接口；
 * <p>
 * 综上所述，抽象工厂模式适合那些功能相对固定的产品族的创建。
 *
 * @program: and
 * @description: 抽象工厂模式
 * @author: and
 * @create: 2020-09-07 15:15
 **/
public class abstractFactory {

    /**
     * 建水果抽象类Fruit，包含buy抽象方法
     */
    abstract class Fruit {
        public abstract void buy();
    }

    abstract class Price {
        public abstract void pay();
    }

    interface FruitFactory {
        Fruit getFruit();

        Price getPrice();
    }

    class AppleFruit extends Fruit {

        @Override
        public void buy() {
            System.out.println("吃苹果");
        }
    }

    class ApplePrice extends Price {

        @Override
        public void pay() {
            System.out.println("花钱两块钱");
        }
    }

    class AppleFruitFactory implements FruitFactory {

        @Override
        public Fruit getFruit() {
            return new AppleFruit();
        }

        @Override
        public Price getPrice() {
            return new ApplePrice();
        }
    }


    @Test
    public void test() {
        FruitFactory fruitFactory = new AppleFruitFactory();
        fruitFactory.getFruit().buy();
        fruitFactory.getPrice().pay();
    }

}
