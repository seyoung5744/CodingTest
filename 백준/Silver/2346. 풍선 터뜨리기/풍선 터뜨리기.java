import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        int data;

        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Node> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            deque.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        
        StringBuilder sb = new StringBuilder();
        
        while(deque.size() > 1){
            Node pop = deque.pollFirst();
            sb.append(pop.index).append(" ");
            if(pop.data > 0) {
                for (int i = 1; i < Math.abs(pop.data); i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }else {
                for (int i = 0; i < Math.abs(pop.data); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll().index);
        System.out.println(sb);
    }
}
