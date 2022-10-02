import java.util.Scanner;

public class Main {
    public static int test(int n){
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(i < 100){
                answer+=1;
            }else if(i < 1000){
                int num = i;
                int one = num % 10;
                num /= 10;
                int two = num % 10;
                num /= 10;
                int three = num % 10;

                if((one-two) == (two - three)){
                    answer+=1;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(test(n));

    }
}
