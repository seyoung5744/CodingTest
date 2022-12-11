import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Character> hashMap = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
        }};

        String str = br.readLine();
        while (!str.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (char ch : str.toCharArray()) {
                if (hashMap.containsKey(ch)) {
                    stack.push(ch);
                } else if (hashMap.containsValue(ch)) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        char data = stack.pop();
                        if (ch != hashMap.get(data)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }

            str = br.readLine();
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
