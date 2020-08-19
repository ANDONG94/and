package com.example.and.java8;


import com.example.and.java8.util.Dk10;

/**
 *
 * 知识点1：接口中定义的静态方法，只能通过接口来调用。
 * 知识点2：通过实现类的对象，可以调用接口中的默认方法。
 * 		   如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
 * 知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，
 * 		  那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
 * 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
 * 		  那么在实现类没有重写此方法的情况下，报错。-->接口冲突。
 * 		  这就需要我们必须在实现类中重写此方法
 * 知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
 */
public interface interfaceApi {

    //静态方法，只能通过接口来调用。
    static void mode(){
        new Dk10().listDk10().forEach(System.out::println);
    }
    //默认方法 可以通过实现类的对象或实现类重写
    default void mode2(){
        new Dk10().listDk10().stream().limit(3).forEach(System.out::println);
    }
    //抽象方法
    void mode3();
}
