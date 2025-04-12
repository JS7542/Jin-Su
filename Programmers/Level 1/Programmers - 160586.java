import java.util.*;

class Solution {
    /*
     * 각 문자별로 여러 키맵에서 누를 수 있는 최소 횟수를 저장한다.
     * 목표 문자열의 문자 횟수를 합산하고 입력할 수 없는 문자가 있으면 -1을 반환한다.
     */
    public int[] solution(String[] keymap, String[] targets) {
        int[] minimum = new int[26];
        Arrays.fill(minimum, Integer.MAX_VALUE);

        for (String keys : keymap) {
            for (int index = 0; index < keys.length(); index++) {
                int alphabet = keys.charAt(index) - 'A';
                minimum[alphabet] = Math.min(minimum[alphabet], index + 1);
            }
        }

        int[] answer = new int[targets.length];

        for (int targetIndex = 0; targetIndex < targets.length; targetIndex++) {
            int count = 0;

            for (char ch : targets[targetIndex].toCharArray()) {
                int presses = minimum[ch - 'A'];

                if (presses == Integer.MAX_VALUE) {
                    count = -1;
                    break;
                }

                count += presses;
            }

            answer[targetIndex] = count;
        }

        return answer;
    }
}
