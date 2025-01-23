class Solution {
    /*
     * 12시간 형식에서 가능한 가장 큰 시각이 되도록 각 ?를 채운다.
     * 시의 앞뒤 자리와 분의 각 자리 범위를 함께 고려한다.
     */
    public String findLatestTime(String s) {
        char[] time = s.toCharArray();

        if (time[0] == '?') time[0] = time[1] == '?' || time[1] <= '1' ? '1' : '0';
        if (time[1] == '?') time[1] = time[0] == '1' ? '1' : '9';
        if (time[3] == '?') time[3] = '5';
        if (time[4] == '?') time[4] = '9';

        return new String(time);
    }
}
