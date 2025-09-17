class Solution {
    /*
     * 각 문자를 A에서 목표 문자로 바꾸는 최소 상하 이동을 더한다.
     * 연속된 A 구간을 기준으로 좌우 이동 경로를 비교해 최솟값을 구한다.
     */
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            int alphabet = name.charAt(i) - 'A';
            answer += Math.min(alphabet, 26 - alphabet);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') next++;

            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, i + (name.length() - next) * 2);
        }

        return answer + move;
    }
}
