import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int last = a * b;
        
        for (int i = 0; i < 3; i++) {
            int tmp = b % 10;
            b /= 10;
            System.out.println(a * tmp);
        }
        System.out.println(last);
    }
}
