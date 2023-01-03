import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] times = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(times[0]);
            time[i][1] = Integer.parseInt(times[1]);
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1]? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int answer = 0;
        int cur = 0;
        for (int i = 0; i < N; i++) {
            if (cur <= time[i][0]) {
                cur = time[i][1];
                answer++;
            }
        }
        
        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
