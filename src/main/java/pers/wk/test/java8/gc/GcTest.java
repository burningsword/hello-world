package pers.wk.test.java8.gc;

import lombok.Data;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GcTest {

    public static void main(String[] args) {
        Entry e = new Entry(new Apple());
        System.out.println(e.get());
        System.out.println(e);
        System.gc();
        System.out.println(e.get());
        System.out.println(e);
    }

    static class Apple {
        private String id;
    }

    static class Entry extends WeakReference<Apple> {

        public Entry(Apple referent) {
            super(referent);
        }

        public Entry(Apple referent, ReferenceQueue<? super Apple> q) {
            super(referent, q);
        }
    }

    private static void testOom() throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            byte[] bytes = new byte[1024*1024];
            Thread.sleep(500);
        }
    }
}
