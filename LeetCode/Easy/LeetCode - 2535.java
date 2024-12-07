class Solution {
    /*
     * 배열 원소의 합과 모든 원소 자리수의 합을 각각 계산한다.
     * 두 합의 절댓값 차이를 반환한다.
     */
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int number : nums) {
            elementSum += number;

            while (number > 0) {
                digitSum += number % 10;
                number /= 10;
            }
        }

        return Math.abs(elementSum - digitSum);
    }
}
