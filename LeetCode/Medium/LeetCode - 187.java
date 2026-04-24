import java.util.*;

class Solution {
    /*
     * 길이 10인 모든 부분문자열의 등장 횟수를 해시셋으로 추적한다.
     * 두 번째로 등장한 문자열만 결과 집합에 추가해 중복 출력을 막는다.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int start = 0; start + 10 <= s.length(); start++) {
            String sequence = s.substring(start, start + 10);

            if (!seen.add(sequence)) repeated.add(sequence);
        }

        return new ArrayList<>(repeated);
    }
}
