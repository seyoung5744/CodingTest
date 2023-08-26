import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static class Node {

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
                root2.depth += root1.depth;
            } else {
                root2.parent = root1;
                root1.depth += root2.depth;
            }
        }

        public Node root() {
            if (parent == null) {
                return this;
            }
            return parent = parent.root();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int F = Integer.parseInt(br.readLine());
            Map<String, Node> graph = new HashMap<>();

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if (!graph.containsKey(friend1)) {
                    graph.putIfAbsent(friend1, new Node());
                }

                if (!graph.containsKey(friend2)) {
                    graph.putIfAbsent(friend2, new Node());
                }

                if(graph.get(friend1).root() != graph.get(friend2).root())
                    graph.get(friend1).merge(graph.get(friend2));

                System.out.println(graph.get(friend1).root().depth);
            }
        }
    }

}
