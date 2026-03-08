import java.util.*;

class Solution {
    /*
     * p의 문자 빈도와 길이가 같은 첫 윈도우의 빈도를 만든다.
     * 윈도우를 한 칸씩 이동하며 두 빈도 배열이 같으면 시작 인덱스를 추가한다.
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if (s.length() < p.length()) return answer;

        int[] target = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) target[ch - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            if (i >= p.length() - 1 && Arrays.equals(target, window)) {
                answer.add(i - p.length() + 1);
            }
        }

        return answer;
    }
}
