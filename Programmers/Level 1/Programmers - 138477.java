import java.util.*;

class Solution {
    /*
     * 크기 k의 최소 힙에 현재까지의 명예 점수를 유지한다.
     * 매일 점수를 넣고 k개를 넘으면 최솟값을 제거한 뒤 힙의 최솟값을 기록한다.
     */
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> hall = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int day = 0; day < score.length; day++) {
            hall.offer(score[day]);
            if (hall.size() > k) hall.poll();
            answer[day] = hall.peek();
        }

        return answer;
    }
}
