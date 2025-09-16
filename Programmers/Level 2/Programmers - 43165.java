class Solution {
    /*
     * 각 숫자를 더하는 경우와 빼는 경우를 재귀적으로 탐색한다.
     * 모든 숫자를 사용했을 때 합이 target인 경로 수를 센다.
     */
    public int solution(int[] numbers, int target) {
        return search(numbers, target, 0, 0);
    }

    private int search(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) return sum == target ? 1 : 0;

        return search(numbers, target, index + 1, sum + numbers[index])
                + search(numbers, target, index + 1, sum - numbers[index]);
    }
}
