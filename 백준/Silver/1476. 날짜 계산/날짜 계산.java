import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ESM = br.readLine().split(" ");
        int E = Integer.parseInt(ESM[0]);
        int S = Integer.parseInt(ESM[1]);
        int M = Integer.parseInt(ESM[2]);

        int year = 1;
        int e = 1, s = 1, m = 1;
        while (e != E || s != S || m != M) {

            e = e < 15 ? ++e : 1;
            s = s < 28 ? ++s : 1;
            m = m < 19 ? ++m : 1;

            year++;
        }
        System.out.println(year);

        br.close();
    }

}
