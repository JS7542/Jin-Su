class Solution {
    /*
     * 각 막대에 있는 빨강, 초록, 파랑 링을 비트로 표시한다.
     * 세 색 비트가 모두 켜진 막대의 개수를 센다.
     */
    public int countPoints(String rings) {
        int[] rods = new int[10];

        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';

            if (color == 'R') rods[rod] |= 1;
            else if (color == 'G') rods[rod] |= 2;
            else rods[rod] |= 4;
        }

        int answer = 0;
        for (int mask : rods) if (mask == 7) answer++;
        return answer;
    }
}
