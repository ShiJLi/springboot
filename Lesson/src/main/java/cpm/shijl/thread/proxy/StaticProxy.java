package cpm.shijl.thread.proxy;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Administrator
 *
 *
 * 静态代理
 */
public class StaticProxy {

    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());

        new WeddingCompany(new You()).happyMarry();
        new Thread(()->{
            System.out.println("Runnable");
        }).start();

        weddingCompany.happyMarry();
    }

}

interface Marry{

    void happyMarry();
}

class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("marry happy");
    }
}


class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        target.happyMarry();
    }
}
