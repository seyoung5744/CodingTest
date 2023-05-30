import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                list.add(i);
                if(n / i != i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);

        if(list.size() < k){
            System.out.println(0);
            return;
        }
        System.out.println(list.get(k-1));
    }
}
