import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
    }
}

class Tree{
    public Node root;

    public void createTree(int data){
        if(root == null){
            root = new Node(data);
        }else{
            insert(root, data);
        }
    }

    public void insert(Node node, int data){
        if(node == null) return;

        if(node.data > data){ // 왼쪽
            if(node.left == null){
                node.left = new Node(data);
            }else{
                insert(node.left, data);
            }
        }else{ // 오른쪽
            if(node.right == null){
                node.right = new Node(data);
            }else{
                insert(node.right, data);
            }
        }
    }

    public void postOrder(Node node, List<Integer> visits){
        if(node != null){
            postOrder(node.left, visits);
            postOrder(node.right, visits);
            visits.add(node.data);
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        String data ="";
        while((data = br.readLine()) != null){
            tree.createTree(Integer.parseInt(data));
        }

        List<Integer> post = new ArrayList<>();
        tree.postOrder(tree.root, post);

        post.stream().forEach(System.out::println);
    }
}
