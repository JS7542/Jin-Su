class Solution {
    /*
     * k번 동안 배열의 최솟값 중 가장 앞선 인덱스를 찾는다.
     * 해당 원소에 multiplier를 곱해 배열을 갱신한다.
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k-- > 0) {
            int minIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) minIndex = i;
            }

            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
