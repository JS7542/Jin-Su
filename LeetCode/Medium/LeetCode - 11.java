class Solution {
    /*
     * 양 끝 높이로 만들 수 있는 넓이를 계산한다.
     * 더 낮은 쪽 포인터를 안쪽으로 이동해야 더 큰 높이를 기대할 수 있다.
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            answer = Math.max(answer, area);

            if (height[left] <= height[right]) left++;
            else right--;
        }

        return answer;
    }
}
