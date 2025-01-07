class Solution {
    /*
     * 1개부터 시작해 매번 사탕 수를 하나씩 늘리며 사람들에게 순환 배분한다.
     * 남은 사탕보다 배분량이 크면 남은 사탕만 주고 종료한다.
     */
    public int[] distributeCandies(int candies, int numPeople) {
        int[] answer = new int[numPeople];
        int give = 1;
        int person = 0;

        while (candies > 0) {
            int amount = Math.min(give, candies);
            answer[person] += amount;
            candies -= amount;
            give++;
            person = (person + 1) % numPeople;
        }

        return answer;
    }
}
