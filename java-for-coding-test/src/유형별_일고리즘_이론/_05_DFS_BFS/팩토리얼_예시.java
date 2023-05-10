package 유형별_일고리즘_이론._05_DFS_BFS;

public class 팩토리얼_예시 {

    public static void main(String[] args) {
        System.out.println("반복문으로 구현 : " + factorial_iterative(5));
        System.out.println("재귀적으로 구현 : " + factorial_recursive(5));

    }

    public static int factorial_iterative(int n){
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;


    }
    public static int factorial_recursive(int n) {
        if (n < 2) {
            return 1;
        }

        return n * factorial_recursive(n - 1);
    }

}
