import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        boolean[] visited = new boolean[n];

        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            nums[i - 1] = i;
        }

        int count = 0;
        int idx = 0;
        while (answer.size() < n) {
            idx %= n;

            if (!visited[idx]) {
                count++;
                if (count == k) {
                    answer.add(nums[idx]);
                    visited[idx] = true;
                    count= 0;
                }
            }

            idx += 1;
        }


        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));

            if (i < answer.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);

        bw.flush();
        br.close();
        bw.close();
    }

}
