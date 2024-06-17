import java.util.*;

class Solution {
    /*
     * 사과 점수를 오름차순으로 정렬한다.
     * 높은 점수부터 m개씩 상자를 만들고 각 상자의 최저 점수로 이익을 계산한다.
     */
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;

        for (int index = score.length - m; index >= 0; index -= m) {
            answer += score[index] * m;
        }

        return answer;
    }
}
