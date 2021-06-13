package cpm.shijl.thread.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * <p>
 * wait  notify
 */
@Slf4j
public class Test01 {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    log.debug("t1 work");
                    LOCK.wait(3000);
                    log.debug("t1 work over");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("t1 work other");
            }
        }, "t1");
        t1.start();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        synchronized (LOCK){
//            LOCK.notify();
//        }
    }
}
