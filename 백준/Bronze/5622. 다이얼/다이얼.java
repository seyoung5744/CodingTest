import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, List<String>> nums = new HashMap<>();
        nums.put(2, Arrays.asList("A","B","C"));
        nums.put(3, Arrays.asList("D","E","F"));
        nums.put(4, Arrays.asList("G","H","I"));
        nums.put(5, Arrays.asList("J","K","L"));
        nums.put(6, Arrays.asList("M","N","O"));
        nums.put(7, Arrays.asList("P","Q","R","S"));
        nums.put(8, Arrays.asList("T","U","V"));
        nums.put(9, Arrays.asList("W","X","Y","Z"));


       String str = sc.next();
       int result = 0;
       for(String s : str.split("")){
           for(Map.Entry<Integer, List<String>> entry: nums.entrySet()){
               if(entry.getValue().contains(s)){
                    result += entry.getKey() + 1;
               }
           }
       }

        System.out.println(result);
    }
}
