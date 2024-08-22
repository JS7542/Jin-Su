import java.util.*;

class Solution {
    /*
     * 배열을 순서대로 보며 처음 등장한 값만 LinkedHashSet에 저장한다.
     * k개를 채우지 못한 남은 위치에는 -1을 넣는다.
     */
    public int[] solution(int[] arr, int k) {
        Set<Integer> unique = new LinkedHashSet<>();

        for (int number : arr) {
            unique.add(number);
            if (unique.size() == k) break;
        }

        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int index = 0;

        for (int number : unique) answer[index++] = number;
        return answer;
    }
}
