import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strNum = "";
        while ((strNum = br.readLine()) != null) {
            int n = Integer.parseInt(strNum);
            int onlyOne = 0;

            for (int cnt = 1; ; cnt++) {
                onlyOne = (onlyOne * 10 + 1)% n;

                if (onlyOne == 0) {
                    System.out.println(cnt);
                    break;
                }
            }
        }

        br.close();
    }
}
