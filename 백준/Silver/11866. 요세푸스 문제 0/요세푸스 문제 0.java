import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        int idx = 0;

        while (!queue.isEmpty()) {
            int data = queue.poll();
            idx += 1;
            if(idx == k){
                idx = 0;
                result.add(data);
            }else{
                queue.add(data);
            }
        }

        bw.write("<");
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                bw.write(result.get(i) + ", ");
            } else {
                bw.write(result.get(i) + "");
            }
        }
        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}
