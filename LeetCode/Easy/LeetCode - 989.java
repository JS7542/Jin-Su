import java.util.*;

class Solution {
    /*
     * 배열의 마지막 자리부터 k를 더하며 각 자리와 올림을 계산한다.
     * 낮은 자리부터 저장한 결과를 마지막에 뒤집는다.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<>();
        int index = num.length - 1;

        while (index >= 0 || k > 0) {
            if (index >= 0) k += num[index--];
            answer.add(k % 10);
            k /= 10;
        }

        Collections.reverse(answer);
        return answer;
    }
}
