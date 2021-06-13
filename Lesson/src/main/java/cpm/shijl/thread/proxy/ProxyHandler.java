package cpm.shijl.thread.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler{

    interface SayHello {
        void sayHello();
    }

    static class Hello implements SayHello {
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class DynamicProxy implements InvocationHandler{
        private Object object;

        public Object bind(Object object) {
            this.object = object;
            return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoke  before");
            Object result = method.invoke(object);
            System.out.println("invoke  after");
            return result;
        }
    }

    public static void main(String[] args) {
        SayHello hello = (SayHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}




