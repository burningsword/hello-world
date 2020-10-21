package pers.wk.test.java8.sorting;


import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};

        int j = array.length;
        while (j > 1) {
            for (int i = 0; i < j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

            List list = new ArrayList();
            for (int i : array) {
                list.add(i);
            }
            System.out.println(list);
            j--;
        }
    }
}
