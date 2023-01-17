import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String brackets = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int answer = 0;
        int cnt = 1;

        for (int i = 0; i < brackets.length(); i++) {
            char cur = brackets.charAt(i);
            if(cur == '('){
                stack.push(cur);
                cnt *= 2;
            }else if (cur == '['){
                stack.push(cur);
                cnt *= 3;
            }else{
                if(cur == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        flag = false;
                        break;
                    }

                    if(brackets.charAt(i-1) == '('){
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 2;
                }else if(cur == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        flag = false;
                        break;
                    }

                    if(brackets.charAt(i-1) == '['){
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                }else{
                    flag = false;
                    break;
                }
            }
        }

        if(!flag || !stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
