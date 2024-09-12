class Solution {
    /*
     * w, s, d, a 명령을 각각 +1, -1, +10, -10으로 변환한다.
     * 모든 명령을 n에 순서대로 적용한 최종 값을 반환한다.
     */
    public int solution(int n, String control) {
        for (char command : control.toCharArray()) {
            if (command == 'w') n++;
            else if (command == 's') n--;
            else if (command == 'd') n += 10;
            else n -= 10;
        }

        return n;
    }
}
