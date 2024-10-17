import java.util.*;

class Solution {
    /*
     * 배열 값을 해시셋에 저장한다.
     * 현재 값+d와 현재 값+2d가 모두 존재하는 경우를 센다.
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> values = new HashSet<>();
        for (int number : nums) values.add(number);

        int answer = 0;

        for (int number : nums) {
            if (values.contains(number + diff) && values.contains(number + diff * 2)) {
                answer++;
            }
        }

        return answer;
    }
}
