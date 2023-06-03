import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int[] arr = new int[n.length()];

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0 ; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}