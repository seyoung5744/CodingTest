package _18_그래프이론._42_탑승구;

import java.util.*;

/*
4
3
4
1
1

4
6
2
2
3
3
4
4

 */
public class Main {

    public static int[] parent = new int[100001];
    public static int g, p;

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        g = sc.nextInt();
        p = sc.nextInt();

        for (int i = 1; i <= g ; i++) {
            parent[i] = i;
        }

        int result = 0;

        for (int i = 0; i < p; i++) { // 비행기 번호 1 ~ p번
            int x = sc.nextInt(); // 탑승 범위
            int root = find(x);

            if(root == 0) break;
            union(root, root - 1);
            result+=1;
        }
        System.out.println(result);
    }

}
