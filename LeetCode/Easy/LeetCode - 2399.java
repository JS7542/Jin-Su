import java.util.*;

class Solution {
    /*
     * 각 문자의 첫 등장 위치를 저장한다.
     * 두 번째 등장 시 사이 문자 수가 distance 값과 같은지 확인한다.
     */
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (first[index] == -1) first[index] = i;
            else if (i - first[index] - 1 != distance[index]) return false;
        }

        return true;
    }
}
