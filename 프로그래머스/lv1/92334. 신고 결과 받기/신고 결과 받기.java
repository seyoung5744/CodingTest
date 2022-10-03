import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String> > user = new HashMap<>(); // 피신고자 : 신고자
        HashMap<String, Integer> reportedNum = new HashMap<>();
        // 초기화
        for (String id : id_list){
            user.put(id, new HashSet<>());
            reportedNum.put(id,0);
        }

        // 피신고자 : 신고자
        // 신고자 쪽이 set 이니깐 신고자가 중복되면 자동 중복 제거
        for (String report : reports){
            String userID = report.split(" ")[0];
            String reportedID = report.split(" ")[1];
            user.get(reportedID).add(userID);
        }

        for (String id : id_list){
            if(user.get(id).size() >= k) {
                for (String name : user.get(id)) {
                    reportedNum.put(name, reportedNum.get(name) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reportedNum.get(id_list[i]);
        }
        return answer;
    }
}