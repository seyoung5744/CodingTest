package _18_그래프이론._41_여행계획;

import java.util.*;

/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
 */
public class Main {

    // 여행지의 개수와 여행 계획에 속한 여행지의 개수
    public static int n, m;
    public static int[] parent = new int[501]; // 부모 테이블 초기화

    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) { // 연결된 경우 합집합(Union) 연산 수행
                    unionParent(i + 1, j + 1);
                }
            }
        }

        // 여행 계획 입력받기
        ArrayList<Integer> plan = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            plan.add(x);
        }

        boolean flag = true;
        // 여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        for (int i = 0; i < plan.size() - 1; i++) {
            if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
                flag = false;
            }
        }

        // 여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }

}
