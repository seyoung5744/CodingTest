import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());

            if(data == 0){
                if (pq.isEmpty()) {
                    System.out.println(0);
                }else {
                    System.out.println(pq.poll());
                }

            }else {
                pq.offer(data);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }


}
