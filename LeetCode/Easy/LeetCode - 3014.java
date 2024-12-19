class Solution {
    /*
     * 여덟 개 키에는 첫 여덟 문자를 한 번, 다음 여덟 문자를 두 번 눌러 배치한다.
     * 문자 위치 그룹에 따른 누름 횟수를 모두 합산한다.
     */
    public int minimumPushes(String word) {
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            answer += i / 8 + 1;
        }

        return answer;
    }
}
