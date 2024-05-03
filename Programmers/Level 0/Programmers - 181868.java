class Solution {
    /*
     * 문자열 앞뒤 공백을 제거한 뒤 하나 이상의 공백을 기준으로 나눈다.
     * 분리된 단어 배열을 원래 등장 순서대로 반환한다.
     */
    public String[] solution(String my_string) {
        return my_string.trim().split("\\s+");
    }
}
