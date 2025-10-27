import java.util.*;

class Solution {
    /*
     * 사용자 아이디별 최종 닉네임을 먼저 저장한다.
     * 입장·퇴장 기록만 순서대로 보관한 뒤 최종 닉네임으로 메시지를 생성한다.
     */
    public String[] solution(String[] record) {
        Map<String, String> names = new HashMap<>();
        List<String[]> events = new ArrayList<>();

        for (String line : record) {
            String[] parts = line.split(" ");

            if (!parts[0].equals("Leave")) {
                names.put(parts[1], parts[2]);
            }

            if (!parts[0].equals("Change")) {
                events.add(new String[]{parts[0], parts[1]});
            }
        }

        String[] answer = new String[events.size()];

        for (int i = 0; i < events.size(); i++) {
            String action = events.get(i)[0];
            String user = events.get(i)[1];

            answer[i] = names.get(user)
                    + (action.equals("Enter")
                    ? "님이 들어왔습니다."
                    : "님이 나갔습니다.");
        }

        return answer;
    }
}
