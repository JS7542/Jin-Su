class Solution {
    /*
     * 양 끝 포인터와 각 방향의 최대 높이를 유지한다.
     * 더 낮은 쪽을 이동하며 현재 최대 높이와의 차이를 물의 양에 더한다.
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int answer = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                answer += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                answer += rightMax - height[right];
                right--;
            }
        }

        return answer;
    }
}
