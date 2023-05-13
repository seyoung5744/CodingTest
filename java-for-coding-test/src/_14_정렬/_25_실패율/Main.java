package _14_정렬._25_실패율;

import java.util.*;

class Node implements Comparable<Node> {

    int stage;
    double fail;

    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage(){
        return stage;
    }

    @Override
    public int compareTo(Node other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

public class Main {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Node> nodes = new ArrayList<>();
        int length = stages.length;

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int stage : stages) {
                if (stage == i) {
                    count += 1;
                }
            }
            double fail = 0;
            if(length >= 1){
                fail = (double) count / length;
            }

            nodes.add(new Node(i, fail));
            length -= count;
        }

        Collections.sort(nodes);

        for (int i = 0; i < N; i++) {
            answer[i] = nodes.get(i).getStage();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(5, stages)));
    }

}
