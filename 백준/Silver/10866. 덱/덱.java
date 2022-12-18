import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(deque.pollFirst() + "\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(deque.pollLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(deque.peekFirst() + "\n");
                    break;
                case "back":
                    if(deque.isEmpty()){
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(deque.peekLast() + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
