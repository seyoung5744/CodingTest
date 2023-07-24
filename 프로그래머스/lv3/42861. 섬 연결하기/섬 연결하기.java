import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Node(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}
class Solution {
    public static int[] parent;
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static int result = 0;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int distance = cost[2];
            nodes.add(new Node(distance, a, b));
        }

        Collections.sort(nodes);

        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            int cost = node.getDistance();
            int a = node.getNodeA();
            int b = node.getNodeB();

            if(findParent(a) != findParent(b)){
                result += cost;
                unionParent(a, b);
            }
        }
        
        return result;
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    private static int findParent(int a){
        if(a != parent[a]){
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }
    public static void main(String[] args) {

    }

}
