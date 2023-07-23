import java.util.PriorityQueue;
class Solution {
    private static class DoublyPriorityQueue{
        private int size = 0;
        private PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);

        public void add(int data){
            minPq.add(data);
            maxPq.add(data);
            size++;
        }

        public void removeMax(){
            if(size == 0) return;
            maxPq.poll();

            if(--size == 0){
                maxPq.clear();
                minPq.clear();
            }
        }

        public void removeMin(){
            if(size == 0) return;
            minPq.poll();

            if(--size == 0){
                minPq.clear();
                maxPq.clear();
            }
        }

        public int max(){
            if(size == 0) return 0;
            return maxPq.peek();
        }

        public int min(){
            if(size == 0) return 0;
            return minPq.peek();
        }
    }
    public int[] solution(String[] operations) {

        DoublyPriorityQueue dpq = new DoublyPriorityQueue();

        for(String operation : operations){
            String[] tokens = operation.split(" ");
            String command = tokens[0];
            String value = tokens[1];

            switch (command){
                case "I":
                    dpq.add(Integer.parseInt(value));
                    break;
                case "D":
                    if(value.equals("1")){
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