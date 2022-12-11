import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            String s = br.readLine();
            if (s.length() < 2 || s.length() > 50) {
                flag = false;
            } else {
                for (char ch : s.toCharArray()) {
                    if (ch == '(') {
                        stack.push(ch);
                    } else if (ch == ')') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
