import java.util.*;

public class Solution {
    static class Person {
        String name;
        int index;
        int present;
        int receive;
        int giftIndex;
        int get;

        public Person(String name, int index, int present, int receive, int giftIndex) {
            this.name = name;
            this.index = index;
            this.present = present;
            this.receive = receive;
            this.giftIndex = giftIndex;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", present=" + present +
                ", receive=" + receive +
                ", giftIndex=" + giftIndex +
                ", get=" + get +
                '}';
        }
    }

    public static int solution(String[] friends, String[] gifts) {

        int[][] graph = new int[friends.length][friends.length];
        Map<String, Person> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], new Person(friends[i], i, 0, 0, 0));
        }

        for(String gift : gifts) {
            String[] tokens = gift.split(" ");
            String to = tokens[0];
            String from = tokens[1];
            map.get(to).present++;
            map.get(from).receive++;

            graph[map.get(to).index][map.get(from).index]++;
        }

        for(String name : friends) {
            map.get(name).giftIndex = map.get(name).present - map.get(name).receive;
        }


        for (int i = 0; i < graph.length; i++) {
            String name = friends[i];

            for (int j = 0; j < graph.length; j++) {
                if(i != j) {
                    String receivedName = friends[j];
                    int gift = graph[i][j]; // 준 갯수
                    int receive = graph[j][i]; // 받은 갯수

                    if(gift > receive) { // 준 갯수가 더 많다면
                        map.get(name).get++;
                    }else if(gift == receive) { // 선물을 주고 받지 않았다면
                        // 선물 지수 검사
                        if(map.get(name).giftIndex > map.get(receivedName).giftIndex) {
                            map.get(name).get++;
                        }
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(String name : friends) {
            answer = Math.max(map.get(name).get, answer);
        }
        return answer;
    }


}
