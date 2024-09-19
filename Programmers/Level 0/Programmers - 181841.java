class Solution {
    /*
     * 문자열 배열에서 ex가 포함되지 않은 문자열만 선택한다.
     * 선택된 문자열을 순서대로 이어 붙여 반환한다.
     */
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();

        for (String text : str_list) {
            if (!text.contains(ex)) answer.append(text);
        }

        return answer.toString();
    }
}
