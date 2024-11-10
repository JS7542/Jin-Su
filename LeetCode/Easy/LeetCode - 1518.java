class Solution {
    /*
     * 현재 가진 가득 찬 병을 모두 마시고 빈 병으로 바꾼다.
     * 빈 병을 교환 가능한 만큼 새 물병으로 바꾸며 총 마신 병 수를 누적한다.
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0;
        int empty = 0;

        while (numBottles > 0) {
            answer += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty %= numExchange;
        }

        return answer;
    }
}
