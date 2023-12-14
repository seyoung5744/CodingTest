
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] index = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alphabet = br.readLine();

        for(char c : alphabet.toCharArray()) {
            index[c - 'a'] += 1;
        }

        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }
    }

}
