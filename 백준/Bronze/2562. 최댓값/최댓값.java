import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num;
        int idx = 0, max = 0;
        for (int i = 0; i < 9; i++) {
            num = Integer.parseInt(br.readLine());
            if(num > max){
                max = num;
                idx = i+1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
        br.close();
    }
}
