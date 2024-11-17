import java.util.*;

class Solution {
    /*
     * 모든 배열에서 각 숫자가 등장한 배열 수를 카운팅한다.
     * 등장 횟수가 전체 배열 개수와 같은 숫자를 오름차순으로 반환한다.
     */
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];

        for (int[] array : nums) {
            for (int number : array) count[number]++;
        }

        List<Integer> answer = new ArrayList<>();

        for (int number = 1; number < count.length; number++) {
            if (count[number] == nums.length) answer.add(number);
        }

        return answer;
    }
}
