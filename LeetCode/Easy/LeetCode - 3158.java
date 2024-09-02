import java.util.*;

class Solution {
    /*
     * 각 숫자의 등장 여부를 해시셋에 저장한다.
     * 두 번째로 등장한 숫자만 XOR 결과에 반영한다.
     */
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int answer = 0;

        for (int number : nums) {
            if (!seen.add(number)) answer ^= number;
        }

        return answer;
    }
}
