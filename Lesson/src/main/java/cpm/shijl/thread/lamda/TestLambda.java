package cpm.shijl.thread.lamda;


import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {

    @Test
    public void testLambda(){

        /**
         * Function接口
         * 传入a,返回b
         */
        Function<String, String> function = (String a) -> {
            return a + 1;
        };
        System.out.println(function.apply("10"));

        /**
         * Supplier接口
         * 没有传入参数，有返回值
         */
        Supplier<String> supplier = () -> {
            return "a";
        };
        System.out.println(supplier.get());
        /**
         * 断言
         */
        Predicate<String> predicate = (String a) -> {
            return a.toUpperCase().equals("A");
        };
        System.out.println(predicate.test("a"));
        /**
         * 消费
         */
        Consumer<String> consumer = (String a) -> {
            System.out.println("a");
        };
        consumer.accept("a");
    }



    public static void main(String[] args) {

        class Like implements ILike{
            @Override
            public void say() {
                System.out.println(" like lambda");
            }
        }

        ILike like ;
        like =  new Like();
        like.say();

        like = ()->{
            System.out.println("like lambda");
        };
        like.say();
    }


}

/**
 * 函数式接口
 */
@FunctionalInterface
interface ILike{
    void say();
}


@FunctionalInterface
interface ILove{
    /**
     * 1
     * @return
     */
    String happy();
}


