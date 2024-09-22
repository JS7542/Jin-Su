import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬한다.
     * 가장 큰 두 수가 마지막 두 위치에 있으므로 두 값을 곱해 반환한다.
     */
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        return numbers[n - 1] * numbers[n - 2];
    }
}
