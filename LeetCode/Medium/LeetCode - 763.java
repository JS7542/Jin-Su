import java.util.*;

class Solution {
    /*
     * 각 문자의 마지막 등장 위치를 미리 저장한다.
     * 현재 구간 안 문자의 마지막 위치 최댓값까지 확장하고 그 지점에서 구간을 닫는다.
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        for (int index = 0; index < s.length(); index++) {
            last[s.charAt(index) - 'a'] = index;
        }

        List<Integer> answer = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int index = 0; index < s.length(); index++) {
            end = Math.max(end, last[s.charAt(index) - 'a']);

            if (index == end) {
                answer.add(end - start + 1);
                start = index + 1;
            }
        }

        return answer;
    }
}
