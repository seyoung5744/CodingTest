import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] homes = new int[n];
        for (int i = 0; i < n; i++) {
            homes[i] = sc.nextInt();
        }

        Arrays.sort(homes);

        System.out.println(homes[(n - 1) / 2]);
    }

}
