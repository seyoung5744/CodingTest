package 유형별_일고리즘_이론._07_이진탐색.부품찾기;

import java.util.Scanner;

public class 계수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[1000000];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] = 1;
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = targets[i];
            if(arr[target] == 1){
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }
        }

    }
}
