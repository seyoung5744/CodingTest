import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = Integer.MAX_VALUE;
        boolean flag = false;

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1334; j++) {
                if((5 * i) + (3 * j) == n){
                    count = Math.min(count, i + j);
                    flag = true;
                }
            }
        }

        if(flag){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }

}
