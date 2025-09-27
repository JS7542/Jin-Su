import java.util.*;

class Solution {
    /*
     * 미사일 구간을 끝점 오름차순으로 정렬한다.
     * 현재 요격 위치와 겹치지 않는 구간을 만나면 그 구간 끝점 직전에 새 요격 미사일을 배치한다.
     */
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(target -> target[1]));

        int answer = 0;
        int interceptionEnd = Integer.MIN_VALUE;

        for (int[] target : targets) {
            if (target[0] >= interceptionEnd) {
                answer++;
                interceptionEnd = target[1];
            }
        }

        return answer;
    }
}
