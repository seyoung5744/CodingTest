package 유형별_일고리즘_이론._07_이진탐색.부품찾기;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class set함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            set.add(x);
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = targets[i];
            if(set.contains(target)){
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }
        }
    }

}
