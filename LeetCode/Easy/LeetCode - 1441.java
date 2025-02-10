import java.util.*;

class Solution {
    /*
     * 1부터 target의 마지막 값까지 숫자를 차례대로 읽는다.
     * 목표 값이면 Push만, 목표가 아니면 Push 후 Pop을 기록한다.
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int index = 0;

        for (int value = 1; value <= n && index < target.length; value++) {
            answer.add("Push");

            if (value == target[index]) {
                index++;
            } else {
                answer.add("Pop");
            }
        }

        return answer;
    }
}
