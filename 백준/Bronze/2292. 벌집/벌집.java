import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;
        int start = 1;
        if(n == 1){
            System.out.println(1);
            return;
        }
        while (true) {
            if (start < n && n <= start + (cnt * 6)) {
                break;
            }
            start = start + (cnt * 6);
            cnt += 1;
        }
        System.out.println(cnt+1);
    }

}
