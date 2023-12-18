
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] tokens = br.readLine().split(" ");
            char target = tokens[0].charAt(0);
            int start = Integer.parseInt(tokens[1]);
            int end = Integer.parseInt(tokens[2]) + 1;

            String subStr = str.substring(start, end);
//            System.out.println(subStr);

            int count =  0;
            for(char c : subStr.toCharArray()) {
                if(c == target) count++;
            }
            System.out.println(count);
        }
    }

}
