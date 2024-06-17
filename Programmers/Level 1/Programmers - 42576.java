import java.util.*;

class Solution {
    /*
     * 참가자 이름별 인원수를 해시맵에 저장한다.
     * 완주자 이름의 수를 감소시킨 뒤 남은 이름을 반환한다.
     */
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();
        for (String name : participant) count.put(name, count.getOrDefault(name, 0) + 1);
        for (String name : completion) count.put(name, count.get(name) - 1);

        for (String name : count.keySet()) {
            if (count.get(name) > 0) return name;
        }
        return "";
    }
}
