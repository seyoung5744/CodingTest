import java.io.*;
import java.util.*;

public class Main {

    static int[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        computers = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            computers[i] = i;
        }

        int answer = -1;
        int linkCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < linkCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        for (int i = 1; i < N + 1; i++) {
            if(find(i) == 1){
                answer++;
            }
        }

        System.out.println(answer);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (x < y) {
            computers[y] = x;
        } else {
            computers[x] = y;
        }
    }

    public static int find(int x) {
        if (computers[x] == x) {
            return x;
        }

        return computers[x] = find(computers[x]);
    }

}
