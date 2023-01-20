import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int decimal = Integer.parseInt(br.readLine());
            int idx = 0;
            while(decimal > 0){
                if(decimal % 2 == 1){
                    System.out.print(idx + " ");
                }
                idx++;
                decimal /= 2;
            }
            System.out.println();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
