import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        merge_sort(0, arr.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void merge_sort(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(left, mid);
        merge_sort(mid + 1, right);

        merge(left, mid, right);
    }

    public static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            } else {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx] = arr[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = arr[l];
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }

}
