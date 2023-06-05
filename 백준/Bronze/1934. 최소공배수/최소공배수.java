import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        while (testcase-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int num1 = a;
            int num2 = b;
            while (num2 > 0) {
                int tmp = num2;
                num2 = num1 % num2;
                num1 = tmp;
            }

            System.out.println(a * b / num1);
        }
    }

}
