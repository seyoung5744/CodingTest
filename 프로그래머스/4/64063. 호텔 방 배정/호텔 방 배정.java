import java.util.*;

public class Solution {
    public static Map<Long, Long> roomInfo = new HashMap<>();

    private static long findEmptyRoom(long wantRoom) {
        if(!roomInfo.containsKey(wantRoom)) {
            roomInfo.put(wantRoom, wantRoom + 1);
            return wantRoom;
        }

        long nextRoom = roomInfo.get(wantRoom);
        long emptyRoom = findEmptyRoom(nextRoom);
        roomInfo.put(wantRoom, emptyRoom);
        return emptyRoom;
    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;
    }
}
