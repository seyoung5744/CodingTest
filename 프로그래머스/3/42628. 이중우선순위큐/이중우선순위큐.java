import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static class DoublyPriorityQueue {
        Queue<Integer> minPq = new PriorityQueue<>();
        Queue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        int size;
        
        public void add(int num){
            maxPq.add(num);
            minPq.add(num);
            size++;
        }
        
        public void removeMax() {
            if(size == 0) return;
            maxPq.poll();
            
            if(--size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }
        
        public void removeMin() {
            if(size == 0) return;
            minPq.poll();
            
            if(--size == 0){
                minPq.clear();
                maxPq.clear();
            }
        }
        
        public int max() {
            if(size == 0) return 0;
            return maxPq.peek();
        }
        
        public int min() {
            if(size == 0) return 0;
            return minPq.peek();
        }
        
    }
    public int[] solution(String[] operations) {
        DoublyPriorityQueue dpq = new DoublyPriorityQueue();
        
        for(String operation : operations){
            String[] op = operation.split(" ");
            switch(op[0]){
                case "I":
                    dpq.add(Integer.parseInt(op[1]));            
                    break;
                case "D":
                    if(op[1].equals("1")){
                        dpq.removeMax();
                    }else{
                        dpq.removeMin();
                    }
                    break;
            }
        }
        
        return new int[]{dpq.max(), dpq.min()};
    }

}
