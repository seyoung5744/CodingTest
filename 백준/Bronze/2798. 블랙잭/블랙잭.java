import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] nums = new int[N];
        String[] numsStr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (num <= M) {
                        max = Math.max(num, max);
                    }
                }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
