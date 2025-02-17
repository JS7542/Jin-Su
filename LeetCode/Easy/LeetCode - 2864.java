class Solution {
    /*
     * 문자열의 1 개수를 센다.
     * 마지막 자리에 1을 두고 나머지 1을 앞쪽에 배치해 가장 큰 홀수를 만든다.
     */
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for (char ch : s.toCharArray()) if (ch == '1') ones++;

        return "1".repeat(ones - 1)
                + "0".repeat(s.length() - ones)
                + "1";
    }
}
