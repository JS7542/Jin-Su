class Solution {
    /*
     * 배열을 왼쪽부터 순회하며 음수인지 확인한다.
     * 처음 발견한 음수의 인덱스를 반환하고 없으면 -1을 반환한다.
     */
    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) return i;
        }
        return -1;
    }
}
