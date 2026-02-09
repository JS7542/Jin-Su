import java.util.*;

class Solution {
    /*
     * s1의 문자 빈도와 같은 길이의 s2 슬라이딩 윈도우 빈도를 비교한다.
     * 윈도우를 한 칸씩 이동하며 빈도 배열이 같으면 순열이 포함된 것이다.
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] target = new int[26];
        int[] window = new int[26];

        for (char ch : s1.toCharArray()) target[ch - 'a']++;

        for (int index = 0; index < s2.length(); index++) {
            window[s2.charAt(index) - 'a']++;

            if (index >= s1.length()) {
                window[s2.charAt(index - s1.length()) - 'a']--;
            }

            if (index >= s1.length() - 1 && Arrays.equals(target, window)) {
                return true;
            }
        }

        return false;
    }
}
