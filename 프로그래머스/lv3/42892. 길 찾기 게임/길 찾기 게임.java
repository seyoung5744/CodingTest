import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    static class Node2 {

        int x;
        int y;
        int data;

        Node2 left;
        Node2 right;

        public Node2(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        Node2[] nodes = new Node2[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node2(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a, b) -> b.y - a.y);

        Node2 root = constructTree(nodes);

        ArrayList<Integer> pre = new ArrayList<>();
        pre(root, pre);

        ArrayList<Integer> post = new ArrayList<>();
        post(root, post);

        return new int[][]{
            pre.stream().mapToInt(Integer::intValue).toArray(),
            post.stream().mapToInt(Integer::intValue).toArray(),
        };
    }

    private static void pre(Node2 root, ArrayList<Integer> visited) {
        if(root == null) return;

        visited.add(root.data);
        pre(root.left, visited);
        pre(root.right, visited);
    }

    private static void post(Node2 root, ArrayList<Integer> visited) {
        if(root == null) return;

        post(root.left, visited);
        post(root.right, visited);
        visited.add(root.data);
    }

    private static Node2 constructTree(Node2[] nodes) {
        Node2 root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        return root;
    }

    private static void insert(Node2 root, Node2 node) {
        if (root.x > node.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
}
