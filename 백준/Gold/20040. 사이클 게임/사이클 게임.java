import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        public int depth = 1;
        public Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public Node root() {
            if(parent == null) return this;
            return parent = parent.root();
        }

        public void merge(Node o){
            if(isConnected(o)) return;

            Node root1 = root();
            Node root2 = o.root();

            if(root1.depth < root2.depth) {
                root1.parent = root2;
            }else if (root1.depth > root2.depth) {
                root2.parent = root1;
            }else {
                root2.parent = root1;
                root1.depth += 1;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        int result = 0;

        for (int order = 1; order <= m; order++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(nodes[u].root() != nodes[v].root()){
                nodes[u].merge(nodes[v]);
            } else {
                result = order;
                break;
            }

        }

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }

}
