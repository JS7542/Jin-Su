class Solution {
    /*
     * 문자열에서 0을 제거한 뒤 남은 길이를 이진수로 변환한다.
     * 문자열이 1이 될 때까지 반복 횟수와 제거한 0 개수를 누적한다.
     */
    public int[] solution(String s) {
        int conversions = 0;
        int removedZeros = 0;

        while (!s.equals("1")) {
            int ones = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '1') ones++;
                else removedZeros++;
            }

            s = Integer.toBinaryString(ones);
            conversions++;
        }

        return new int[]{conversions, removedZeros};
    }
}
