package pers.wk.test.java8.dynamicproxy;

public class Dog implements Animal {
    @Override
    public String sayHello(String str) {
        return "wang!wang!wang!";
    }
}
