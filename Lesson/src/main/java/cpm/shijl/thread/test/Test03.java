package cpm.shijl.thread.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 *
 * 同步模式 保护性暂停
 *
 * 一个结果需要从一个线程传递到另一个线程，需要他们关联一个 GuardeObject
 * 多个结果，可以使用消息队列
 */
@Slf4j
public class Test03 {

    public static void main(String[] args) {
        GuardedObject guardeObject = new GuardedObject();
        new Thread(()->{
            Object o = guardeObject.get();
            log.info("结果  {}",o);
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardeObject.complete("success");
        },"t2").start();
    }
}

class GuardedObject{
    private Object response;

    public Object get(){
        synchronized (this){
            if(this.response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.response;
        }
    }

    public void complete(Object response){
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }
}
