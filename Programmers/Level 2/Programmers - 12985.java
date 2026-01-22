class Solution {
    /*
     * 각 라운드가 끝날 때 참가자 번호는 (번호+1)/2로 갱신된다.
     * 두 참가자 번호가 같아지는 라운드가 서로 만난 라운드다.
     */
    public int solution(int n, int a, int b) {
        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }
}
