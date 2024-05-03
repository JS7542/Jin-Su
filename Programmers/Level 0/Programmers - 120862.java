import java.util.*;

class Solution {
    /*
     * 정렬 후 가장 큰 두 수의 곱과 가장 작은 두 수의 곱을 비교한다.
     * 음수 두 개의 곱도 클 수 있으므로 두 후보 중 큰 값을 반환한다.
     */
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        return Math.max(numbers[0] * numbers[1], numbers[n - 1] * numbers[n - 2]);
    }
}
