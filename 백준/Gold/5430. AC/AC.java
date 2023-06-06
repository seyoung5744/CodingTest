import java.io.*;
import java.util.*;

public class Main {

    public static int testCase, n;
    public static String p;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        while (testCase-- > 0) {
            p = sc.next();
            int n = sc.nextInt();
            String str = sc.next();
            String[] arr = str.substring(1, str.length() - 1).split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.offerLast(Integer.parseInt(arr[i]));
            }

            AC(p, deque);
        }

        System.out.println(sb);
    }

    public static void AC(String command, Deque<Integer> deque) {
        boolean isRight = true;
        for (char cmd : command.toCharArray()) {

            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }

        }
        makeString(deque, isRight);
    }

    private static void makeString(Deque<Integer> deque, boolean isRight) {
        sb.append("[");

        if (deque.size() > 0) {

            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }


        }

        sb.append("]").append("\n");
    }


}
