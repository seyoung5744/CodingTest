import java.util.*;

public class Main {
    public static Set<String> set = new HashSet<>();
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            set.add(name);
        }
        for (int i = 0; i < m; i++) {
            String name = sc.next();
            if(set.contains(name)){
                list.add(name);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(String name : list){
            System.out.println(name);;
        }
    }

}
