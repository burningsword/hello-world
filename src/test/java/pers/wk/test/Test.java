package pers.wk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        String s = "a&b";
        String[] split = s.split("&");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }


}
