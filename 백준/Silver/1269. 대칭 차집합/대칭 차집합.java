import java.util.*;

public class Main {
    public static Set<Integer> A = new HashSet<>();
    public static Set<Integer> A2 = new HashSet<>();

    public static Set<Integer> B = new HashSet<>();
    public static Set<Integer> B2 = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            A.add(num);
            A2.add(num);
        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            B.add(num);
            B2.add(num);
        }

        A.removeAll(B);
        B2.removeAll(A2);

        System.out.println(A.size() + B2.size());


    }

}
