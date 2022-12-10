import java.io.*;
import java.util.ArrayList;

class MyStack {
    ArrayList<Integer> list;

    public MyStack() {
        this.list = new ArrayList<>();
    }

    public int empty() {
        if (this.list.size() == 0) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return this.list.size();
    }

    public void push(int x) {
        this.list.add(x);
    }

    public int pop() {
        if(this.empty() == 1){
            return -1;
        }

        int data = this.list.get(this.size() - 1);
        this.list.remove(this.size() - 1);
        return data;
    }

    public int top() {
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

        MyStack myStack = new MyStack();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch (s.split(" ")[0]){
                case "push":
                    int num = Integer.parseInt(s.split(" ")[1]);
                    myStack.push(num);
                    break;
                case "pop":
                    System.out.println(myStack.pop());
                    break;
                case "size":
                    System.out.println(myStack.size());
                    break;
                case "empty":
                    System.out.println(myStack.empty());
                    break;
                case "top":
                    System.out.println(myStack.top());
                    break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}