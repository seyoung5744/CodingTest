import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();
        long num1 = a;
        long num2 = b;

        while(num2 > 0){
            long tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }

        System.out.println(a * b / num1);
    }

}
