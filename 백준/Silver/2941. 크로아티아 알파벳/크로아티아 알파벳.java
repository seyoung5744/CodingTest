import java.util.*;

public class Main {

    public static String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (String alpha : alphabet) {
            if (str.contains(alpha)) {
                str = str.replaceAll(alpha, "0");
            }
        }
        System.out.println(str.length());
    }

}
