import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();


        int data = Integer.parseInt(br.readLine());
        while(data != -1){
            if(data == 0){
                queue.poll();
            }else {
                if(queue.size() < N){
                    queue.add(data);
                }
            }

            data = Integer.parseInt(br.readLine());
        }

        if(queue.isEmpty()){
            bw.write("empty");
        }else {
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + " ");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
