class Solution {
    /*
     * 1부터 num까지 각 정수의 자리수 합을 계산한다.
     * 자리수 합이 짝수인 정수의 개수를 센다.
     */
    public int countEven(int num) {
        int answer = 0;

        for (int value = 1; value <= num; value++) {
            if (digitSum(value) % 2 == 0) answer++;
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
