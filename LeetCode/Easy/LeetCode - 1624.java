import java.util.*;

class Solution {
    /*
     * 각 문자의 첫 등장 위치를 저장한다.
     * 같은 문자를 다시 만날 때 두 위치 사이 문자 개수의 최댓값을 구한다.
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int answer = -1;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (first[index] == -1) first[index] = i;
            else answer = Math.max(answer, i - first[index] - 1);
        }

        return answer;
    }
}
