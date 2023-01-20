import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        char[] words = br.readLine().toCharArray();

        for (char word : words) {
            int w = word - 3;
            if (w < 65) {
                w += 26;
            }
            sb.append(Character.toChars(w));
        }

        System.out.println(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}
