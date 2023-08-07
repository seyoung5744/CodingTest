import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class MyStack {
    private List<Integer> list;

    public MyStack(){
        list = new ArrayList<>();
    }

    public void push(int x){
        list.add(x);
    }

    public int pop(){
        if(isEmpty() == 1)
            return -1;

        return this.list.remove(this.size() - 1);
    }

    public int peek(){
        if(isEmpty() == 1)
            return -1;

        return this.list.get(this.size() - 1);
    }

    public int size(){
        return this.list.size();
    }

    public int isEmpty(){
        if(list.isEmpty()){
            return 1;
        }
        return 0;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            switch (command.split(" ")[0]){
                case "1":
                    stack.push(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "2":
                    bw.write(stack.pop() + "\n");
                    break;
                case "3":
                    bw.write(stack.size() + "\n");
                    break;
                case "4":
                    bw.write(stack.isEmpty() + "\n");
                    break;
                case "5":
                    bw.write(stack.peek() + "\n");
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
