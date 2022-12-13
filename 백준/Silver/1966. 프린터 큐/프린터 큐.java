import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
    int num;
    int priority;

    public Node(int data, int priority) {
        this.num = data;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + num +
                ", priority=" + priority +
                '}';
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Queue<Node> queue = new LinkedList<>();

            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            String[] priorities = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.offer(new Node(j, Integer.parseInt(priorities[j])));
            }

            int cnt = 1;
            while(true){
                Node cur = queue.poll();

                if(!checkPriority(cur, queue)){ // 현재거보다 우선 순위 높은게 있으면
                    queue.offer(cur); // 맨 뒤로 넣기
                }else{ // 현재꺼보다 우선 순위가 높은게 없음
                    if(cur.num == M){ // 찾을려는 번호면 끝
                        break;
                    }else{ // 우선 순위 높은것부터 출력
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean checkPriority(Node cur, Queue<Node> queue){
        for (Node node : queue) {
            if (cur.priority < node.priority) {
                return false;
            }
        }

        return true;
    }
}
