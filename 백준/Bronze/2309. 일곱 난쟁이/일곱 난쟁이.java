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

        int total = 9;
        int[] heights = new int[total];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        for (int i = 0; i < heights.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < heights.length; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    heights[i] = -1;
                    heights[j] = -1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }


        Arrays.sort(heights);
        for (int i = 2; i < heights.length; i++) {
            bw.write(heights[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
