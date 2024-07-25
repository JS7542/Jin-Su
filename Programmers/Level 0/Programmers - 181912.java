import java.util.*;

class Solution {
    /*
     * 각 숫자 문자열의 s 위치부터 길이 l만큼 잘라 정수로 변환한다.
     * 변환값이 k보다 큰 경우만 결과 배열에 추가한다.
     */
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();

        for (String text : intStrs) {
            int value = Integer.parseInt(text.substring(s, s + l));
            if (value > k) answer.add(value);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
