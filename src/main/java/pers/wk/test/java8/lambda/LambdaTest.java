package pers.wk.test.java8.lambda;

/**
 * @description:
 * @author: wuke
 * @create: 2019-06-08 15:30
 **/
public class LambdaTest {
    public static void main(String[] args) {
        printResult(1, 2, (a, b) -> a + b);
        printResult(1, 2, (a, b) -> a * b);
    }

    public static void printResult(int a, int b, MathOperation o) {
        System.out.println(o.operation(a, b));
    }
}


