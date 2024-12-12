class Solution {
    /*
     * 한 번의 게임에는 75원 동전 1개와 10원 동전 4개가 필요하다.
     * 가능한 게임 횟수의 홀짝으로 마지막 승자를 결정한다.
     */
    public String losingPlayer(int x, int y) {
        int games = Math.min(x, y / 4);
        return games % 2 == 1 ? "Alice" : "Bob";
    }
}
