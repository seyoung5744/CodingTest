import java.util.*;
import java.util.stream.*;

public class Solution {

    private static class Node {

        private int depth = 1;
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) {
                return;
            }
            
            Node root1 = root();
            Node root2 = o.root();
            
            if(root1.depth < root2.depth) {
                root1.parent = root2;
            }else if(root1.depth > root2.depth) {
                root2.parent = root1;
            }else {
                root2.parent = root1;
                root1.depth += 1;
            }
            
        }

        private Node root() {
            if (parent == null) {
                return this;
            }
            return parent.root();
        }
    }

    public static class Edge {

        public final int u;
        public final int v;
        public final int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        Edge[] edges = new Edge[costs.length];

        for (int i = 0; i < costs.length; i++) {
            int u = costs[i][0];
            int v = costs[i][1];
            int cost = costs[i][2];
            edges[i] = new Edge(u, v, cost);
        }

        Arrays.sort(edges, (a, b) -> a.cost - b.cost);

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        int totalCount = 0;

        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if (node1.isConnected(node2)) continue;
            
            node1.merge(node2);
            totalCount += edge.cost;
        }
        
        return totalCount;
    }

}
