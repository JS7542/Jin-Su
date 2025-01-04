class Solution {
    /*
     * 3의 배수가 아닌 원소는 1을 더하거나 빼는 한 번의 연산으로 배수가 된다.
     * 나머지가 0이 아닌 원소의 개수를 센다.
     */
    public int minimumOperations(int[] nums) {
        int answer = 0;
        for (int number : nums) if (number % 3 != 0) answer++;
        return answer;
    }
}
