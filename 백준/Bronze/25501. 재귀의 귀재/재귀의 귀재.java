import java.util.*;
import java.io.*;

public class Main {

    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testcase = Integer.parseInt(st.nextToken());

        while(testcase-- > 0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            System.out.println(isPalindrome(s) + " " + count);
            count = 0;
        }


    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);

    }

    public static int recursion(String s, int start, int end) {
        count+=1;
        if (start >= end) {
            return 1;
        } else if (s.charAt(start) != s.charAt(end)) {
            return 0;
        } else {
            return recursion(s, start + 1, end - 1);
        }

    }

}
