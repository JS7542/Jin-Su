class Solution {
    /*
     * 왼쪽 원소 곱을 결과 배열에 먼저 저장한다.
     * 오른쪽에서 누적 곱을 유지하며 각 위치의 왼쪽 곱과 곱한다.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}
