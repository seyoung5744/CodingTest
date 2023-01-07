import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> heights = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights.add(Integer.parseInt(br.readLine()));
            sum += heights.get(i);
        }

        List<int[]> notIdx = new ArrayList<>();
        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                if (sum - heights.get(i) - heights.get(j) == 100) {
                    notIdx.add(new int[]{i, j});
                }
            }
        }


        int[] answer = new int[7];
        int cnt = 6;
        for (int i = 0; i < heights.size(); i++) {
            if(i != notIdx.get(0)[0] && i != notIdx.get(0)[1])
                answer[cnt--] = heights.get(i);
        }

        Arrays.sort(answer);
        for(int an : answer){
            bw.write(an + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
