import java.util.*;

public class Main {

    public static int[] origin;
    public static int[] sorted;
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        origin = new int[n];
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            origin[i] = num;
            sorted[i] = num;
        }

        Arrays.sort(sorted);
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(origin[i])).append(" ");
        }

        System.out.println(sb.toString());
    }

}
