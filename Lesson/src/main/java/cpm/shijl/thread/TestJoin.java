package cpm.shijl.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 *
 * join  方法测试
 */
public class TestJoin {

    static int a = 10;
    static int b = 0;

    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                5,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1024));
        Runnable runnable1 = () -> {
            a = 100;
            //当前线程执行结束，调用latch.countDown();
            latch.countDown();
        };
        Runnable runnable2 = () -> {
            b = 20;
            latch.countDown();
        };
        poolExecutor.submit(runnable1);
        poolExecutor.submit(runnable2);
        try {
            //latch.await(); 等待所有调用latch.countDown(); 方法的线程执行结束
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        poolExecutor.shutdownNow();
        System.out.println("a == "+a);
        System.out.println("b == "+b);
    }
}
