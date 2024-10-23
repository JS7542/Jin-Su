import java.util.*;

class Solution {
    /*
     * 짝수의 등장 횟수만 해시맵에 저장한다.
     * 빈도가 높고, 빈도가 같으면 값이 작은 짝수를 선택한다.
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = -1;
        int best = 0;

        for (int number : nums) {
            if (number % 2 == 1) continue;

            int frequency = count.getOrDefault(number, 0) + 1;
            count.put(number, frequency);

            if (frequency > best || (frequency == best && (answer == -1 || number < answer))) {
                best = frequency;
                answer = number;
            }
        }

        return answer;
    }
}
