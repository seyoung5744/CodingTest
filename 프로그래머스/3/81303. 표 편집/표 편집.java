import java.util.Stack;

public class Solution {

    static class Node {

        int num;
        Node prev;
        Node next;

        public Node(int num, Node prev, Node next) {
            this.num = num;
            this.prev = prev;
            this.next = next;
        }
    }

    private static Stack<Node> recentlyRemovedRow = new Stack<>();

    public static String solution(int n, int k, String[] cmd) {
        Node root = null;
        Node tail = null;
        Node cur = null;
        for (int i = 0; i < n; i++) {
            if (root == null) {
                root = new Node(i, null, null);
                tail = root;
            } else {
                tail.next = new Node(i, tail, null);
                tail = tail.next;
            }

            if (i == k) {
                cur = tail;
            }
        }

        for (String command : cmd) {
            String[] tokens = command.split(" ");
            int count = 0;
            if (tokens.length == 2) {
                count = Integer.parseInt(tokens[1]);
            }
            switch (tokens[0]) {
                case "D":
                    while (count > 0) {
                        cur = cur.next;
                        --count;
                    }
                    break;
                case "U":
                    while (count > 0) {
                        cur = cur.prev;
                        --count;
                    }
                    break;
                case "C":
                    recentlyRemovedRow.push(cur);

                    if (cur.prev != null) {
                        cur.prev.next = cur.next;
                    }

                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    }

                    if (cur.next == null) {
                        cur = cur.prev;
                    } else {
                        cur = cur.next;
                    }

                    break;
                case "Z":
                    Node recover = recentlyRemovedRow.pop();

                    if (recover.prev != null) {
                        recover.prev.next = recover;
                    }

                    if (recover.next != null) {
                        recover.next.prev = recover;
                    }

                    break;
            }
        }

        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!recentlyRemovedRow.isEmpty()) {
            Node p = recentlyRemovedRow.pop();
            answer.replace(p.num, p.num + 1, "X");
        }
        return answer.toString();
    }

}
