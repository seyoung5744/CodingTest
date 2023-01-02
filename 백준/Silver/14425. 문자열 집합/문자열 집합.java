import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Set<String> set = new HashSet<>();
        while(N-- > 0){
            set.add(br.readLine());
        }
        
        int answer = 0;
        while(M-- >0 ){
            String str = br.readLine();
            if(set.contains(str)){
                answer++;
            }
        }
        
        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
