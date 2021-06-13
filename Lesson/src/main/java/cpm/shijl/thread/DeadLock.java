package cpm.shijl.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 死锁
 * @author Administrator
 */
public class DeadLock {

    public static void main(String[] args) {
        new MakeUp(0,"灰姑凉").start();
        new MakeUp(1,"白雪公主").start();
    }
}

class Mirror{}

class Lipstick{}

class MakeUp extends Thread{
    /**
     * 两把锁 static修饰保证唯一
     */
    private static Mirror mirror = new Mirror();
    private static Lipstick lipstick = new Lipstick();

    int choice;
    String girlName;

    MakeUp (int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeUp();
    }

    /**
     * 两个线程互相持有对方的锁，造成死锁
     */
    private void makeUp(){
        if(choice == 0){
            synchronized (mirror){
                System.out.println(girlName+"获得mirror锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(girlName+"获得lipstick锁");
                }
            }
        }else {
            synchronized (lipstick){
                System.out.println(girlName+"获得lipstick锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(girlName+"获得mirror锁");
                }
            }
        }
    }

}
