import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int digit = 10;
        int num = 1; // 자리수

        for (int i = 1; i <= N; i++) {
            if(i % digit == 0){
                digit *= 10;
                num++;
            }

            sum+=num;
        }
        System.out.println(sum);
        
        br.close();
    }
}
