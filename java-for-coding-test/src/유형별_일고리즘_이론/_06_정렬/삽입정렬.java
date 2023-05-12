package 유형별_일고리즘_이론._06_정렬;

import java.util.Arrays;

public class 삽입정렬 {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            
            int j = i - 1;
            while (j >= 0 && target < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = target;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


}
