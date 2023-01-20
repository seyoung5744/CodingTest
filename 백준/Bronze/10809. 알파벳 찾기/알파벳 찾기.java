import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);
        String word = br.readLine();
        
        for (int i = 0; i < word.length(); i++) {
            alphabets[word.charAt(i) - 97] = word.indexOf(word.charAt(i));
        }

        for(int al : alphabets){
            System.out.print(al + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
