
import java.util.*;

public class Solution {

    static class User {

        public String status;
        public String id;

        public User(String status, String id) {
            this.status = status;
            this.id = id;
        }
    }

    public static List<User> list = new ArrayList<>();
    public static Map<String, String> nicknameMap = new HashMap<>();

    public String[] solution(String[] records) {
        for (String record : records) {
            String[] tokens = record.split(" ");
            String status = tokens[0];
            String id = tokens[1];

            if(status.equals("Enter") || status.equals("Change")) {
                String nickname = tokens[2];

                nicknameMap.put(id, nickname);
            }

            if(!status.equals("Change"))
                list.add(new User(status, id));
        }

        return print().toArray(new String[0]);
    }

    public static List<String> print() {
        List<String> answer = new ArrayList<>();
        for (User user : list) {
            if(user.status.equals("Enter")) {
                answer.add(nicknameMap.get(user.id) + "님이 들어왔습니다.");
            } else {
                answer.add(nicknameMap.get(user.id) + "님이 나갔습니다.");
            }
        }
        return answer;
    }

}
