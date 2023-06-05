import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static StringTokenizer st;
    public static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")){
                set.add(name);
            }else if(status.equals("leave")){
                set.remove(name);
            }
        }

        List<String> collect = set.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        for(String name : collect){
            System.out.println(name);
        }

    }
}
