import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int target = Integer.parseInt(nc[1]);

        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(points);

        System.out.println(binarySearch(points, target));
    }

    private static int binarySearch(int[] points, int target) {
        int start = 1;
        int end = points[points.length - 1] - points[0] + 1;

        while (start < end) {
            int mid = (end + start) / 2;

            int count = 1;
            int value = points[0];

            for (int i = 1; i < points.length; i++) {
                if(points[i] >= value + mid){
                    value = points[i];
                    count += 1;
                }
            }

            if(count < target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end - 1;
    }

}
