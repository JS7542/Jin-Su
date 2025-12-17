import java.util.*;

class Solution {
    /*
     * 두 숫자 문자열 a와 b를 이어 붙인 ab, ba를 비교한다.
     * 더 큰 연결 결과가 앞에 오도록 정렬한 뒤 모두 이어 붙인다.
     */
    public String solution(int[] numbers) {
        String[] values = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) values[i] = String.valueOf(numbers[i]);

        Arrays.sort(values, (a, b) -> (b + a).compareTo(a + b));

        if (values[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (String value : values) answer.append(value);

        return answer.toString();
    }
}
