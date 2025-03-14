import java.util.*;

class Solution {
    /*
     * 학생 위치와 좌석 위치를 각각 오름차순으로 정렬한다.
     * 같은 순서의 학생과 좌석 거리 절댓값을 모두 더한다.
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int answer = 0;

        for (int i = 0; i < seats.length; i++) {
            answer += Math.abs(seats[i] - students[i]);
        }

        return answer;
    }
}
