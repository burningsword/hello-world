package pers.wk.test.java8.classloading;

public class MyTest {

    static {
        System.out.println("MyTest static block called");
    }

    public static final String TEST = "test";

    public static void sout(String s) {

    }
}
