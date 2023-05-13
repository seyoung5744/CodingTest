import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (int i = 0; i < str.length(); i += 10) {
            if (str.length() - i >= 10) {
                System.out.println(str.substring(i, i + 10));
            } else {
                System.out.println(str.substring(i));
            }
        }
    }

}
