class Solution {
    /*
     * 현재 문자와 다음 문자의 알파벳 거리 중 시계와 반시계 방향의 최소를 선택한다.
     * 이동 시간과 문자 입력 시간 1초를 각 문자마다 더한다.
     */
    public int minTimeToType(String word) {
        int answer = 0;
        char current = 'a';

        for (char ch : word.toCharArray()) {
            int distance = Math.abs(ch - current);
            answer += Math.min(distance, 26 - distance) + 1;
            current = ch;
        }

        return answer;
    }
}
