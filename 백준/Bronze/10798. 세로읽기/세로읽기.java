import java.util.*;

public class Main {
    public static String[] strArr = new String[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            strArr[i] = sc.next();
            max = Math.max(max, strArr[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if(strArr[j].length() > i) {
                    sb.append(strArr[j].charAt(i));
                }
            }
        }

        System.out.println(sb);

    }

}
