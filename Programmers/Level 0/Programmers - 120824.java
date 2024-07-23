class Solution {
    /*
     * 배열을 순회하며 각 원소를 2로 나눈 나머지를 확인한다.
     * 짝수 개수는 0번, 홀수 개수는 1번 인덱스에 저장한다.
     */
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int number : num_list) answer[number % 2]++;
        return answer;
    }
}
