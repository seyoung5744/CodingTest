import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        arrStr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(arrStr[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            bw.write(binarySearch(arr, target[i]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return 0;
    }
}
