import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        Node pre;
        Node next;
        int data;

        public Node(Node pre, int data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }
    public static String solution(int n, int k, String[] cmds) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }

        Stack<Node> stack = new Stack<>();

        Node[] nodes = new Node[n];
        nodes[0] = new Node(null, 0, null);
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node(nodes[i-1], i, null);
            nodes[i-1].next = nodes[i];
        }

        Node cur = nodes[k];

        for(String command : cmds) {
            StringTokenizer st = new StringTokenizer(command, " ");
            String cmd = st.nextToken();
            int next = 0;
            if(st.hasMoreTokens()) {
                next = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "D":
                    for (int i = 0; i < next; i++) {
                        cur = cur.next;
                    }
                    break;
                case "U":
                    for (int i = 0; i < next; i++) {
                        cur = cur.pre;
                    }
                    break;
                case "C":
                    stack.add(cur);
                    if(cur.pre == null) {
                        cur = cur.next;
                        cur.pre = null;
                    }else if(cur.next == null) {
                        cur = cur.pre;
                        cur.next = null;
                    }else {
                        cur.pre.next = cur.next;
                        cur.next.pre = cur.pre;
                        cur = cur.next;
                    }
                    break;
                case "Z":
                    Node recover = stack.pop();
                    if(recover.pre == null) {  // head
                        recover.next.pre = recover;
                    } else if(recover.next == null) { // tail
                        recover.pre.next = recover;
                    } else {
                        recover.next.pre = recover;
                        recover.pre.next = recover;
                    }
                    break;
            }
        }

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            sb.replace(node.data, node.data + 1, "X");
        }
        return sb.toString();
    }
}
