class Solution {
    /*
     * 0부터 9까지의 전체 합 45에서 배열에 존재하는 숫자를 뺀다.
     * 남은 값이 배열에 없는 숫자들의 합이다.
     */
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) answer -= number;
        return answer;
    }
}
