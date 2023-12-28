import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(char c : br.readLine().toCharArray()) {
            left.push(c);
        }
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] commends = br.readLine().split(" ");

            switch (commends[0]) {
                case "L":
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(commends[1].charAt(0));
                    break;
            }
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.flush();
        br.close();
    }

}
