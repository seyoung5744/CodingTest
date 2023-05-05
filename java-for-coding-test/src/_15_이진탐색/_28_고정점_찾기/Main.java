package _15_이진탐색._28_고정점_찾기;

import java.util.*;

/*
5
-15 -6 1 3 7

7
-15 -4 2 8 9 13 15

7
-15 -4 3 8 9 13 15

 */
public class Main {

//    public static int binarySearch(int[] arr, int start, int end){
//        while(start <= end){
//            int mid = (start + end) / 2;
//
//            if(arr[mid] == mid){
//                return mid;
//            }else if(arr[mid] > mid){
//                end = mid - 1;
//            }else{
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }

    public static int binarySearch(int[] arr, int start, int end){
        if(start > end)
            return -1;

        int mid = (start + end) /2;

        if(arr[mid] == mid) return mid;
        else if(arr[mid] > mid) return binarySearch(arr, start, mid - 1);
        else return binarySearch(arr, mid+1, end);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(binarySearch(arr, 0, n - 1));
    }
}
