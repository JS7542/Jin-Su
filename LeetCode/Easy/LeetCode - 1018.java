import java.util.*;

class Solution {
    /*
     * 이전 이진수 값에 현재 비트를 붙이고 5로 나눈 나머지만 유지한다.
     * 각 접두사의 나머지가 0인지 결과 리스트에 저장한다.
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int remainder = 0;

        for (int bit : nums) {
            remainder = (remainder * 2 + bit) % 5;
            answer.add(remainder == 0);
        }

        return answer;
    }
}
