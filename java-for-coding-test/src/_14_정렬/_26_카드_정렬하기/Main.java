package _14_정렬._26_카드_정렬하기;

import java.util.*;

/*
3
10
20
40
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            pq.offer(num);
        }

        int result = 0;
        while (pq.size() > 1) {
            // 가장 작은 2개의 카드 묶음 꺼내기
            int one = pq.poll();
            int two = pq.poll();
            // 카드 묶음을 합쳐서 다시 삽입
            int sum = one + two;
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }

}
