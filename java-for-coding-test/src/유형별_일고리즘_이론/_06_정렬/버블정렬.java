package 유형별_일고리즘_이론._06_정렬;

import java.util.*;

public class 버블정렬 {

    public static int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {

        for (int i = 1; i < array.length; i++) {

            boolean swapped = false;
            for (int j = 0; j < array.length - i; j++) {
                if(array[j] > array[j+1]){
                    swap(j, j+1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swap(int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
