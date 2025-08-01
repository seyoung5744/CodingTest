import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (pq.isEmpty() && num == 0) {
                System.out.println(0);
            }else if(num == 0) {
                System.out.println(pq.poll());
            }else {
                pq.add(num);
            }

        }
    }

}
