import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = n.length() - 1; i >= 0; i--) {

            if ('A' <= n.charAt(i) && n.charAt(i) <= 'Z') {
                answer += (int) ((n.charAt(i) - 'A' + 10) * Math.pow(b, n.length()-1 - i));
            } else {
                answer += (int) ((n.charAt(i) - '0') * Math.pow(b, n.length()-1 - i));
            }

        }
        System.out.println(answer);
    }

}
