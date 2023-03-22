import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String strNum = "";
        while ((strNum = br.readLine()) != null) {
            int n = Integer.parseInt(strNum);

            long onlyOne = 0;

            for (int cnt = 1; ; cnt++) {
                onlyOne = (onlyOne * 10 + 1) % n;
                if (onlyOne % n == 0) {
                    System.out.println(cnt);
                    break;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
