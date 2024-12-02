class Solution {
    /*
     * 최근 두 번 안에 10점을 기록했다면 현재 점수를 두 배로 계산한다.
     * 두 선수의 총점을 비교해 승자 번호 또는 무승부 0을 반환한다.
     */
    public int isWinner(int[] player1, int[] player2) {
        int first = score(player1);
        int second = score(player2);

        if (first == second) return 0;
        return first > second ? 1 : 2;
    }

    private int score(int[] rolls) {
        int total = 0;

        for (int i = 0; i < rolls.length; i++) {
            boolean doubled = (i > 0 && rolls[i - 1] == 10)
                    || (i > 1 && rolls[i - 2] == 10);
            total += doubled ? rolls[i] * 2 : rolls[i];
        }

        return total;
    }
}
