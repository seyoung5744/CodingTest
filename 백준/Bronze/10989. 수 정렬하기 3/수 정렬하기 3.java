import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr; // 수열의 원소
    public static int[] counting = new int[10_001]; // 수의 범위 1~10,000
    public static int[] result; // 정렬된 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // array 의 value 값을 index 로 하는 counting 배열 값 1 증가
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        // 누적 합 해주기 
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        /*
         *  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤
         *  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value] -= 1;
            result[counting[value]] = value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
