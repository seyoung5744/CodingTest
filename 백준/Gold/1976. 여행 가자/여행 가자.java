import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

            if (root1.depth < root2.depth) {
                root1.parent = root2;
            } else if (root1.depth > root2.depth) {
                root2.parent = root1;
            } else {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            Node root = nodes[i];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());

                Node node = nodes[j];
                if (isConnect == 1 && !root.isConnected(node)) {
                    root.merge(node);
                }
            }
        }

        String[] trips = br.readLine().split(" ");

        Node root = nodes[Integer.parseInt(trips[0]) - 1];

        boolean flag = true;
        for (int i = 1; i < trips.length; i++) {
            int idx = Integer.parseInt(trips[i]);

            Node next = nodes[idx - 1];
            if (!root.isConnected(next)) {
                flag = false;
                break;
            }
        }

        if(flag){   
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
