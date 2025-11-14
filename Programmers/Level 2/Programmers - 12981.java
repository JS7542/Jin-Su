import java.util.*;

class Solution {
    /*
     * 이미 사용한 단어와 직전 단어의 마지막 문자를 확인한다.
     * 규칙 위반 위치를 사람 번호와 차례 번호로 변환해 반환한다.
     */
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            boolean invalid = words[i - 1].charAt(words[i - 1].length() - 1)
                    != words[i].charAt(0)
                    || !used.add(words[i]);

            if (invalid) {
                return new int[]{i % n + 1, i / n + 1};
            }
        }

        return new int[]{0, 0};
    }
}
