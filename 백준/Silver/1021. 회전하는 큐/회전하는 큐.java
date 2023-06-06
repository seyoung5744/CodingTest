import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int result = 0;

        while (cnt < M) {
            int target = targets[cnt];
            int a = op2Count(target, deque);
            int b = op3Count(target, deque);
            if(a < b){
                result += a;
                operation2(target);
            }else{
                result += b;
                operation3(target);
            }
            cnt += 1;
            deque.pollFirst();
        }
        System.out.println(result);

        bw.flush();
        br.close();
        bw.close();
    }

    public static int operation2(int target) {
        int count = 0;
        while (deque.peek() != target) {
            deque.offerLast(deque.pollFirst());
            count += 1;
        }
        return count;
    }

    public static int operation3(int target) {
        int count = 0;
        while (deque.peek() != target) {
            deque.offerFirst(deque.pollLast());
            count += 1;
        }
        return count;
    }

    public static int op2Count(int target, Deque<Integer> origin) {
        Deque<Integer> deque = new ArrayDeque<>(origin);
        int count = 0;
        while (deque.peek() != target) {
            deque.offerLast(deque.pollFirst());
            count += 1;
        }
        return count;
    }

    public static int op3Count(int target, Deque<Integer> origin) {
        Deque<Integer> deque = new ArrayDeque<>(origin);
        int count = 0;
        while (deque.peek() != target) {
            deque.offerFirst(deque.pollLast());
            count += 1;
        }
        return count;
    }
}
