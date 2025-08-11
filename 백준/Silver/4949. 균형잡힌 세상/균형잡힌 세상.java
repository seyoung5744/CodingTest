import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Main {

    private static final Map<Character, Character> parenthesis = Map.of(
            '(', ')',
            '[', ']'
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (!(str = br.readLine()).equals(".")) {
            if (isValid(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        br.close();
    }

    private static boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (parenthesis.containsKey(c)) {
                stack.push(c);
            } else if (parenthesis.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (parenthesis.get(stack.peek()) == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
