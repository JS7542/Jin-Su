class Solution {
    /*
     * 같은 숫자를 두 번 XOR하면 0이 되고 0과 숫자를 XOR하면 숫자가 남는다.
     * 모든 원소를 XOR해 한 번만 등장한 값을 구한다.
     */
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int number : nums) answer ^= number;
        return answer;
    }
}
