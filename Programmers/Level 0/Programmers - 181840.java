class Solution {
    /*
     * 정수 배열을 순회하며 찾을 값 n과 같은 원소가 있는지 확인한다.
     * 존재하면 1, 끝까지 없으면 0을 반환한다.
     */
    public int solution(int[] num_list, int n) {
        for (int number : num_list) {
            if (number == n) return 1;
        }
        return 0;
    }
}
