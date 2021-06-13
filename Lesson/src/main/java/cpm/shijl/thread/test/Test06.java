package cpm.shijl.thread.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * park  unpark
 *
 * 线程调用park方法，线程进入等待状态(WAITING)
 * 调用unpark方法之后，线程重新进入运行状态(RUNNABLE)
 */
@Slf4j
public class Test06 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.info("t1 thread park");
            LockSupport.park();   //WAITING
            log.info("t1 thread unpark");
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("t1 thread poark status :{}",t1.getState());
        LockSupport.unpark(t1);
        log.info("t1 thread unpark status :{}",t1.getState());
    }
}
