package com.epsoft.tessreact.java8.lambdaAndStream;



import com.epsoft.tessreact.java8.util.Dk10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: api
 * @description: stream
 * <p>
 * <p>
 * 1. Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * <p>
 * 2.
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * 3.Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤、映射、...)
 * ③ 终止操作
 * <p>
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * @author: and
 * @create: 2020-07-16 16:19
 **/

public class streamApi {

    //创建Stream、应用中间件、终止操作

    public static void list() {





        /***创建Stream**********************************************通过集合创建Stream*******************************************/
        List<Dk10> list = new Dk10().listDk10();
        Stream<Dk10> stream = list.stream();
        Stream<Dk10> dk10Stream = list.parallelStream();

        /***应用中间件**********************************************执行筛选与切片***********************************************/

        //filter(Predicate p)——接收 Lambda ， 从流中排除某些元素
        stream.filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5).forEach(System.out::println);
        //limit(n)——截断流，使其元素不超过给定数量。
        list.stream().filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5)
                .limit(3).forEach(System.out::println);
        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5)
                .skip(3).forEach(System.out::println);
        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.stream().filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5).
                distinct().forEach(System.out::println);

        /***应用中间件**************************************************映射*****************************************************/

        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        list.stream().map(Dk10::getAac002).filter(aac002 -> Integer.parseInt(aac002.substring(17, 1)) > 5)
                .limit(3).forEach(System.out::println);
        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Arrays.asList("aa", "bb", "cc", "dd").stream().flatMap(streamApi::fromStringToStream).forEach(System.out::println);

        /***应用中间件**************************************************排序*****************************************************/

        //sorted()——自然排序
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        list.stream().sorted(Dk10::compareTo).forEach(System.out::println);
        list.stream().sorted(Comparator.comparing(Dk10::getAac002)).forEach(System.out::println);

        /***终止操作**********************************************匹配与查找*****************************************************/

        //allMatch(Predicate p)——检查是否匹配所有元素。
        System.out.println(list.stream().allMatch(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5));
        //anyMatch(Predicate p)——检查是否至少匹配一个元素。
        System.out.println(list.stream().anyMatch(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5));
        //noneMatch(Predicate p)——检查是否没有匹配的元素。
        System.out.println(list.stream().noneMatch(dk10 -> dk10.getAac003().startsWith("张")));
        //findFirst——返回第一个元素
        Optional<Dk10> first = list.stream().findFirst();
        System.out.println(first);
        //findAny——返回当前流中的任意元素
        Optional<Dk10> any = list.stream().findAny();
        System.out.println(any);
        //count——返回当前流中的总个数
        long count = list.stream().count();
        System.out.println(count);
        //max(Comparator c)——返回流中最大值
        Optional<Dk10> max = list.stream().max(Comparator.comparing(Dk10::getAac002));
        System.out.println(max);
        //min(Comparator c)——返回流中最小值
        Optional<Dk10> min = list.stream().min(Comparator.comparing(Dk10::getAac002));
        System.out.println(min);
        //forEach(Consumer c)——内部迭代
        list.stream().forEach(System.out::println);

        /***终止操作**********************************************归约********************************************************/

        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        list.stream().map(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1))).reduce(0,Integer::sum);
        // reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        list.stream().map(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1))).reduce(Integer::sum);

        /***终止操作**********************************************收集********************************************************/

        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        List<Dk10> collect = list.stream().filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5).collect(Collectors.toList());
        Set<Dk10> collect1 = list.stream().filter(dk10 -> Integer.parseInt(dk10.getAac002().substring(17, 1)) > 5).collect(Collectors.toSet());
    }


    ///2.通过数组创建Stream
    public static void array() {

        int[] ints = new int[]{};
        IntStream stream = Arrays.stream(ints);

        //自定义数组
        Dk10[] dk10s;
        dk10s = new Dk10().arrayDk10();
        Stream<Dk10> stream1 = Arrays.stream(dk10s);
    }

    //3.通过Stream创建Stream
    public static void streamOf() {
        //自定义数组
        List<Dk10> list = new Dk10().listDk10();
        Stream.of(list);
    }


    //创建 Stream方式四：创建无限流
    public void unlimited() {

        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }



    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();

    }

}
