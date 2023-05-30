import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static int n;
    public static ArrayList<Integer> list;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while((n = sc.nextInt()) != -1){
            list = new ArrayList<>();
            
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    list.add(i);
                    if (n / i != i) {
                        list.add(n / i);
                    }
                }
            }
            Collections.sort(list);

            int sum = list.stream().filter(x -> x < n).mapToInt(Integer::intValue).sum();

            if (sum == list.get(list.size() - 1)) {
                String collect = list.stream().filter(x -> x < n).map(Object::toString)
                    .collect(Collectors.joining(" + "));
                System.out.println(n + " = " + collect);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
