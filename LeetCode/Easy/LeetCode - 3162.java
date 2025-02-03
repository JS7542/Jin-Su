class Solution {
    /*
     * nums1과 nums2의 모든 원소 쌍을 확인한다.
     * nums1[i]가 nums2[j]×k로 나누어떨어지는 쌍을 센다.
     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int answer = 0;

        for (int first : nums1) {
            for (int second : nums2) {
                if (first % (second * k) == 0) answer++;
            }
        }

        return answer;
    }
}
