package 유형별_일고리즘_이론._08_다이나믹프로그래밍;

public class 비효율적인_피보나치_수열_구현 {

    public static void main(String[] args) {
        System.out.println(fibo(100));
    }

    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibo(x - 1) + fibo(x - 2);
    }

}
