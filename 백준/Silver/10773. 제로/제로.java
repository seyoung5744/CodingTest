import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int num = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(num);    
            }            
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
