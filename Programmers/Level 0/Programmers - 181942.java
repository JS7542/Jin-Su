class Solution {
    /*
     * 두 문자열의 같은 인덱스 문자를 번갈아 결과에 추가한다.
     * str1 문자 다음에 str2 문자가 오도록 섞은 문자열을 반환한다.
     */
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str1.length(); i++) {
            answer.append(str1.charAt(i)).append(str2.charAt(i));
        }

        return answer.toString();
    }
}
