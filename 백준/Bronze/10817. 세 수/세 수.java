import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            pq.offer(sc.nextInt());
        }

        pq.poll();
        System.out.println(pq.poll());
    }

}
