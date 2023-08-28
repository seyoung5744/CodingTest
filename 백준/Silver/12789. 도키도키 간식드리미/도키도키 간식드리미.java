import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int order = 1;

        while (!queue.isEmpty()) {
            if (queue.peek() == order) {
                queue.pop();
                order++;
            } else if (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == order) {
                stack.pop();
                order++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
        
    }


}
