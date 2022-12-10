import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch (s.split(" ")[0]) {
                case "push":
                    int num = Integer.parseInt(s.split(" ")[1]);
                    queue.offer(num);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        bw.write(-1 + "\n");
                        break;
                    }
                    bw.write(queue.pollFirst() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()){
                        bw.write(-1 + "\n");
                        break;
                    }
                    bw.write(queue.peekFirst() + "\n");
                    break;
                case "back":
                    if(queue.isEmpty()){
                        bw.write(-1 + "\n");
                        break;
                    }
                    bw.write(queue.peekLast() + "\n");
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}