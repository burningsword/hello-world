package pers.wk.test.java8.dynamicproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Dog dog = new Dog();

        Object proxy = Proxy.newProxyInstance(Animal.class.getClassLoader(), new Class[]{Animal.class}, new MyInvocationHandler(dog));

        String result = ((Animal) proxy).sayHello("world");
        System.out.println(result);
    }
}
