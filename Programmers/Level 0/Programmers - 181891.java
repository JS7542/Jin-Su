class Solution {
    /*
     * n번째 인덱스부터 끝까지를 먼저 결과에 저장한다.
     * 이어서 처음부터 n-1번째 인덱스까지를 뒤에 붙인다.
     */
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int index = 0;

        for (int i = n; i < num_list.length; i++) answer[index++] = num_list[i];
        for (int i = 0; i < n; i++) answer[index++] = num_list[i];

        return answer;
    }
}
