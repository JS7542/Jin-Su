class Solution {
    /*
     * 각 정수를 문자열로 변환해 자리수 길이를 확인한다.
     * 자리수 개수가 짝수인 숫자의 개수를 센다.
     */
    public int findNumbers(int[] nums) {
        int answer = 0;

        for (int number : nums) {
            if (String.valueOf(number).length() % 2 == 0) answer++;
        }

        return answer;
    }
}
