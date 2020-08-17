package com.epsoft.tessreact.java8;

/**
 * @program: tessreact
 * @description: 注解
 *
 * jdk 8 中注解的新特性：可重复注解、类型注解
 *
 *      1 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *                     ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。
 *
 *      2 类型注解：
 *      ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *      ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 * @author: and
 * @create: 2020-07-17 12:29
 **/
public class Annocation {

}
