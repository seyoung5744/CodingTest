import java.util.Scanner;

public class Main {
    public static int T;
    public static int H, W, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(T-- > 0){
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            int count = 1;
            for (int i = 1; i <= W; i++) {
                for (int j = 1; j <= H; j++) {
                    if(count == N) {
                        if (j < 10) {
                            System.out.printf("%d%02d", j, i);
                        } else {
                            System.out.printf("%02d%02d", j, i);
                        }
                    }
                    count+=1;
                }
            }
            System.out.println();
        }
    }

}
