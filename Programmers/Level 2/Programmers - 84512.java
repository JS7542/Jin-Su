class Solution {
    /*
     * 각 자리에서 현재 문자보다 앞선 모음 개수에 남은 조합 수 가중치를 곱한다.
     * 현재 단어 자체의 위치를 위해 각 자리마다 1을 더한다.
     */
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            answer += vowels.indexOf(word.charAt(i)) * weights[i] + 1;
        }

        return answer;
    }
}
