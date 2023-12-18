import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 200_000

        int[][] mem = new int[str.length()][26];

        mem[0][str.charAt(0) - 'a'] += 1;

        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                mem[i][j] = mem[i - 1][j];
            }
            mem[i][str.charAt(i) - 'a'] += 1;
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) { // 200_000
            String[] tokens = br.readLine().split(" ");
            int target = tokens[0].charAt(0) - 'a';
            int start = Integer.parseInt(tokens[1]);
            int end = Integer.parseInt(tokens[2]);

            if (start == 0) {
                sb.append(mem[end][target]).append("\n");
            } else {
                sb.append(mem[end][target] - mem[start - 1][target]).append("\n");
            }
        }

        System.out.println(sb);
    }

}
