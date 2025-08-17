import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            StringTokenizer plus = new StringTokenizer(st.nextToken(), "+");

            int sum = 0;
            while (plus.hasMoreTokens()) {
                sum += Integer.parseInt(plus.nextToken());
            }

            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }


        System.out.println(answer);

        br.close();
    }

}
