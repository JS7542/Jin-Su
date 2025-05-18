import java.util.*;

class Solution {
    /*
     * 가능한 모든 시각을 순회하며 시와 분의 1비트 개수를 합산한다.
     * 합이 turnedOn과 같은 시각만 문제 형식의 문자열로 추가한다.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    answer.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }

        return answer;
    }
}
