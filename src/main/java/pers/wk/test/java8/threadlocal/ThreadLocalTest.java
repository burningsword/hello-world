package pers.wk.test.java8.threadlocal;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("test");

        String value = tl.get();
        tl.remove();

        System.out.println(value);
    }
}
