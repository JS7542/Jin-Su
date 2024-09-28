class Solution {
    /*
     * 배열에서 k보다 작은 원소는 각각 한 번의 제거 연산이 필요하다.
     * k 미만 원소의 개수를 센다.
     */
    public int minOperations(int[] nums, int k) {
        int answer = 0;
        for (int number : nums) if (number < k) answer++;
        return answer;
    }
}
