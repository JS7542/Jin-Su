import java.util.*;

class Solution {
    /*
     * 세 자리 짝수를 순회하며 필요한 각 숫자의 빈도수를 센다.
     * 입력 digits의 빈도 안에서 만들 수 있는 숫자만 오름차순으로 반환한다.
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] available = new int[10];
        for (int digit : digits) available[digit]++;

        List<Integer> answer = new ArrayList<>();

        for (int value = 100; value <= 998; value += 2) {
            int[] need = new int[10];
            int number = value;

            while (number > 0) {
                need[number % 10]++;
                number /= 10;
            }

            boolean possible = true;
            for (int digit = 0; digit < 10; digit++) {
                if (need[digit] > available[digit]) {
                    possible = false;
                    break;
                }
            }

            if (possible) answer.add(value);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
