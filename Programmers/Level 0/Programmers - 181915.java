class Solution {
    /*
     * index_list에 기록된 인덱스 순서대로 문자를 선택한다.
     * 선택한 문자를 이어 붙인 문자열을 반환한다.
     */
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();

        for (int index : index_list) answer.append(my_string.charAt(index));
        return answer.toString();
    }
}
