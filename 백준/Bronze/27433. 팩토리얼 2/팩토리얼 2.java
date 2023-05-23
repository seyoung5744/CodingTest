import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }

    public static long factorial(int x){
        if(x == 0 || x == 1){
            return 1;
        }

        return x * factorial(x-1);
    }

}
