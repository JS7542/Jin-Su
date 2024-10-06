class Solution {
    /*
     * 세로줄을 만날 때마다 현재 위치가 막대 내부인지 외부인지 전환한다.
     * 막대 바깥에 있는 별표 문자만 개수를 센다.
     */
    public int countAsterisks(String s) {
        boolean inside = false;
        int answer = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '|') inside = !inside;
            else if (ch == '*' && !inside) answer++;
        }

        return answer;
    }
}
