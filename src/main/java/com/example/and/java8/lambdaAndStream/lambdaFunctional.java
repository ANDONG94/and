package com.epsoft.tessreact.java8.lambdaAndStream;

import com.epsoft.tessreact.java8.util.Dk10;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: api
 * @description: lambda表达式、函数式(function)接口、方法引用、构造器引用、数组引用
 *
 * 一、Lambda表达式的使用
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 *      -> :lambda操作符 或 箭头操作符
 *      ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 *      ->右边：lambda体 （其实就是重写的抽象方法的方法体）
 *
 * 3. Lambda表达式的使用：（分为6种情况介绍）
 *
 *    总结：
 *    ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略
 *    ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例
 *
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用 @FunctionalInterface 注解，
 *   这样做可以检查它是否是一个函数式接口。
 *
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 *
 * 二、函数式(function)接口-----> java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * 三、方法引用的使用
 *
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *   方法引用，也是函数式接口的实例。
 *
 * 3. 使用格式：  类(或对象) :: 方法名
 *
 * 4. 具体分为如下的三种情况：
 *    情况1     对象 :: 非静态方法
 *    情况2     类 :: 静态方法
 *
 *    情况3     类 :: 非静态方法
 *
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *    形参列表和返回值类型相同！（针对于情况1和情况2）
 * 四、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 五、数组引用
 *     大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 *
 * @author: and
 * @create: 2020-07-16 14:40
 **/

public class lambdaFunctional {


    //方法引用
    public static Integer function(String str1, String str2) {
        //原始方法
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        //lambda表达式
        Comparator<String> com1 = (ss1, ss2) -> ss1.compareTo(ss2);

        //方法引用
        Comparator<String> com2 = String::compareTo;
        return com2.compare(str1, str2);
    }

    //构造器引用
    public static void Constructor() {
        //原始方法
        Supplier<Dk10> supplier = new Supplier<Dk10>() {
            @Override
            public Dk10 get() {
                return new Dk10();
            }
        };
        System.out.println(supplier.get());

        //lambda表达式
        Supplier<Dk10> supplier2 = () -> new Dk10();
        System.out.println(supplier2.get());

        //构造器引用
        Supplier<Dk10> supplier3 = Dk10::new;
        System.out.println(supplier3.get());
        Dk10 dk10 = supplier3.get();

        //Function
        Function<Dk10, String> function = Dk10::getAac002;
        function.apply(dk10);

        //Function
        Function<String, Dk10> function1 = Dk10::new;
        function1.apply("1231");

        //BiFunction
        BiFunction<String, String, Dk10> function2 = Dk10::new;
        function2.apply("123", "张三");
    }

    //数组引用
    public static void Array() {
        //原始方法
        Function<Integer, String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[0];
            }
        };
        System.out.println(function.apply(10));

        //lambda表达式
        Function<Integer, String[]> function1 =lengh -> new String[lengh];
        System.out.println(function1.apply(10));

        //l数组引用
        Function<Integer, String[]> function2 =String[]::new;
        System.out.println(function2.apply(10));
    }

}
