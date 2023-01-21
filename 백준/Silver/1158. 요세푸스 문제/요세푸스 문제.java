import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while (!list.isEmpty()) {
            idx = (idx + k - 1) % n;

            sb.append(list.get(idx));
            if (n > 1) {
                sb.append(", ");
            }

            list.remove(idx);
            n--;
        }
        sb.append(">");

        System.out.println(sb);

        bw.flush();
        br.close();
        bw.close();
    }

}
