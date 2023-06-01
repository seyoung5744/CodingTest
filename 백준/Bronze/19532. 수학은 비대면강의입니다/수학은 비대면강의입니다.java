import java.io.*;
import java.util.*;

public class Main {

    public static int a, b, c, d, e, f;
    public static final int start = -999;
    public static final int end = 999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for (int i = start; i < end + 1; i++) {
            for (int j = start; j < end + 1; j++) {
                if (((a * i) + (b * j) == c) && ((d * i) + (e * j) == f)) {
                    System.out.println(i + " " + j);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

    }

}
