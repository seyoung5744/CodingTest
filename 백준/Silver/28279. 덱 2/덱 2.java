import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int commend = Integer.parseInt(st.nextToken());
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }
            switch (commend) {
                case 1:
                    deque.addFirst(num);
                    break;
                case 2:
                    deque.addLast(num);
                    break;
                case 3:
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else {
                        sb.append(deque.pollFirst());
                    }
                    break;
                case 4:
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else {
                        sb.append(deque.pollLast());
                    }
                    break;
                case 5:
                    sb.append(deque.size());
                    break;
                case 6:
                    if(deque.isEmpty()){
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    break;
                case 7:
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(deque.peekFirst());
                    }
                    break;
                case 8:
                    if(deque.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(deque.peekLast());
                    }
                    break;
            }
            if(commend > 2)
                sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
