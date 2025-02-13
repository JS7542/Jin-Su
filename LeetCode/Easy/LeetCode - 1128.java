import java.util.*;

class Solution {
    /*
     * 도미노 두 값을 작은 값과 큰 값 순서로 정규화해 하나의 키로 만든다.
     * 같은 키가 이전에 등장한 횟수만큼 새로운 쌍이 만들어진다.
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (int[] domino : dominoes) {
            int first = Math.min(domino[0], domino[1]);
            int second = Math.max(domino[0], domino[1]);
            int key = first * 10 + second;

            answer += count.getOrDefault(key, 0);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        return answer;
    }
}
