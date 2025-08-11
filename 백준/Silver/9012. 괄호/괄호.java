import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String parenthesis = br.readLine();

            if (isValid(parenthesis)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


        br.close();
    }

    private static boolean isValid(String parenthesis) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : parenthesis.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == ')') {
                    return false;
                } else {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
