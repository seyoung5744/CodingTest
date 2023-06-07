import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int[] sorted;
    public static ArrayList<Integer> saved = new ArrayList<>();
    public static int n, k, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        sorted = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(0, arr.length - 1);
        if(saved.size() < k){
            System.out.println(-1);
        }else{
            System.out.println(saved.get(k-1));
        }
    }

    public static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            } else {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                r++;
                idx++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                l++;
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
            saved.add(sorted[i]);
        }
    }

}
