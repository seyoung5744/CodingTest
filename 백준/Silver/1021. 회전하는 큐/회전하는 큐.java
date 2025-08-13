import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int target : targets) {

            int front = front(new ArrayDeque<>(deque), target);
            int back = back(new ArrayDeque<>(deque), target);

            if (front < back) {
                removeFrontTarget(deque, target);
            } else {
                removeBackTarget(deque, target);
            }
            answer += Math.min(front, back);
        }
        System.out.println(answer);
        br.close();
    }

    public static int front(Deque<Integer> deque, int target) {
        int count = 0;

        while (!deque.isEmpty()) {
            int num = deque.poll();
            if (num == target) {
                break;
            }
            count++;
            deque.offer(num);
        }
        return count;
    }

    public static void removeFrontTarget(Deque<Integer> deque, int target) {
        while (!deque.isEmpty()) {
            int num = deque.poll();
            if (num == target) {
                break;
            }
            deque.offer(num);
        }
    }

    public static int back(Deque<Integer> deque, int target) {
        int count = 0;

        while (!deque.isEmpty()) {
            int num = deque.pollLast();
            count++;
            if (num == target) {
                break;
            }
            deque.offerFirst(num);
        }
        return count;
    }

    public static void removeBackTarget(Deque<Integer> deque, int target) {
        while (!deque.isEmpty()) {
            int num = deque.pollLast();
            if (num == target) {
                break;
            }
            deque.offerFirst(num);
        }
    }
}
