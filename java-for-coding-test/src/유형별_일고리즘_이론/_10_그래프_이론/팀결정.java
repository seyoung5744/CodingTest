package 유형별_일고리즘_이론._10_그래프_이론;

import java.util.Scanner;

/*
7 8
0 1 3
1 1 7
0 7 8
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class 팀결정 {
    // 노드의 개수(N)와 연산의 개수(M)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m;
    public static int[] parent = new int[100001];

    public static int findParent(int x){
        if(x != parent[x]){
            parent[x] = findParent(parent[x]);
        }

        return parent[x];
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(oper == 0){
                unionParent(a, b);
            }
            else if(oper == 1){
                if(findParent(a) == findParent(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }

}
