package cpm.shijl.thread;

/**
 *  模拟龟兔赛跑
 * @author Administrator
 */
public class Race implements Runnable{

    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
                if(Thread.currentThread().getName().equals("乌龟") && i%10 ==0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(gaveOver(i)){
                    break;
                }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();
    }

    private boolean gaveOver(int step){
        if(winner != null){
            System.out.println("比赛结束");
            return true;
        }else {
            if(step >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }
}
