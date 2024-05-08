import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> map = new HashMap<>();

        int idx = 0;

        for (long roomNum : room_number) {
            List<Long> temp = new ArrayList<>();

            while (true) {
                if (!map.containsKey(roomNum)) {
                    map.put(roomNum, roomNum + 1);
                    for (int i = 0; i < temp.size(); ++i) {
                        map.put(temp.get(i), roomNum + 1);
                    }
                    answer[idx++] = roomNum;
                    break;
                } else {
                    temp.add(roomNum);
                    roomNum = map.get(roomNum);
                }
            }
        }
        return answer;
    }
}
