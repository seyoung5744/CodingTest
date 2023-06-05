import java.util.*;

public class Main {
    public static Map<String, Integer> map1 = new HashMap<>();
    public static Map<Integer, String> map2 = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            String name = sc.next();
            map1.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String quiz = sc.next();
            char first = quiz.charAt(0);

            if(Character.isDigit(first)){
                System.out.println(map2.get(Integer.parseInt(quiz)));
            }else{
                System.out.println(map1.get(quiz));
            }
        }
    }

}
