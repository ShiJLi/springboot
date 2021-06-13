package cpm.shijl.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Administrator
 *
 * park
 */
@Slf4j
public class ParkTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        Thread t1 = new Thread(() -> {
            log.info("lock  part ...");
            //打断标记为false时候，park方法有效
            LockSupport.park();
            log.info("unlock  park...");
            log.info("打断状态：{}",Thread.currentThread().isInterrupted());
            //改变打断标记为false
            Thread.interrupted();
            log.info("打断状态：{}",Thread.currentThread().isInterrupted());
            LockSupport.park();
            log.info("unlock  park...");
        }, "t1");

        t1.start();

        t1.interrupt();

    }
}
