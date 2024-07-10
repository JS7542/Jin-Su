class Solution {
    /*
     * 목표 단어를 순서대로 확인하며 두 카드 뭉치의 현재 맨 앞 단어와 비교한다.
     * 어느 뭉치에서도 꺼낼 수 없는 단어가 나오면 No를 반환한다.
     */
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int first = 0;
        int second = 0;

        for (String word : goal) {
            if (first < cards1.length && cards1[first].equals(word)) {
                first++;
            } else if (second < cards2.length && cards2[second].equals(word)) {
                second++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
