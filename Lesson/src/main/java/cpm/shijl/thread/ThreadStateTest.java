package cpm.shijl.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 *
 * 线程的六种状态(在Java API层面)
 */
@Slf4j
public class ThreadStateTest {

    public static void main(String[] args) {

        //NEW
        Thread t1 = new Thread(() -> {

        }, "t1");

        //RUNNABLE
        Thread t2 = new Thread(() -> {
            while (true) {
            }
        }, "t2");
        t2.start();

        //TERMINATED
        Thread t3 = new Thread(() -> {
        }, "t3");
        t3.start();

        //TIMED_WAITING
        Thread t4 = new Thread(() -> {
            synchronized (ThreadStateTest.class){
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t4");
        t4.start();

        //WAITING
        Thread t5 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t5");
        t5.start();

        //BLOCKED
        Thread t6 = new Thread(() -> {
            synchronized (ThreadStateTest.class){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t6");
        t6.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("t1 state : {}",t1.getState());
        log.info("t2 state : {}",t2.getState());
        log.info("t3 state : {}",t3.getState());
        log.info("t4 state : {}",t4.getState());
        log.info("t5 state : {}",t5.getState());
        log.info("t6 state : {}",t6.getState());
    }
}
