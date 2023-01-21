import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = null;

        while(T-- > 0){
            String[] str = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            for(String s : str){
                stack = new Stack<>();

                for(char c : s.toCharArray()){
                    stack.push(c);
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }

            System.out.println(sb);
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
