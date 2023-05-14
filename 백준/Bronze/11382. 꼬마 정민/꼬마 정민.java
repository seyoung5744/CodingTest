import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        System.out.println(sum(c, sum(a, b)));
    }

    public static String sum(String a, String b){
        int maxLength = Math.max(a.length(), b.length());
        int[] A = new int[maxLength + 1];
        int[] B = new int[maxLength + 1];

        for (int i = a.length() - 1, idx = 0; i >= 0; i--, idx++) {
            A[idx] = a.charAt(i) - '0';
        }
        for (int i = b.length() - 1, idx = 0; i >= 0; i--, idx++) {
            B[idx] = b.charAt(i) - '0';
        }

        for (int i = 0; i < maxLength; i++) {
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] += (value / 10);
        }

        StringBuilder sb = new StringBuilder();
        if(A[maxLength] != 0){
            sb.append(A[maxLength]);
        }

        for (int i = maxLength - 1; i >= 0 ; i--) {
            sb.append(A[i]);
        }

        return sb.toString();
    }
}