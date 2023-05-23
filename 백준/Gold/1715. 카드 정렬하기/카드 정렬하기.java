import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pq.offer(num);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int num = pq.poll() + pq.poll();
            sum += num;
            pq.offer(num);
        }

        System.out.println(sum);
    }

}
