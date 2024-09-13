import java.util.*;

class Solution {
    /*
     * 1부터 n까지 각 수의 자리수 합을 구해 그룹별 빈도수를 센다.
     * 가장 큰 그룹 크기가 새로 나오면 개수를 초기화하고 같으면 증가시킨다.
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> count = new HashMap<>();
        int largest = 0;
        int answer = 0;

        for (int value = 1; value <= n; value++) {
            int sum = digitSum(value);
            int size = count.getOrDefault(sum, 0) + 1;
            count.put(sum, size);

            if (size > largest) {
                largest = size;
                answer = 1;
            } else if (size == largest) {
                answer++;
            }
        }

        return answer;
    }

    private int digitSum(int value) {
        int sum = 0;
        while (value > 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }
}
