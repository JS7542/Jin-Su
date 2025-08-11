import java.util.*;

class Solution {
    /*
     * 이미 배정된 방은 다음으로 확인할 방 번호를 해시맵에 저장한다.
     * 경로 압축을 적용한 find로 요청 번호 이상의 가장 작은 빈 방을 찾는다.
     */
    private final Map<Long, Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int index = 0; index < room_number.length; index++) {
            long room = find(room_number[index]);
            answer[index] = room;
            parent.put(room, find(room + 1));
        }

        return answer;
    }

    private long find(long room) {
        if (!parent.containsKey(room)) return room;

        long empty = find(parent.get(room));
        parent.put(room, empty);

        return empty;
    }
}
