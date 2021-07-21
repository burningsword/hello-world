package pers.wk.test;

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringTest {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomAlphanumeric(8).toLowerCase());
    }
}
