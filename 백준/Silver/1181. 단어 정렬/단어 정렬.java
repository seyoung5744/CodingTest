import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SortedSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        strings = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int idx = 0;

        while(iterator.hasNext()){
            strings[idx++] = iterator.next();
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }

                return Integer.compare(o1.length(), o2.length());
            }
        });

        for(String s: strings){
            System.out.println(s);
        }
    }

}
