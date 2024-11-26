import java.util.*;

class Solution {
    /*
     * 각 정수를 문자열로 바꾸어 왼쪽 자리부터 읽는다.
     * 모든 자리수를 원래 순서대로 결과 리스트에 추가한다.
     */
    public int[] separateDigits(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int number : nums) {
            for (char ch : String.valueOf(number).toCharArray()) {
                answer.add(ch - '0');
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
