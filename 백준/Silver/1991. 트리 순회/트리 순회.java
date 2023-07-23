import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

class Node{
    public String value;
    public Node left;
    public Node right;

    public Node(String value) {
        this.value = value;
    }
}

class Tree{
    public Node root;

    public void createTree(String data, String leftData, String rightData){
        if(root == null){
            root = new Node(data);
            root.left = !Objects.equals(leftData, ".") ? new Node(leftData) : null;
            root.right = !Objects.equals(rightData, ".") ? new Node(rightData) : null;
        }else{
            insert(root, data, leftData, rightData);
        }
    }

    public void insert(Node node, String data, String leftData, String rightData){
        if(node == null) return;

        if(node.value.equals(data)){
            node.left = !Objects.equals(leftData, ".")? new Node(leftData) : null;
            node.right = !Objects.equals(rightData, ".")? new Node(rightData) : null;
        }else{
            insert(node.left, data, leftData, rightData);
            insert(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node, List<String> visits){
        if(node != null){
            visits.add(node.value);
            preOrder(node.left, visits);
            preOrder(node.right, visits);
        }
    }

    public void inOrder(Node node, List<String> visits){
        if(node != null){
            inOrder(node.left, visits);
            visits.add(node.value);
            inOrder(node.right, visits);
        }
    }

    public void postOrder(Node node, List<String> visits){
        if(node != null){
            postOrder(node.left, visits);
            postOrder(node.right, visits);
            visits.add(node.value);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.createTree(cur, left, right);
        }

        List<String> preOrder = new ArrayList<>();
        tree.preOrder(tree.root, preOrder);
        List<String> inOrder = new ArrayList<>();
        tree.inOrder(tree.root, inOrder);
        List<String> postOrder = new ArrayList<>();
        tree.postOrder(tree.root, postOrder);

        preOrder.stream().forEach(System.out::print);
        System.out.println();
        inOrder.stream().forEach(System.out::print);
        System.out.println();
        postOrder.stream().forEach(System.out::print);
        System.out.println();
    }
}