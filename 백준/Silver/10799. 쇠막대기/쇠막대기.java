import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sticks = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> remain = new Stack<>();

        int count = 0;

        for (int i = 0; i < sticks.length(); i++) {
            boolean isLaser = false;
            char c = sticks.charAt(i);

            if(i < sticks.length() - 1 && c == '(' && sticks.charAt(i + 1) == ')') {
                isLaser = true;
            }

            if(isLaser) {
                count += stack.size();
                while(!remain.isEmpty()) {
                    stack.pop();
                    remain.pop();
                }

                i+=1;
                continue;
            }

            if(c == '(') {
                stack.push(c);
            }else {
                remain.push(c);
            }
        }
        count += stack.size();
        System.out.println(count);
    }
}
