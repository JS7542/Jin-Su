import java.util.*;

class Solution {
    /*
     * 완호보다 두 점수가 모두 높은 사원이 있으면 완호는 인센티브 대상이 아니다.
     * 첫 점수 내림차순·둘째 점수 오름차순으로 정렬해 지배되지 않은 사원들의 합을 비교한다.
     */
    public int solution(int[][] scores) {
        int wanhoFirst = scores[0][0];
        int wanhoSecond = scores[0][1];
        int wanhoSum = wanhoFirst + wanhoSecond;

        for (int[] score : scores) {
            if (score[0] > wanhoFirst && score[1] > wanhoSecond) return -1;
        }

        Arrays.sort(scores, (first, second) -> {
            int compare = Integer.compare(second[0], first[0]);
            return compare != 0
                    ? compare
                    : Integer.compare(first[1], second[1]);
        });

        int maximumSecond = -1;
        int rank = 1;

        for (int[] score : scores) {
            if (score[1] < maximumSecond) continue;

            maximumSecond = Math.max(maximumSecond, score[1]);

            if (score[0] + score[1] > wanhoSum) rank++;
        }

        return rank;
    }
}
