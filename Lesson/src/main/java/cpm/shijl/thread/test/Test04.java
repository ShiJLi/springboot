package cpm.shijl.thread.test;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * <p>
 * 线程消息队列
 */
@Slf4j
public class Test04 {

    private static final Integer PRODUCER_THREAD_NUM = 3;
    private static final Integer CONSUMER_THREAD_NUM = 1;

    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        for (int i = 0; i < PRODUCER_THREAD_NUM; i++) {
            int id = i;
            threadPoolExecutor.submit(() -> {
                messageQueue.put(new Message(id, "值 "+id));
            });
        }
        for (Integer integer = 0; integer < CONSUMER_THREAD_NUM; integer++) {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageQueue.get();
            }
        }
        threadPoolExecutor.shutdown();
    }
}

/**
 * 队列
 */
@Slf4j
class MessageQueue {
    /**
     * 队列 双向链表
     */
    private LinkedList<Message> list = new LinkedList<>();
    /**
     * 队列容量
     */
    private Integer capcity;

    public MessageQueue(Integer capcity) {
        this.capcity = capcity;
    }

    /**
     * 队列添加消息
     *
     * @param message
     */
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capcity) {
                try {
                    log.info("队列已满");
                    //队列已满
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //添加在尾部
            list.addLast(message);
            log.info("队列添加一条消息");
            list.notifyAll();
        }
    }

    /**
     * 消费消息
     *
     * @return
     */
    public Message get() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    log.info("队列为空...");
                    //队列为空
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //返回消息头第一个消息
            Message message = list.removeFirst();
            log.info("已消费一个消息");
            list.notifyAll();
            return message;
        }

    }
}

@Slf4j
@Getter
@ToString
final class Message {

    private int id;
    /**
     * 消息内容
     */
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }
}
