import java.util.*;

public class Main {

    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 1; i < str.length() + 1; i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                set.add(str.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}