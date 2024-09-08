import java.util.*;

class Solution {
    /*
     * 세 수포자의 반복 답안 패턴과 정답을 비교해 맞힌 개수를 센다.
     * 최고 점수와 같은 수포자의 번호를 오름차순으로 반환한다.
     */
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int person = 0; person < 3; person++) {
                if (answers[i] == patterns[person][i % patterns[person].length]) score[person]++;
            }
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) if (score[i] == max) result.add(i + 1);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
