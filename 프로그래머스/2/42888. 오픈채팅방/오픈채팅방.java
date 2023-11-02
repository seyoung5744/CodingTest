import java.util.*;

public class Solution {

    static class Cmd {
        String uuid;
        String command;

        public Cmd(String uuid, String command) {
            this.uuid = uuid;
            this.command = command;
        }
    }
    public static String[] solution(String[] records) {

        Deque<Cmd> queue = new ArrayDeque<>();
        List<String> answer = new ArrayList<>();

        Map<String, String> commands = new HashMap<>(){{
            put("Enter", "님이 들어왔습니다.");
            put("Leave", "님이 나갔습니다.");
        }};

        Map<String, String> map = new HashMap<>();

        for(String record : records) {
            String[] tokens = record.split(" ");
            String command = tokens[0];
            String uuid = tokens[1];
            String nickname = "";

            if(command.equals("Enter")) {
                nickname = tokens[2];
                map.put(uuid, nickname);
                queue.add(new Cmd(uuid, command));
            } else if(command.equals("Leave")) {
                queue.add(new Cmd(uuid, command));
            } else {
                nickname = tokens[2];
                map.put(uuid, nickname);
            }
        }

        while (!queue.isEmpty()){
            Cmd cmd = queue.poll();
            answer.add(map.get(cmd.uuid) + commands.get(cmd.command));
        }

        return answer.toArray(String[]::new);
    }

}
