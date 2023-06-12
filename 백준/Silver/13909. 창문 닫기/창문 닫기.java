import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            cnt += 1;
        }

        System.out.println(cnt);
    }

}
