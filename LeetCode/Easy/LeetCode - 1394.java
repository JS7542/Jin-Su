import java.util.*;

class Solution {
    /*
     * 각 정수의 등장 횟수를 해시맵에 저장한다.
     * 값과 빈도수가 같은 숫자 중 가장 큰 값을 반환한다.
     */
    public int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : arr) count.put(number, count.getOrDefault(number, 0) + 1);

        int answer = -1;
        for (int number : count.keySet()) {
            if (number == count.get(number)) answer = Math.max(answer, number);
        }

        return answer;
    }
}
