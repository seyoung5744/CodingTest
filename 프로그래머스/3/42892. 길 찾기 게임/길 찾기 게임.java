import java.util.*;

public class Solution {

    static class Node {

        int x, y;
        int num;
        Node left;
        Node right;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static List<Integer> preOrder = new ArrayList<>();
    public static List<Integer> postOrder = new ArrayList<>();
    
    public static int[][] solution(int[][] nodeInfo) {
        int[][] answer = {};

        Node[] nodes = new Node[nodeInfo.length];

        for (int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i + 1);
        }

        Arrays.sort(nodes, (a, b) -> {
            return b.y - a.y;
        });

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            int curX = nodes[i].x;
            Node cur = root;

            while (true) {
                if (curX < cur.x) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur.left = nodes[i];
                        break;
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = nodes[i];
                        break;
                    }
                }
            }
        }
        
        visit(root);
        
        return new int[][]{
            preOrder.stream().mapToInt(Integer::intValue).toArray(),
            postOrder.stream().mapToInt(Integer::intValue).toArray(),
        };
    }

    public static void visit(Node node) {
        if(node == null) return;
        preOrder.add(node.num);
        visit(node.left);
        visit(node.right);
        postOrder.add(node.num);
    }
}
