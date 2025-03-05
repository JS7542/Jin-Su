import java.util.*;

class Solution {
    /*
     * 같은 문자가 이어지는 구간의 시작과 끝을 찾는다.
     * 구간 길이가 3 이상이면 시작과 끝 인덱스를 결과에 추가한다.
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> answer = new ArrayList<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (end == s.length() - 1 || s.charAt(end) != s.charAt(end + 1)) {
                if (end - start + 1 >= 3) answer.add(Arrays.asList(start, end));
                start = end + 1;
            }
        }

        return answer;
    }
}
