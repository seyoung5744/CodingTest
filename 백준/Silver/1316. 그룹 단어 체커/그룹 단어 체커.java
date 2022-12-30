import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            boolean[] visited = new boolean[26];
            String str = br.readLine();

            char[] chars = str.toCharArray();
            boolean flag = true;
            for (int i = 0; i < chars.length - 1; i++) {
                char cur = chars[i];
                char next = chars[i + 1];

                if (cur != next) {
                    if(!visited[next - 'a']) {
                        visited[cur - 'a'] = true;
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}
