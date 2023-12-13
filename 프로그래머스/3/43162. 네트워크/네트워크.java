
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static int[] parents;

    public static int solution(int n, int[][] computers) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    if (find(i) != find(j))
                        union(i, j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            find(i);
        }
        Set<Integer> collect = Arrays.stream(parents).boxed().collect(Collectors.toSet());
        return collect.size();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static int find(int n) {
        if (n != parents[n]) {
            parents[n] = find(parents[n]);
        }

        return parents[n];
    }

}
