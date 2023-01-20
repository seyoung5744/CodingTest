import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

class MyQueue {

    private List<Integer> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void push(int data) {
        this.list.add(data);
    }

    public int empty() {
        if (list.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int pop() {
        if (this.empty() == 1) {
            return -1;
        }

        int data = this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public int size() {
        return this.list.size();
    }

    public int front() {
        if (this.empty() == 1) {
            return -1;
        }

        return this.list.get(0);
    }

    public int back() {
        if (this.empty() == 1) {
            return -1;
        }

        return this.list.get(this.size() - 1);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch (s.split(" ")[0]){
                case "push":
                    int num = Integer.parseInt(s.split(" ")[1]);
                    myQueue.push(num);
                    break;
                case "pop":
                    System.out.println(myQueue.pop());
                    break;
                case "size":
                    System.out.println(myQueue.size());
                    break;
                case "empty":
                    System.out.println(myQueue.empty());
                    break;
                case "front":
                    System.out.println(myQueue.front());
                    break;
                case "back":
                    System.out.println(myQueue.back());
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }


}
