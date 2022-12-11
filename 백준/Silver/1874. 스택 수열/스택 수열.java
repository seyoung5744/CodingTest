import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean flag = true;
        int idx = 1;
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (flag) {
                if (!stack.contains(num)) {
                    for (int j = idx; j <= num; j++) {
                        stack.push(j);
                        answer.add("+");
                    }

                    idx = num + 1;
                }

                if (stack.contains(num)) {
                    if (stack.peek() == num) {
                        stack.pop();
                        answer.add("-");
                    } else {
                        answer.clear();
                        answer.add("NO");
                        flag = false;
                    }
                }
            }
        }

        for(String an : answer){
            bw.write(an + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
