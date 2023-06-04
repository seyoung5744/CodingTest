import java.util.*;
import java.io.*;

public class Main {

    public static int[] origin;
    public static int[] sorted;
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        origin = new int[n];
        sorted = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
            sorted[i] = num;
        }

        Arrays.sort(sorted);
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
