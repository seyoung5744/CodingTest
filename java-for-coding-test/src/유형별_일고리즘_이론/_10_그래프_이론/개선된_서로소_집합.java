package 유형별_일고리즘_이론._10_그래프_이론;

import java.util.Scanner;

public class 개선된_서로소_집합 {

    public static int v, e;
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

        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i <= v ; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        System.out.print("부모 테이블 : " );
        for (int i = 1; i <= v ; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
