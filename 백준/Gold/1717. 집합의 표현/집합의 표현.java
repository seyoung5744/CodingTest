import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;
    public static int n, m;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(operation == 0){
                if(findParent(a) != findParent(b))
                    unionParent(a, b);
            }else{
                System.out.println(findParent(a) == findParent(b) ? "yes":"no");
            }
        }
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int a){
        if(a != parent[a]){
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }
}
