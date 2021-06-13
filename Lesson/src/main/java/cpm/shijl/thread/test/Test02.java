package cpm.shijl.thread.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {

    private static final Object LOCK = new Object();
    private static  boolean hasMok = false;
    private static  boolean hasFood = false;

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (LOCK){
                while (!hasMok){  //
                    try {
                        log.info("has not smock");
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("has smock ??? {}",hasMok);
                if(hasMok){
                    log.info("has smock begin work");
                }
            }
        },"A").start();

        new Thread(() -> {
            synchronized (LOCK){
                while (!hasFood){  //
                    try {
                        log.info("has not food");
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("has food ??? {}",hasFood);
                if(hasFood){
                    log.info("has food begin work");
                }
            }
        },"B").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            synchronized (LOCK){
                hasFood = true;
                log.info("food ...");
                LOCK.notify();
            }
        },"C").start();
    }
}
