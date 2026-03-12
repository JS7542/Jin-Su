import java.util.*;

class Solution {
    /*
     * 두 숫자 문자열 a, b는 ab와 ba 중 더 큰 순서로 정렬한다.
     * 정렬된 문자열을 이어 붙이고 첫 문자가 0이면 0을 반환한다.
     */
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length];

        for (int i = 0; i < nums.length; i++) values[i] = String.valueOf(nums[i]);

        Arrays.sort(values, (a, b) -> (b + a).compareTo(a + b));

        if (values[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String value : values) answer.append(value);
        return answer.toString();
    }
}
