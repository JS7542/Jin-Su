class Solution {
    /*
     * 새 배열의 i번째에 원본 배열의 뒤에서 i번째 값을 저장한다.
     * 모든 원소의 순서를 반대로 배치한 배열을 반환한다.
     */
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length - 1 - i];
        }
        return answer;
    }
}
