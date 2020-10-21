package pers.wk.test.java8.classloading;

public interface TestInterface {

    default void testDef() {
        System.out.println(112233);
    }
}
