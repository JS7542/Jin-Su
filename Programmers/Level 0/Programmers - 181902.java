class Solution {
    /*
     * 대문자는 0~25, 소문자는 26~51 인덱스에 빈도수를 저장한다.
     * 문자열의 모든 문자를 순회해 52칸 카운팅 배열을 반환한다.
     */
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for (char ch : my_string.toCharArray()) {
            if (Character.isUpperCase(ch)) answer[ch - 'A']++;
            else answer[ch - 'a' + 26]++;
        }

        return answer;
    }
}
