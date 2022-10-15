import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        if(cacheSize == 0){
            return cities.length*5;
        }
        int idx = 0;
        String preCity = "";
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(list.size() < cacheSize){
                if(list.contains(city)){
                    idx = list.indexOf(city);
                    preCity = list.remove(idx);
                    list.add(preCity);
                    answer+=1;
                }else {
                    list.add(city);
                    answer += 5;
                }
            }else if(list.size() == cacheSize){
                if(list.contains(city)){
                    idx = list.indexOf(city);
                    preCity = list.remove(idx);
                    list.add(preCity);
                    answer+=1;
                }else{
                    list.poll();
                    list.offer(city);
                    answer+=5;
                }
            }
            // System.out.println(list);
        }
        return answer;
    }
}