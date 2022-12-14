import java.io.*;
import java.util.Arrays;

public class Main {
    public static final int[] piece = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int[] answers = new int[piece.length];
        for (int i = 0; i < piece.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if(piece[i] < num){
                answers[i] = (num - piece[i]) * -1;
            }else if(piece[i] > num){
                answers[i] = piece[i] - num;
            }else{
                answers[i] = 0;
            }
        }

        for(int answer : answers){
            bw.write(answer + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
