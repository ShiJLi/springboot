package cpm.shijl.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 多线程下载文件
 */
public class TestThread extends Thread{

    private String url;
    private String name;

    public TestThread(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
    }

    public static void main(String[] args) {
        new TestThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=.jpg%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=36850&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2156271884%2C4153213391&os=3061058879%2C3544324240&simid=28657909%2C655465806&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=.jpg%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201210%2F31%2F201109q0hl590q1z7ls5a0.jpg%26refer%3Dhttp%3A%2F%2Fattach.bbs.miui.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1623846067%26t%3D3ede2bc5fc4310509e19606ed8bdc45f&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B4t7t_z%26e3Bv54AzdH3Fu5674_z%26e3Brir%3F451%3Detjopi6jw1%26pt1%3Dbdcncd%26jxp6w%3Drw2j%25nDdaa%26561j6pyrj%3D8&gsm=2&islist=&querylist=",
                "1.jpg").start();
        new TestThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=.jpg%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=36850&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2156271884%2C4153213391&os=3061058879%2C3544324240&simid=28657909%2C655465806&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=.jpg%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201210%2F31%2F201109q0hl590q1z7ls5a0.jpg%26refer%3Dhttp%3A%2F%2Fattach.bbs.miui.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1623846067%26t%3D3ede2bc5fc4310509e19606ed8bdc45f&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B4t7t_z%26e3Bv54AzdH3Fu5674_z%26e3Brir%3F451%3Detjopi6jw1%26pt1%3Dbdcncd%26jxp6w%3Drw2j%25nDdaa%26561j6pyrj%3D8&gsm=2&islist=&querylist=",
                "2.jpg").start();
        new TestThread("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=.jpg%E5%9B%BE%E7%89%87&hs=2&pn=1&spn=0&di=36850&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2156271884%2C4153213391&os=3061058879%2C3544324240&simid=28657909%2C655465806&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=.jpg%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201210%2F31%2F201109q0hl590q1z7ls5a0.jpg%26refer%3Dhttp%3A%2F%2Fattach.bbs.miui.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1623846067%26t%3D3ede2bc5fc4310509e19606ed8bdc45f&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B4t7t_z%26e3Bv54AzdH3Fu5674_z%26e3Brir%3F451%3Detjopi6jw1%26pt1%3Dbdcncd%26jxp6w%3Drw2j%25nDdaa%26561j6pyrj%3D8&gsm=2&islist=&querylist=",
                "3.jpg").start();

    }
}

class WebDownLoader{

    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
