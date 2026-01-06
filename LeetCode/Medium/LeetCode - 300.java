class Solution {
    /*
     * 길이별 증가 부분수열의 가장 작은 마지막 값을 tails에 저장한다.
     * 각 숫자가 들어갈 첫 위치를 이분 탐색해 LIS 길이를 갱신한다.
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int length = 0;

        for (int number : nums) {
            int left = 0;
            int right = length;

            while (left < right) {
                int mid = (left + right) / 2;

                if (tails[mid] < number) left = mid + 1;
                else right = mid;
            }

            tails[left] = number;

            if (left == length) length++;
        }

        return length;
    }
}
